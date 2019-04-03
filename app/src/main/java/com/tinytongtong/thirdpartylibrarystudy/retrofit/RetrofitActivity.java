package com.tinytongtong.thirdpartylibrarystudy.retrofit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tinytongtong.thirdpartylibrarystudy.R;
import com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.ProxyActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RetrofitActivity extends AppCompatActivity {
    public static void actionStart(Context context) {
        Intent starter = new Intent(context, RetrofitActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_proxy)
    public void onProxyViewClicked() {
        ProxyActivity.actionStart(this);
    }
}
