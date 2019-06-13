package com.webee.challange.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import com.webee.challange.data.entity.DeviceEntity;
import com.webee.challange.view.base.BaseAdapter;
import com.webee.challange.view.callback.DeviceListCallback;

import java.util.ArrayList;
import java.util.List;

public class DeviceListAdapter extends BaseAdapter<DeviceListAdapter.DeviceViewHolder, DeviceEntity>
        implements Filterable {

    private List<DeviceEntity> deviceEntities;

    private List<DeviceEntity> deviceEntitiesFiltered;

    private final DeviceListCallback deviceListCallback;

    public DeviceListAdapter(@NonNull DeviceListCallback deviceListCallback) {
        deviceEntities = new ArrayList<>();
        deviceEntitiesFiltered = new ArrayList<>();
        this.deviceListCallback = deviceListCallback;
    }

    @Override
    public void setData(List<DeviceEntity> entities) {
        this.deviceEntities = entities;
        this.deviceEntitiesFiltered = entities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return DeviceViewHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup, deviceListCallback);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder viewHolder, int i) {
        viewHolder.onBind(deviceEntitiesFiltered.get(i));
    }

    @Override
    public int getItemCount() {
        return deviceEntitiesFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    deviceEntitiesFiltered = deviceEntities;
                } else {
                    List<DeviceEntity> filteredList = new ArrayList<>();
                    for (DeviceEntity row : deviceEntities) {

                        // name or mac address match condition.
                        if (row.getName().toLowerCase().contains(charString.toLowerCase())
                                || row.getMacAddress().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    deviceEntitiesFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = deviceEntitiesFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                deviceEntitiesFiltered = (ArrayList<DeviceEntity>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    static class DeviceViewHolder extends RecyclerView.ViewHolder {

        private static DeviceViewHolder create(LayoutInflater inflater, ViewGroup parent, DeviceListCallback callback) {
            ItemDeviceListBinding itemMovieListBinding = ItemDeviceListBinding.inflate(inflater, parent, false);
            return new DeviceViewHolder(itemMovieListBinding, callback);
        }

        final ItemDeviceListBinding binding;

        private DeviceViewHolder(ItemDeviceListBinding binding, DeviceListCallback callback) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(v ->
                    callback.onDeviceClicked(binding.getDevice()));
        }

        private void onBind(DeviceEntity deviceEntity) {
            binding.setDevice(deviceEntity);
            binding.executePendingBindings();
        }
    }
}