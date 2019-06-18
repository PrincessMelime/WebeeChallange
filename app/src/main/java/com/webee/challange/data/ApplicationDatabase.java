package com.webee.challange.data;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.webee.challange.data.local.dao.DeviceDao;
import com.webee.challange.data.local.dao.WeatherDao;
import com.webee.challange.data.local.entity.DeviceEntity;
import com.webee.challange.data.local.entity.WeatherEntity;

@Database(entities = {DeviceEntity.class, WeatherEntity.class}, version = 1, exportSchema = false)
public abstract class ApplicationDatabase extends RoomDatabase {
    public abstract DeviceDao deviceDao();

    public abstract WeatherDao weatherDao();
}
