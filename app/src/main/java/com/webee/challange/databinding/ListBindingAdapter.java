package com.webee.challange.databinding;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.webee.challange.R;
import com.webee.challange.data.remote.Resource;
import com.webee.challange.view.base.BaseAdapter;

import java.util.List;

final class ListBindingAdapter {

    private ListBindingAdapter() {
        // Private Constructor to hide the implicit one
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


    @BindingAdapter("app:weather_pic")
    public static void loadImage(ImageView imageView, String weather_pic) {
       System.out.println(weather_pic);
        if (weather_pic != null)
            Picasso.with(imageView.getContext()).load(weather_pic)
                    .error(R.drawable.ic_error)
                    .resizeDimen(R.dimen.weather_image_size, R.dimen.weather_image_size)
                    .centerInside().into(imageView);
    }


}