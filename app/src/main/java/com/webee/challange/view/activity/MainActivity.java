package com.webee.challange.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import com.webee.challange.R;
import com.webee.challange.databinding.ActivityMainBinding;
import com.webee.challange.utils.FragmentUtils;
import com.webee.challange.view.base.BaseActivity;
import com.webee.challange.view.frament.DeviceListFragment;

import static com.webee.challange.utils.FragmentUtils.TRANSITION_NONE;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentUtils.replaceFragment(this, DeviceListFragment.newInstance(), R.id.fragContainer, false, TRANSITION_NONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}
