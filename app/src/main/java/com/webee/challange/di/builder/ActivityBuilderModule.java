package com.webee.challange.di.builder;

import com.webee.challange.view.activity.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 *
 * The module which provides the android injection service to Activities.
 *
 * */
@Module
public abstract class ActivityBuilderModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract MainActivity mainActivity();


}
