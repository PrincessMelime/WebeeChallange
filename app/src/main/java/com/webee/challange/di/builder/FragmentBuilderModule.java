package com.webee.challange.di.builder;


import com.webee.challange.view.fragment.DeviceDetailFragment;
import com.webee.challange.view.fragment.DeviceListFragment;
import com.webee.challange.view.fragment.NewDeviceFragment;
import com.webee.challange.view.fragment.WeatherFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class FragmentBuilderModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract DeviceListFragment contributeDeviceListFragment();

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract DeviceDetailFragment contributeDeviceDetailFragment();

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract WeatherFragment contributeWeatherFragment();

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract NewDeviceFragment contributeNewDeviceFragmentFragment();


}
