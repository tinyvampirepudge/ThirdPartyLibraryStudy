package com.tinytongtong.thirdpartylibrarystudy.okhttp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.tinytongtong.thirdpartylibrarystudy.R;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Cache;
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

    private void cacheRequest() {
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(new Cache(new File("cache"), 24 * 1024 * 1024))
                .build();

        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    /**
     * 给client添加应用拦截器。
     * 这个链接会重定向到https，请求和相应的log只会打印一次。
     */
    private void addApplicationInterceptor() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();

        Request request = new Request.Builder()
                .url("http://www.publicobject.com/helloworld.txt")
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "failure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(TAG, "success");
                Log.e(TAG, "response:" + response.body().string());
            }
        });
    }

    /**
     * 添加网络拦截器
     */
    private void addNetworkInterceptor() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new LoggingInterceptor())
                .build();

        Request request = new Request.Builder()
                .url("http://www.publicobject.com/helloworld.txt")
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "failure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(TAG, "success");
                Log.e(TAG, "response:" + response.body().string());
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

    @OnClick(R.id.btn_cache_interceptor)
    public void onBtnCacheInterceptorClicked() {
        cacheRequest();
    }

    @OnClick(R.id.btn_application_interceptor)
    public void onBtnApplicationInterceptorClicked() {
        addApplicationInterceptor();
    }

    @OnClick(R.id.btn_network_interceptor)
    public void onBtnNetworkInterceptorClicked() {
        addNetworkInterceptor();
    }

}
