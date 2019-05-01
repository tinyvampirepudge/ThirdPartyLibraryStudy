package com.tinytongtong.thirdpartylibrarystudy.leakcanary;

import android.content.Context;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: Static方法导致的内存泄漏
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/25 10:36 PM
 * @Version TODO
 */
public class StaticUtil {
    private static final String TAG = StaticUtil.class.getSimpleName();
    private static Context mContext;

    public static void test1(Context context) {
        String result = context.getPackageName();
        Log.e(TAG, result);
    }

    public static void test2(Context context) {
        mContext = context;
        String result = mContext.getPackageName();
        Log.e(TAG, result);
        List<String> simpleList = Arrays.asList("Hello","world");

//        List<String> simpleList = List.of("Hello","world");
    }
}
