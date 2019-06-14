package com.webee.challange.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.webee.challange.data.DeviceRepository;
import com.webee.challange.data.entity.DeviceEntity;

import javax.inject.Inject;

public class NewDeviceViewModel extends ViewModel {

    MutableLiveData<Boolean> display = new MutableLiveData<>();
    MutableLiveData<DeviceEntity> new_device = new MutableLiveData<>();


    @Inject
    public NewDeviceViewModel() {


    }

    public void onDisplayTimePickerDialogClick() {
        display.setValue(true);
    }

    public LiveData<Boolean> getDatePickerDialogDisplayValue() {
        return display;
    }

}
