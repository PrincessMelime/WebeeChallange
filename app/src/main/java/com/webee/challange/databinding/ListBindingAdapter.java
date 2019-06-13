package com.webee.challange.databinding;

import android.support.v7.widget.RecyclerView;
import android.databinding.BindingAdapter;
import com.webee.challange.data.Resource;
import com.webee.challange.view.base.BaseAdapter;

import java.util.List;

final class ListBindingAdapter{

    private ListBindingAdapter(){
        // Private Constructor to hide the implicit one
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter(value = "resource")
    public static void setResource(RecyclerView recyclerView, Resource resource){
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter == null)
            return;

        if(resource == null)
            return;

        if(adapter instanceof BaseAdapter){
            ((BaseAdapter)adapter).setData((List) resource.data);
        }
    }

}