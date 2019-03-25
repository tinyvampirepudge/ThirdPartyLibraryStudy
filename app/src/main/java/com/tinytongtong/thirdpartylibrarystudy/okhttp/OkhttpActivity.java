package com.tinytongtong.thirdpartylibrarystudy.okhttp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tinytongtong.thirdpartylibrarystudy.R;

public class OkhttpActivity extends AppCompatActivity {

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, OkhttpActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
    }


}
