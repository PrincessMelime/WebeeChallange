package com.webee.challange.view.fragment;


import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import com.webee.challange.R;
import com.webee.challange.common.Constants;
import com.webee.challange.databinding.FragmentDeviceDetailsBinding;
import com.webee.challange.view.base.BaseFragment;
import com.webee.challange.viewmodel.DeviceDetailViewModel;

public class DeviceDetailFragment extends BaseFragment<DeviceDetailViewModel, FragmentDeviceDetailsBinding> {
    @Override
    protected Class<DeviceDetailViewModel> getViewModel() {
        return DeviceDetailViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_device_details;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        if(null != args) {

                dataBinding.txtName.setText(args.getString(Constants.BUNDLE_KEY_DEVICE_NAME));
                dataBinding.txtMacAddress.setText(args.getString(Constants.BUNDLE_KEY_DEVICE_MAC_ADDRESS));
                dataBinding.textCreatedDate.setText(args.getString(Constants.BUNDLE_KEY_DEVICE_DATE_OF_ENTRY));
                dataBinding.loadingProgress.setVisibility(View.GONE);
            }


        /*viewModel.getErrorMessageRecieved().observe(getViewLifecycleOwner(), message ->{
            dataBinding.loadingProgress.setVisibility(View.GONE);
            dataBinding.textError.setText("Error");
        });*/
    }
}