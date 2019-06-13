package com.webee.challange.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.webee.challange.data.DeviceRepository;
import com.webee.challange.data.entity.DeviceEntity;
import com.webee.challange.utils.SingleLiveEvent;
import com.webee.challange.view.callback.ResponseListener;

import javax.inject.Inject;

public class DeviceDetailViewModel extends ViewModel {

    private long id;

    private DeviceRepository deviceRepository;

    private MutableLiveData<DeviceEntity> deviceEntityMutableLiveData = new MutableLiveData<>();

    private SingleLiveEvent<Void> errorMessageRecieved = new SingleLiveEvent<>();

    public MutableLiveData<DeviceEntity> getDeviceEntityMutableLiveData() {
        return deviceEntityMutableLiveData;
    }

    public void setDeviceEntityMutableLiveData(MutableLiveData<DeviceEntity> deviceEntityMutableLiveData) {
        this.deviceEntityMutableLiveData = deviceEntityMutableLiveData;
    }

    public SingleLiveEvent<Void> getErrorMessageRecieved() {
        return errorMessageRecieved;
    }

    public void setErrorMessageRecieved(SingleLiveEvent<Void> errorMessageRecieved) {
        this.errorMessageRecieved = errorMessageRecieved;
    }

    @Inject
    DeviceDetailViewModel(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   /* public void loadDeviceDetails(){

        if(null != deviceRepository) {
            LiveData data = deviceRepository.obtainDevice(id);
            if (null != data) {
                deviceEntityMutableLiveData.;
            }
            else{
                errorMessageRecieved.call();

            }

        }
    }*/
}