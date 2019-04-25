package com.tinytongtong.thirdpartylibrarystudy.leakcanary;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tinytongtong.thirdpartylibrarystudy.R;

import java.lang.ref.WeakReference;

public class WeakReferenceActivity extends AppCompatActivity {

    public static final String TAG = WeakReferenceActivity.class.getSimpleName();
    private Handler handler;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, WeakReferenceActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weak_reference);

        handler = new Handler();
    }

    public void post(View view) {
        handler.postDelayed(new RunnableDelegate(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "Delayed running");
            }
        }), 5000);
        Runtime.getRuntime().gc();
        System.gc();
    }

    public static class RunnableDelegate implements Runnable {
        private final WeakReference<Runnable> mReference;

        public RunnableDelegate(Runnable runnable) {
            this.mReference = new WeakReference<>(runnable);
        }

        @Override
        public void run() {
            Runnable runnable = mReference.get();
            if (runnable != null) {
                runnable.run();
            } else {
                Log.e(TAG, "runnable already recycled");
            }
        }
    }
}
