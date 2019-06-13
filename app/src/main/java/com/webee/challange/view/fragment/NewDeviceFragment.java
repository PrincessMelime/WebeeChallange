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

        return dataBinding.getRoot();
    }
}