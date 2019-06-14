package com.webee.challange.viewmodel;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class NewDeviceViewModel extends ViewModel implements DatePickerDialog.OnDateSetListener {

    MutableLiveData<Boolean> display = new MutableLiveData<>();
    MutableLiveData<String> deviceName = new MutableLiveData<>();
    MutableLiveData<String> deviceMacAddress = new MutableLiveData<>();
    MutableLiveData<String> dateOfEntry = new MutableLiveData<>();
    MutableLiveData<Boolean> showNameError = new MutableLiveData<>();
    MutableLiveData<Boolean> showMacAddressError = new MutableLiveData<>();
    MutableLiveData<Boolean> showdateOfEntryError = new MutableLiveData<>();


    @Inject
    public NewDeviceViewModel() {
        deviceName.setValue("");
        deviceMacAddress.setValue("");
        dateOfEntry.setValue("");
    }

    public void onDeviceNameChange(CharSequence s) {
        deviceName.setValue(s.toString());
    }

    public void onDeviceMacAddressChange(CharSequence s) {
        deviceMacAddress.setValue(s.toString());
    }

    public void onDisplayTimePickerDialogClick() {
        display.setValue(true);
    }

    public void onAddDeviceClick() {
        showNameError.setValue(deviceName.getValue().length() == 0);
        showMacAddressError.setValue(!deviceMacAddress.getValue().matches("([\\da-fA-F]{2}(?:\\:|-|$)){6}"));
        showdateOfEntryError.setValue(dateOfEntry.getValue().length() == 0);
    }

    public LiveData<Boolean> getDatePickerDialogDisplayValue() {
        return display;
    }

    public LiveData<String> getDayOfEntryValue() {
        return dateOfEntry;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

        dateOfEntry.setValue("" + day + "/" + month + "/" + year);

    }

    public MutableLiveData<Boolean> getShowNameError() {
        return showNameError;
    }

    public MutableLiveData<Boolean> getShowMacAddressError() {
        return showMacAddressError;
    }
    public MutableLiveData<Boolean> getShowDateOfEntryError() {
        return showdateOfEntryError;
    }
}
