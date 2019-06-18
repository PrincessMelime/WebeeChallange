package com.webee.challange.di.module;

import androidx.lifecycle.ViewModel;
import dagger.MapKey;

import java.lang.annotation.*;

/**
 *
 * ViewModel Key which serves as the unique key for keeping the viewmodel instances in the factory
 *
 * */

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@MapKey
@interface ViewModelKey {
    @SuppressWarnings("unused")
    Class<? extends ViewModel> value();
}