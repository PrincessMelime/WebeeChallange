package com.webee.challange.data.remote.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.webee.challange.data.local.dao.WeatherDao;
import com.webee.challange.data.local.entity.WeatherEntity;
import com.webee.challange.data.remote.ApiConstants;
import com.webee.challange.data.remote.ApiService;
import com.webee.challange.data.remote.NetworkBoundResource;
import com.webee.challange.data.remote.Resource;
import retrofit2.Call;

import javax.inject.Inject;

public class WeatherApiRepository {

    private final ApiService apiService;
    private final WeatherDao weatherDao;

    @Inject
    public WeatherApiRepository(WeatherDao weatherDao, ApiService apiService) {
        this.weatherDao = weatherDao;
        this.apiService = apiService;
    }

    /**
     * This method fetches the popular articles from the service.
     * Once the fetching is done the data is cached to local db so that the app can even work offline
     *
     * @return WeatherEntity
     */
    public LiveData<Resource<WeatherEntity>> obtainWeatherFromApi() {
        return new NetworkBoundResource<WeatherEntity, WeatherResponse>() {

            @Override
            protected void saveCallResult(WeatherResponse item) {
                if (null != item) {
                    WeatherEntity weatherEntity = new WeatherEntity();
                    if(null != item.main){
                    weatherEntity.setHumidity(item.main.humidity);
                    weatherEntity.setTemperature(item.main.temp);
                    weatherEntity.setTempMax(item.main.temp_max);
                    weatherEntity.setTempMin(item.main.temp_min);
                    weatherEntity.setPressure(item.main.pressure);
                    if(null != item.weather){
                        weatherEntity.setMain(((Weather) item.weather.get(0)).main);
                        weatherEntity.setImgUrl("https://openweathermap.org/img/w/" + ((Weather) item.weather.get(0)).icon + ".png");
                        weatherDao.saveWeather(weatherEntity);
                    }


                    }

                }


            }

            @NonNull
            @Override
            protected LiveData<WeatherEntity> loadFromDb() {
                return weatherDao.getWeather();
            }

            @NonNull
            @Override
            protected Call<WeatherResponse> createCall() {
                return apiService.getCurrentWeatherData(ApiConstants.CITY_ID, ApiConstants.UNITS, ApiConstants.APP_ID);
            }
        }.getAsLiveData();
    }


}
