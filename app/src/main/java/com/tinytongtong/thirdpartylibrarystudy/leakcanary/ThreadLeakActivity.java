package com.tinytongtong.thirdpartylibrarystudy.leakcanary;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tinytongtong.thirdpartylibrarystudy.R;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Description: 线程造成的内存泄漏
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/25 11:36 PM
 * @Version
 */
public class ThreadLeakActivity extends AppCompatActivity {
    public static final String TAG = ThreadLeakActivity.class.getSimpleName();

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, ThreadLeakActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_leak);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_leak_by_runnable)
    public void onBtnLeakByRunnableClicked() {
        new Thread(new MyRunnable()).start();
    }

    @OnClick(R.id.btn_lead_by_asynctask)
    public void onBtnLeadByAsynctaskClicked() {
        new MyAsyncTask(this).execute();
    }

    private void test() {
        Log.e(TAG, "test");
    }


    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            SystemClock.sleep(10000);
        }
    }

    static class MyAsyncTask extends AsyncTask<Void, Void, Void> {
        private WeakReference<Context> weakReference;

        public MyAsyncTask(Context context) {
            this.weakReference = new WeakReference<>(context);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            SystemClock.sleep(10000);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ThreadLeakActivity context = (ThreadLeakActivity) weakReference.get();
            if (context != null) {
                context.test();
            } else {
                Log.e(TAG, "ThreadLeakActivity already recycled");
            }
        }
    }
}
