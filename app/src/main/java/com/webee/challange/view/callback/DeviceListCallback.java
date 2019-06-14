package com.webee.challange.view.callback;

import com.webee.challange.data.local.entity.DeviceEntity;

public interface DeviceListCallback {
    void onDeviceClicked(DeviceEntity deviceEntity);
}