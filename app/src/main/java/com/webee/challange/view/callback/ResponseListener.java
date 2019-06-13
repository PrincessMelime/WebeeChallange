package com.webee.challange.view.callback;

import com.webee.challange.data.entity.DeviceEntity;

public interface ResponseListener {

    void onSuccess(DeviceEntity data);
    void onFailure(String message);
}