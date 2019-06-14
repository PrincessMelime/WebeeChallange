package com.webee.challange.data.local.repository;

import androidx.lifecycle.LiveData;
import com.webee.challange.data.local.dao.WeatherDao;
import com.webee.challange.data.local.entity.WeatherEntity;
import com.webee.challange.view.callback.ResponseListener;

import javax.inject.Inject;

public class WeatherRepository {

    private final WeatherDao weatherDao;

    @Inject
    WeatherRepository(WeatherDao dao) {
        this.weatherDao = dao;
    }


    public LiveData<WeatherEntity> obtainWeather(ResponseListener responseListener) {

        return weatherDao.getWeather();
    }

    public void saveDevice(WeatherEntity weatherEntity) {

        weatherDao.saveWeather(weatherEntity);
    }
}
