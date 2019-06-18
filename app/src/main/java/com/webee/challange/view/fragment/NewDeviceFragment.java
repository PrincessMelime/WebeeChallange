package com.webee.challange.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
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
        observeSuccessSaveValue();
        observeShowProgressValue();
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

    private void setSuccessSave(boolean successSave) {
        if (successSave) {
            dataBinding.llFields.setVisibility(View.GONE);
            dataBinding.btnAdd.setVisibility(View.GONE);
            dataBinding.txtMessage.setVisibility(View.VISIBLE);
            dataBinding.txtMessage.setText(R.string.success_device_save);
        } else {
            Toast.makeText(getContext(), getResources().getString(R.string.unsuccessful_device_save), Toast.LENGTH_LONG).show();

        }

    }

    private void setShowProgress(boolean showProgress) {
        if (showProgress) {
            dataBinding.llFields.setVisibility(View.GONE);
            dataBinding.btnAdd.setVisibility(View.GONE);
            dataBinding.txtMessage.setVisibility(View.GONE);
            dataBinding.loadingProgress.setVisibility(View.VISIBLE);
        } else {
            dataBinding.llFields.setVisibility(View.VISIBLE);
            dataBinding.btnAdd.setVisibility(View.VISIBLE);
            dataBinding.txtMessage.setVisibility(View.GONE);
            dataBinding.loadingProgress.setVisibility(View.GONE);
        }

    }

    private void observeTimePickerDialogDisplayValue() {
        viewModel.getDatePickerDialogDisplayValue().observe(getViewLifecycleOwner(), display -> {
            if (display) setTimePickerDialog(); // Display TimePickerDialog
        });
    }

    private void observeNameValue() {
        viewModel.getShowNameError().observe(getViewLifecycleOwner(), showError -> {
            setNameError(showError);
        });
    }

    private void observeMacAddressErrorValue() {
        viewModel.getShowMacAddressError().observe(getViewLifecycleOwner(), showError -> {
            setMacAddressError(showError);
        });
    }

    private void observeDateOfEntryErrorValue() {
        viewModel.getShowDateOfEntryError().observe(getViewLifecycleOwner(), showError -> {
            setDateOfEntryError(showError);
        });
    }

    private void observeDateOfEntryValue() {
        viewModel.getDayOfEntryValue().observe(getViewLifecycleOwner(), dateOfEntry -> {
            if (dateOfEntry != "") setDateOfEntryValue(dateOfEntry); // Change etDateOfEntry value
        });
    }

    private void observeSuccessSaveValue() {
        viewModel.getSuccessSave().observe(getViewLifecycleOwner(), successSave -> {
            setSuccessSave(successSave); // Change etDateOfEntry value
        });
    }

    private void observeShowProgressValue() {
        viewModel.getShowProgress().observe(getViewLifecycleOwner(), showProgress -> {
            setShowProgress(showProgress); // Change etDateOfEntry value
        });
    }
}