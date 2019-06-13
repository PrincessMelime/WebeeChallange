package com.webee.challange.di.component;

import android.app.Application;
import com.webee.challange.WebeeChallangeApp;
import com.webee.challange.di.builder.ActivityBuilderModule;
import com.webee.challange.di.module.AppModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        ActivityBuilderModule.class})

public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(WebeeChallangeApp webeeChallangeApp);
}