package com.webee.challange.data;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.webee.challange.data.dao.DeviceDao;
import com.webee.challange.data.entity.DeviceEntity;

@Database(entities = {DeviceEntity.class}, version = 2)
public abstract class DeviceDatabase extends RoomDatabase {
    public abstract DeviceDao deviceDao();
}
