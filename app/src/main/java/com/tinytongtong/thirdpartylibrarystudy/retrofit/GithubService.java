package com.tinytongtong.thirdpartylibrarystudy.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/3 10:15 PM
 * @Version TODO
 */
public interface GithubService {
    @GET("user/{user}/repo")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
