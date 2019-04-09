package com.tinytongtong.thirdpartylibrarystudy.retrofit;

import android.database.Observable;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/6 4:10 PM
 * @Version TODO
 */
public interface MyInterface {
    @GET(".../...")
    Call<List<MyResponse>> getCall();

    @GET(".../...")
    Observable<List<MyResponse>> getCall1();
}
