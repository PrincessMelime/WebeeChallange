package com.webee.challange.data;

import android.arch.lifecycle.LiveData;
import com.webee.challange.data.dao.DeviceDao;
import com.webee.challange.data.entity.DeviceEntity;

import javax.inject.Inject;
import java.util.List;

public class DeviceRepository {

    private final DeviceDao deviceDao;

    @Inject
    DeviceRepository(DeviceDao dao) {
        this.deviceDao = dao;
    }


    public LiveData<List<DeviceEntity>> obtainDevicesFromDB() {

           return deviceDao.getDevices();
    }

    public LiveData<DeviceEntity> obtainDevice(long id) {

        return deviceDao.getDevice(id);
    }
}
