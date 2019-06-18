package com.webee.challange.viewmodel;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.webee.challange.common.Constants;
import com.webee.challange.data.local.entity.WeatherEntity;
import com.webee.challange.data.remote.Resource;
import com.webee.challange.data.remote.repository.WeatherApiRepository;

import javax.inject.Inject;

public class WeatherViewModel extends ViewModel {

    private Handler handler = new Handler();
    private WeatherApiRepository weatherApiRepository;

    private MutableLiveData<Resource<WeatherEntity>> weather = new MutableLiveData<>();

    private UpdateWeatherRunnable updateWeatherRunnable;

    @Inject
    public WeatherViewModel(WeatherApiRepository weatherApiRepository) {

        this.weatherApiRepository = weatherApiRepository;
        updateWeatherRunnable = new UpdateWeatherRunnable(weatherApiRepository);
        handler.postDelayed(updateWeatherRunnable, 1);
    }

    public MutableLiveData<Resource<WeatherEntity>> getWeather() {
        return weather;
    }


    private class UpdateWeatherRunnable implements Observer<Resource<WeatherEntity>>, Runnable {

        WeatherApiRepository repository;
        MutableLiveData<Resource<WeatherEntity>> resource;

        public UpdateWeatherRunnable(WeatherApiRepository repository) {
            this.repository = repository;
        }

        @Override
        public void onChanged(Resource<WeatherEntity> weatherEntityResource) {
            weather.postValue(weatherEntityResource);
        }

        @Override
        public void run() {
            resource = (MutableLiveData<Resource<WeatherEntity>>) weatherApiRepository.obtainWeatherFromApi();
            resource.observeForever(this);
            if (weather.hasActiveObservers())
                handler.postDelayed(this, Constants.TIME_TO_UPDATE_WEATHER);
        }
    }
}

