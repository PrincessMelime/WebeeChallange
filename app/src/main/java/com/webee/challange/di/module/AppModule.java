package com.webee.challange.di.module;

import android.app.Application;
import androidx.room.Room;
import com.webee.challange.data.ApplicationDatabase;
import com.webee.challange.data.local.dao.DeviceDao;
import com.webee.challange.data.local.dao.WeatherDao;
import com.webee.challange.data.remote.ApiConstants;
import com.webee.challange.data.remote.ApiService;
import com.webee.challange.data.remote.RequestInterceptor;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;
import java.util.concurrent.TimeUnit;

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(ApiConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.writeTimeout(ApiConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.addInterceptor(new RequestInterceptor());
        okHttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    ApiService provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    ApplicationDatabase provideDeviceDatabase(Application application) {
        return Room.databaseBuilder(application, ApplicationDatabase.class, "application.sqlite").build();
    }

    @Provides
    @Singleton
    DeviceDao provideDeviceDao(ApplicationDatabase applicationDatabase) {
        return applicationDatabase.deviceDao();
    }

    @Provides
    @Singleton
    WeatherDao provideWeatherDao(ApplicationDatabase applicationDatabase) {
        return applicationDatabase.weatherDao();
    }

}