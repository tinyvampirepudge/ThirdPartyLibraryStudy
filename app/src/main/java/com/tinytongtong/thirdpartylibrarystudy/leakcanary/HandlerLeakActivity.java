package com.tinytongtong.thirdpartylibrarystudy.leakcanary;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tinytongtong.thirdpartylibrarystudy.R;

import java.lang.ref.WeakReference;

/**
 * @Description: Handler造成的内存泄漏
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/25 11:13 PM
 * @Version TODO
 */
public class HandlerLeakActivity extends AppCompatActivity {
    public static final String TAG = HandlerLeakActivity.class.getSimpleName();
    private static Handler handler = new Handler();

    private Runnable runnable;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, HandlerLeakActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_leak);

        handler.postDelayed(new MyRunnable(this), 10 * 1000);
    }

    private static class MyRunnable implements Runnable{

        private WeakReference<HandlerLeakActivity> mReference;

        public MyRunnable(HandlerLeakActivity activity) {
            this.mReference = new WeakReference<>(activity);
        }

        @Override
        public void run() {
            HandlerLeakActivity handlerLeakActivity = mReference.get();
            if (handlerLeakActivity!=null){
                handlerLeakActivity.print();
            }else{
                Log.e(TAG,"HandlerLeakActivity already recycled");
            }
        }
    }

    private void print() {
        Log.e(TAG, "print");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        handler.removeCallbacks(runnable);
    }
}
