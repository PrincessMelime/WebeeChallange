package com.webee.challange.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.webee.challange.data.local.entity.WeatherEntity;


@Dao
public interface WeatherDao {

    @Query("SELECT * FROM weather WHERE id=:id")
    LiveData<WeatherEntity> getWeather(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveWeather(WeatherEntity deviceEntity);
}
