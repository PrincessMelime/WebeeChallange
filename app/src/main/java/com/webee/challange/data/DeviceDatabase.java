package com.webee.challange.data;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.webee.challange.data.dao.DeviceDao;
import com.webee.challange.data.entity.DeviceEntity;

@Database(entities = {DeviceEntity.class}, version = 2)
public abstract class DeviceDatabase extends RoomDatabase {
    public abstract DeviceDao deviceDao();
}
