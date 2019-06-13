package com.webee.challange.di.builder;


import com.webee.challange.view.frament.DeviceDetailFragment;
import com.webee.challange.view.frament.DeviceListFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * This builder provides android injector service to fragments
 * Author: Lajesh D
 * Email: lajeshds2007@gmail.com
 * Created: 7/24/2018
 * Modified: 7/24/2018
 */
@Module
public abstract class FragmentBuilderModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract DeviceListFragment contributeDeviceListFragment();

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract DeviceDetailFragment contributeDeviceDetailFragment();

}
