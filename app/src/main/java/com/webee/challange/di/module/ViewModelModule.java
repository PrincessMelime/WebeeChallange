package com.webee.challange.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.webee.challange.viewmodel.*;
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

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsWeatherViewModel(WeatherViewModel weatherViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NewDeviceViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsNewDeviceViewModel(NewDeviceViewModel newDeviceViewModel);
}