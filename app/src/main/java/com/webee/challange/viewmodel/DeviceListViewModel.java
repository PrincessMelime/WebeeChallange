package com.webee.challange.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import com.webee.challange.data.DeviceRepository;
import com.webee.challange.data.Resource;
import com.webee.challange.data.entity.DeviceEntity;

import javax.inject.Inject;
import java.util.List;

public class DeviceListViewModel extends ViewModel {
    private final  LiveData<Resource<List<DeviceEntity>>> devices;

    @Inject
    public DeviceListViewModel(DeviceRepository deviceRepository) {
        devices = deviceRepository.obtainDevicesFromDB();
    }

    public LiveData<Resource<List<DeviceEntity>>> getDevices() {
        return devices;
    }
}