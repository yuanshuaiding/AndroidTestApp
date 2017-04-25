package com.example.yuans.testapplication.retrofit;

import com.example.yuans.testapplication.bean.RepoBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * author : Eric
 * e-mail : yuanshuai@bertadata.com
 * time   : 2017/03/21
 * desc   : 请求特定用户下的repos接口
 * version: 1.0
 */

public interface GitHubServiceAPI {
    @GET("users/{user}/repos")
    Observable<List<RepoBean>> listRepos(@Path("user") String user);
}
