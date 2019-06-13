package com.webee.challange.data.remote;

import com.webee.challange.data.remote.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("https://openweathermap.org/api")
    Call<WeatherResponse> obtainWeather(@Path("index") int index);
}