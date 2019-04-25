package com.tinytongtong.thirdpartylibrarystudy.leakcanary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tinytongtong.thirdpartylibrarystudy.R;

/**
 * @Description: 非静态内部类的静态实例造成的内存泄漏
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/25 11:15 PM
 * @Version TODO
 */
public class NonStaticInnerClassLeakActivity extends AppCompatActivity {
    private static NonStaticClass mResource;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, NonStaticInnerClassLeakActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_static_inner_class_leak);

        mResource = new NonStaticClass();
    }

    private static class NonStaticClass {

    }
}
