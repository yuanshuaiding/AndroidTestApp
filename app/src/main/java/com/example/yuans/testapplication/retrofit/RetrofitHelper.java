package com.example.yuans.testapplication.retrofit;

import android.text.TextUtils;
import android.util.Log;

import com.example.yuans.testapplication.BuildConfig;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author : Eric
 * e-mail : yuanshuai@bertadata.com
 * time   : 2017/03/21
 * desc   : retrofit通用帮助类
 * version: 1.0
 */

public class RetrofitHelper {

    public static Retrofit getRetrofit(String baseUrl) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient().newBuilder();
        clientBuilder.readTimeout(10, TimeUnit.SECONDS);
        clientBuilder.connectTimeout(9, TimeUnit.SECONDS);
        clientBuilder.addInterceptor(requestLogging);
        clientBuilder.addInterceptor(responseLogging);
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static Interceptor requestLogging = new Interceptor() {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request requst = chain.request();
            if (BuildConfig.DEBUG) {
                Log.e("发送请求", String.format(" %s on %s%n%s",
                        requst.url(), chain.connection(), requst.headers()));
            }
            return chain.proceed(requst);
        }
    };

    private static Interceptor responseLogging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            if (BuildConfig.DEBUG) {
                if (!TextUtils.isEmpty(message))
                    Log.e("收到响应", message);
            }
        }
    }).setLevel(HttpLoggingInterceptor.Level.BODY);
}
