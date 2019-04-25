package com.tinytongtong.thirdpartylibrarystudy.leakcanary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.tinytongtong.thirdpartylibrarystudy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebviewLeakActivity extends AppCompatActivity {

    @BindView(R.id.wv)
    WebView wv;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, WebviewLeakActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_leak);
        ButterKnife.bind(this);

        wv.loadUrl("https://www.baidu.com");
    }
}
