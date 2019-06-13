package com.webee.challange.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import com.webee.challange.di.module.ViewModelKey;
import com.webee.challange.viewmodel.DeviceDetailViewModel;
import com.webee.challange.viewmodel.DeviceListViewModel;
import com.webee.challange.viewmodel.ViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DeviceListViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsDeviceListViewModel(DeviceListViewModel deviceListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DeviceDetailViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsDeviceDetailViewModel(DeviceDetailViewModel deviceDetailViewModel);


    @Binds
    @SuppressWarnings("unused")
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}