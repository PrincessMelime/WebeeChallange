package com.webee.challange.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.webee.challange.data.local.entity.WeatherEntity;
import com.webee.challange.data.remote.Resource;
import com.webee.challange.data.remote.repository.WeatherApiRepository;

import javax.inject.Inject;

public class WeatherViewModel extends ViewModel {
    private WeatherApiRepository weatherApiRepository;

    private MutableLiveData<Resource<WeatherEntity>> weather = new MutableLiveData<>();

    @Inject
    public WeatherViewModel(WeatherApiRepository weatherApiRepository) {

        this.weatherApiRepository = weatherApiRepository;
        getWeatherFromAPI();
    }

    public MutableLiveData<Resource<WeatherEntity>> getWeather(){
        return weather;

    }

    public void getWeatherFromAPI(){
        weather = (MutableLiveData<Resource<WeatherEntity>>) weatherApiRepository.obtainWeatherFromApi();

    }

}
