package com.webee.challange.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import com.webee.challange.data.dao.DeviceDao;
import com.webee.challange.data.entity.DeviceEntity;
import com.webee.challange.view.callback.ResponseListener;

import javax.inject.Inject;
import java.util.List;

public class DeviceRepository {

    private final DeviceDao deviceDao;

    @Inject
    DeviceRepository(DeviceDao dao) {
        this.deviceDao = dao;
    }


    public LiveData<Resource<List<DeviceEntity>>> obtainDevicesFromDB() {
        MediatorLiveData<Resource<List<DeviceEntity>>> result = new MediatorLiveData<>();
        LiveData<List<DeviceEntity>> devices = deviceDao.getDevices();
        result.setValue(Resource.loading(null));


        result.addSource(devices, data -> {
            result.removeSource(devices);
            result.addSource(devices, newData -> {
                    if(null != newData)
                        result.setValue(Resource.success(newData)) ;
                });
            });
        return result;
    }

    public LiveData<DeviceEntity> obtainDevice(long id, ResponseListener responseListener) {

        return deviceDao.getDevice(id);
    }
}
