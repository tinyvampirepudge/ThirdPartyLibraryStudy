package com.tinytongtong.thirdpartylibrarystudy.okhttp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.tinytongtong.thirdpartylibrarystudy.R;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class OkhttpActivity extends AppCompatActivity {
    public static final String TAG = OkhttpActivity.class.getSimpleName();

    @BindView(R.id.btn_sync)
    Button btnSync;
    @BindView(R.id.btn_async)
    Button btnAsync;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, OkhttpActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        ButterKnife.bind(this);
    }


    private void synRequest() {
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();

        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .addHeader("abs", "def")
                .get()
                .build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            Log.e(TAG, response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void asyncRequest() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .get()
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("failure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("Success response:" + response.body().string());
            }
        });
    }

    @OnClick(R.id.btn_sync)
    public void onBtnSyncClicked() {
        synRequest();
    }

    @OnClick(R.id.btn_async)
    public void onBtnAsyncClicked() {
        asyncRequest();
    }
}
