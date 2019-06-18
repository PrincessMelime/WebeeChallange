package com.webee.challange.viewmodel;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.widget.DatePicker;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.webee.challange.data.local.entity.DeviceEntity;
import com.webee.challange.data.local.repository.DeviceRepository;

import javax.inject.Inject;

public class NewDeviceViewModel extends ViewModel implements DatePickerDialog.OnDateSetListener {

    private MutableLiveData<Boolean> display = new MutableLiveData<>();
    private MutableLiveData<String> deviceName = new MutableLiveData<>();
    private MutableLiveData<String> deviceMacAddress = new MutableLiveData<>();
    private MutableLiveData<String> dateOfEntry = new MutableLiveData<>();
    private MutableLiveData<Boolean> showNameError = new MutableLiveData<>();
    private MutableLiveData<Boolean> showMacAddressError = new MutableLiveData<>();
    private MutableLiveData<Boolean> showDateOfEntryError = new MutableLiveData<>();
    private MutableLiveData<Boolean> successSave = new MutableLiveData<>();
    private MutableLiveData<Boolean> showProgress = new MutableLiveData<>();


    private DeviceRepository deviceRepository;

    @Inject
    public NewDeviceViewModel(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
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
        showDateOfEntryError.setValue(dateOfEntry.getValue().length() == 0);

        if (!showNameError.getValue() && !showDateOfEntryError.getValue() && !showMacAddressError.getValue())
            saveDevice();
    }

    private void saveDevice() {

        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setName(deviceName.getValue());
        deviceEntity.setMacAddress(deviceMacAddress.getValue());
        deviceEntity.setDateOfEntry(dateOfEntry.getValue());
        try {

            showProgress.setValue(true);
            new AsyncTask<Void, Void, Void>() {

                @Override
                protected Void doInBackground(Void... voids) {

                    deviceRepository.saveDevice(deviceEntity);
                    return null;
                }

                @Override
                protected void onPostExecute(Void none) {
                    showProgress.setValue(false);
                    successSave.setValue(true);
                    display.setValue(false);
                }
            }.execute();

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            successSave.setValue(false);
        }
    }

    public MutableLiveData<Boolean> getDatePickerDialogDisplayValue() {
        return display;
    }

    public MutableLiveData<String> getDayOfEntryValue() {
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
        return showDateOfEntryError;
    }

    public MutableLiveData<Boolean> getSuccessSave() {
        return successSave;
    }

    public MutableLiveData<Boolean> getShowProgress() {
        return showProgress;
    }
}
