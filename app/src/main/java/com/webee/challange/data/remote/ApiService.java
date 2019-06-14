package com.webee.challange.data.remote;

import com.webee.challange.data.remote.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    @GET("data/2.5/weather?")
    Call<WeatherResponse> getCurrentWeatherData(@Query("id") String city_id, @Query("appid") String app_id);
}