package com.webee.challange.data.remote.model;

import com.google.gson.annotations.SerializedName;
import com.webee.challange.data.entity.WeatherEntity;

public class WeatherResponse {


    @SerializedName("result")
    private WeatherEntity weather;


    /**
     * This method return the weather entity
     *
     * @return weather
     */
    public WeatherEntity getWeather() {
        return weather;
    }

    /**
     * This method sets the article entities
     *
     * @param weather - articleslist
     */
    @SuppressWarnings("unused")
    public void setWeather(WeatherEntity weather) {
        this.weather = weather;
    }
}
