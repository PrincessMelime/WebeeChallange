package com.webee.challange.view.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.MenuItem;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.webee.challange.R;
import com.webee.challange.databinding.ActivityMainBinding;
import com.webee.challange.view.base.BaseActivity;
import dagger.android.AndroidInjector;


public class MainActivity extends BaseActivity<ActivityMainBinding> {


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return super.supportFragmentInjector();
    }

    private NavController mNavController;


    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(dataBinding.toolbar);

        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, mNavController);

        NavigationUI.setupWithNavController(dataBinding.bottomNave, mNavController);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean navigated = NavigationUI.onNavDestinationSelected(item, mNavController);
        return navigated || super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(mNavController, (DrawerLayout) null);
    }

}
