package com.webee.challange.databinding;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.webee.challange.data.remote.Resource;
import com.webee.challange.view.base.BaseAdapter;

import java.util.List;

final class ListBindingAdapter {

    private ListBindingAdapter() {
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter(value = "resource")
    public static void setResource(RecyclerView recyclerView, Resource resource) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null)
            return;

        if (resource == null)
            return;

        if (adapter instanceof BaseAdapter) {
            ((BaseAdapter) adapter).setData((List) resource.data);
        }
    }


}