package com.webee.challange.view.callback;

import com.webee.challange.data.entity.DeviceEntity;

public interface DeviceListCallback {
    void onDeviceClicked(DeviceEntity deviceEntity);
}