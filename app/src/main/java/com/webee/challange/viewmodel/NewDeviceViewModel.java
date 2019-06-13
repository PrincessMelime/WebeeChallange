package com.webee.challange.viewmodel;

import androidx.lifecycle.ViewModel;
import com.webee.challange.data.DeviceRepository;

import javax.inject.Inject;

public class NewDeviceViewModel extends ViewModel {

    @Inject
    public NewDeviceViewModel(DeviceRepository deviceRepository) {

        //devices = deviceRepository.obtainDevicesFromDB();
    }

}
