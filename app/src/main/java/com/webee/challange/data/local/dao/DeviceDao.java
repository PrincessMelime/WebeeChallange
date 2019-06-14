package com.webee.challange.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.webee.challange.data.local.entity.DeviceEntity;

import java.util.List;

@Dao
public interface DeviceDao {
    @Query("SELECT * FROM devices")
    LiveData<List<DeviceEntity>> getDevices();

    @Query("SELECT * FROM devices WHERE id=:id")
    LiveData<DeviceEntity> getDevice(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void saveDevice(DeviceEntity deviceEntity);

}