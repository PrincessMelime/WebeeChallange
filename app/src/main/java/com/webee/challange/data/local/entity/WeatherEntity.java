package com.webee.challange.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "weather")

public class WeatherEntity {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private long id;

    @SerializedName("temperature")
    private String temperature;

    @SerializedName("temp_max")
    private String tempMax;

    @SerializedName("temp_min")
    private String tempMin;

    @SerializedName("main")
    private String main;

    @SerializedName("humidity")
    private String humidity;

    @SerializedName("pressure")
    private String pressure;

    @SerializedName("img_url")
    private String imgUrl;

    public long getId() {
        return id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
