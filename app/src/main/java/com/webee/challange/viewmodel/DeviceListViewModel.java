package com.webee.challange.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.webee.challange.data.local.repository.DeviceRepository;
import com.webee.challange.data.remote.Resource;
import com.webee.challange.data.local.entity.DeviceEntity;

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