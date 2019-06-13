package com.webee.challange.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.webee.challange.R;
import com.webee.challange.databinding.FragmentWeatherBinding;
import com.webee.challange.view.base.BaseFragment;
import com.webee.challange.viewmodel.WeatherViewModel;

public class WeatherFragment extends BaseFragment<WeatherViewModel, FragmentWeatherBinding> {

    @Override
    protected Class<WeatherViewModel> getViewModel() {
        return WeatherViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_weather;
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();

    }
}
