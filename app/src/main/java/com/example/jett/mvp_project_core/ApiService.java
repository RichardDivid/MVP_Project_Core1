package com.example.jett.retrofituse_20180604;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * 在这个接口中把业务上的网络访问写进来
 */
public interface ApiService {
    //http://192.168.100.41:80/login/info
    @GET("index")
    Call<String>  sendRequest(@QueryMap HashMap<String,Object> params);
}










