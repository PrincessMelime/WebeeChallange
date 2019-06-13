package com.webee.challange.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.webee.challange.data.entity.DeviceEntity;

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