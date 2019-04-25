package com.tinytongtong.thirdpartylibrarystudy;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/22 11:23 PM
 * @Version TODO
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
