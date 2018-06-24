package com.example.jett.retrofituse_20180604;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View view){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/weather/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        //和接口关联起来
        ApiService service=retrofit.create(ApiService.class);

        HashMap<String,Object> params=new HashMap<>();
        params.put("cityname","长沙");
        params.put("key","fd0f609b22905a0a56a48d7cf59a558b");

        service.sendRequest(params).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}










