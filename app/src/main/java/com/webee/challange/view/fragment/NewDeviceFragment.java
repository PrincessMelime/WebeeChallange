package com.webee.challange.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.webee.challange.R;
import com.webee.challange.databinding.FragmentNewDeviceBinding;
import com.webee.challange.view.base.BaseFragment;
import com.webee.challange.viewmodel.NewDeviceViewModel;

public class NewDeviceFragment extends BaseFragment<NewDeviceViewModel, FragmentNewDeviceBinding> {

    @Override
    protected Class<NewDeviceViewModel> getViewModel() {
        return NewDeviceViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_new_device;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        observeTimePickerDialogDisplayValue();
        observeDateOfEntryValue();
        observeNameValue();
        observeMacAddressErrorValue();
        observeDateOfEntryErrorValue();
        dataBinding.setViewNewDeviceViewModel(viewModel);
        return dataBinding.getRoot();
    }


    private void setTimePickerDialog() {
        DatePickerFragment dialog = new DatePickerFragment(viewModel);
        dialog.show(getFragmentManager(), "data_picker");


    }

    private void setNameError(boolean showError) {
        if (showError) dataBinding.textName.setError(getResources().getString(R.string.name_no_empty));
        else dataBinding.textName.setError(null);
    }

    private void setMacAddressError(boolean showError) {
        if (showError) dataBinding.textMacAddress.setError(getResources().getString(R.string.mac_address_format));
        else dataBinding.textMacAddress.setError(null);
    }

    private void setDateOfEntryError(boolean showError) {
        if (showError) dataBinding.etDateOfEntry.setError(getResources().getString(R.string.date_of_entry_empty));
        else dataBinding.etDateOfEntry.setError(null);
    }

    private void setDateOfEntryValue(String dateOfEntry) {
        dataBinding.etDateOfEntry.setText(dateOfEntry);

    }

    private void observeTimePickerDialogDisplayValue() {
        viewModel.getDatePickerDialogDisplayValue().observe(this, display -> {
            if (display) setTimePickerDialog(); // Display TimePickerDialog
        });
    }

    private void observeNameValue() {
        viewModel.getShowNameError().observe(this, showError -> {
            setNameError(showError);
        });
    }

    private void observeMacAddressErrorValue() {
        viewModel.getShowMacAddressError().observe(this, showError -> {
            setMacAddressError(showError);
        });
    }

    private void observeDateOfEntryErrorValue() {
        viewModel.getShowDateOfEntryError().observe(this, showError -> {
            setDateOfEntryError(showError);
        });
    }

    private void observeDateOfEntryValue() {
        viewModel.getDayOfEntryValue().observe(this, dateOfEntry -> {
            if (dateOfEntry != "") setDateOfEntryValue(dateOfEntry); // Change etDateOfEntry value
        });
    }


}