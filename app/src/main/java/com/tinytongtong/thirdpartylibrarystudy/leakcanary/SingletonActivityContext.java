package com.tinytongtong.thirdpartylibrarystudy.leakcanary;

import android.content.Context;
import android.util.Log;

/**
 * @Description: 单例造成的内存泄漏
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/25 9:29 PM
 * @Version TODO
 */
public class SingletonActivityContext {
    private static SingletonActivityContext instance;
    private Context context;

    public SingletonActivityContext(Context context) {
//        this.context = context;
        this.context = context.getApplicationContext();
    }

    public static SingletonActivityContext getInstance(Context context) {
        if (instance == null) {
            instance = new SingletonActivityContext(context);
        }
        return instance;
    }

    public void test(){
        System.out.println("SingletonActivityContext");
    }
}
