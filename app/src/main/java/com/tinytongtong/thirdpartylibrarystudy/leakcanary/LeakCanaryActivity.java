package com.tinytongtong.thirdpartylibrarystudy.leakcanary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.tinytongtong.thirdpartylibrarystudy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LeakCanaryActivity extends AppCompatActivity {
    @BindView(R.id.btn_weak_reference)
    Button btnWeakReference;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, LeakCanaryActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_canary);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_weak_reference)
    public void onViewClicked() {
        WeakReferenceActivity.actionStart(this);
    }

    @OnClick(R.id.btn_static_method)
    public void onBtnStaticMethodClicked() {
        StaticUtil.test1(this);
    }

    @OnClick(R.id.btn_static_field)
    public void onBtnStaticFieldClicked() {
        StaticUtil.test2(this);
    }

    @OnClick(R.id.btn_leak_by_singleton)
    public void onBtnLeakBySingletonClicked() {
        SingletonActivityContext.getInstance(this).test();
    }

    @OnClick(R.id.btn_leak_by_non_static_inner_class)
    public void onBtnLeakByNonStaticInnerClassClicked() {
        NonStaticInnerClassLeakActivity.actionStart(this);
    }

    @OnClick(R.id.btn_leak_by_handler)
    public void onBtnLeakByHandlerClicked() {
        HandlerLeakActivity.actionStart(this);
    }

    @OnClick(R.id.btn_leak_by_thread)
    public void onBtnLeakByThreadClicked() {
        ThreadLeakActivity.actionStart(this);
    }

    @OnClick(R.id.btn_leak_by_webview)
    public void onBtnLeakByWebviewClicked() {
        WebviewLeakActivity.actionStart(this);
    }
}