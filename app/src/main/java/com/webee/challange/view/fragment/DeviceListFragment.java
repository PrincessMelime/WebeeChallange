package com.webee.challange.view.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.widget.SearchView;
import android.view.*;
import com.webee.challange.R;
import com.webee.challange.common.Constants;
import com.webee.challange.data.entity.DeviceEntity;
import com.webee.challange.databinding.FragmentDeviceListBinding;
import com.webee.challange.utils.FragmentUtils;
import com.webee.challange.view.adapter.DeviceListAdapter;
import com.webee.challange.view.base.BaseFragment;
import com.webee.challange.view.callback.DeviceListCallback;
import com.webee.challange.viewmodel.DeviceListViewModel;

public class DeviceListFragment extends BaseFragment<DeviceListViewModel, FragmentDeviceListBinding> implements DeviceListCallback {

    public static DeviceListFragment newInstance() {
        Bundle args = new Bundle();
        DeviceListFragment fragment = new DeviceListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Class<DeviceListViewModel> getViewModel() {
        return DeviceListViewModel.class;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_device_list;
    }

    @Override
    public void onDeviceClicked(DeviceEntity deviceEntity) {
        if(null != getActivity()){
            Bundle args = new Bundle();
            args.putString(Constants.BUNDLE_KEY_DEVICE_NAME, deviceEntity.getName());
            args.putString(Constants.BUNDLE_KEY_DEVICE_MAC_ADDRESS, deviceEntity.getMacAddress());
            args.putString(Constants.BUNDLE_KEY_DEVICE_DATE_OF_ENTRY, deviceEntity.getCreatedDate());

            DeviceDetailFragment detailFragment = new DeviceDetailFragment();
            detailFragment.setArguments(args);
            FragmentUtils.replaceFragment((AppCompatActivity) getActivity(), detailFragment, R.id.nav_host_fragment, true, FragmentUtils.TRANSITION_SLIDE_LEFT_RIGHT);
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);
        dataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataBinding.recyclerView.setAdapter(new DeviceListAdapter(this));
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        viewModel.getDevices()
                .observe(this, resource -> {
                    if(null != resource ){
                        dataBinding.waitProgress.setVisibility(View.GONE);
                    }
                    dataBinding.setResource(resource);

                    // If the cached data is already showing then no need to show the error
                    if(null != dataBinding.recyclerView.getAdapter() && dataBinding.recyclerView.getAdapter().getItemCount() > 0){
                        dataBinding.errorText.setVisibility(View.GONE);
                    }
                });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        if(null == getActivity())
            return;

        SearchView searchView;
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();

        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                if(null != dataBinding.recyclerView.getAdapter())
                    ((DeviceListAdapter)dataBinding.recyclerView.getAdapter()).getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                if(null != dataBinding.recyclerView.getAdapter())
                    ((DeviceListAdapter)dataBinding.recyclerView.getAdapter()).getFilter().filter(query);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}