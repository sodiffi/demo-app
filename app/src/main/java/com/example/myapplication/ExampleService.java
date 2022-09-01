package com.example.myapplication;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ExampleService {
    @GET("example")
    Call<ResponseFormat<List<Example>>> listExamples();

    @POST("example") // 用@Body表示要傳送Body資料
    Call<Example> postExample(@Body Example example);
}