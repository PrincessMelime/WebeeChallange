package com.webee.challange.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.webee.challange.data.local.entity.WeatherEntity;

import javax.inject.Inject;

public class WeatherViewModel extends ViewModel {

    private MutableLiveData<WeatherEntity> weather = new MutableLiveData<>();

    @Inject
    public WeatherViewModel() {

        weather = deviceRepository.obtainDevicesFromDB();
    }

}
