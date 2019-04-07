package com.tinytongtong.thirdpartylibrarystudy.retrofit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tinytongtong.thirdpartylibrarystudy.R;
import com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.ProxyActivity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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

    /**
     * retrofit基础用法
     */
    private void basicRetrofitUsage() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService service = retrofit.create(GithubService.class);

        Call<List<Repo>> repos = service.listRepos("octocat");

        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                System.out.println("onResponse");
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                System.out.println("onFailure");
            }
        });
    }

    private void basicRetrofitUsage2() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://xxx.xxx.com/")// 设置网络请求的Url地址
                .addConverterFactory(GsonConverterFactory.create())// 设置数据解析器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())// 支持rxjava平台
                .build();

        MyInterface myInterface = retrofit.create(MyInterface.class);

        Call call = myInterface.getCall();

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                System.out.println("请求失败");
            }
        });
    }

    @OnClick(R.id.btn_proxy)
    public void onProxyViewClicked() {
        ProxyActivity.actionStart(this);
    }

    @OnClick(R.id.btn_retrofit_basic)
    public void onRetrofitBasicViewClicked() {
        basicRetrofitUsage();
    }
}
