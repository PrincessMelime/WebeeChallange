package com.webee.challange.databinding;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.squareup.picasso.Picasso;
import com.webee.challange.R;

final class FragmentBindingAdapter {

    private FragmentBindingAdapter() {
    }

    @BindingAdapter("app:weather_pic")
    public static void loadImage(ImageView imageView, String weather_pic) {
        if (weather_pic != null)
            Picasso.with(imageView.getContext()).load(weather_pic)
                    .error(R.drawable.ic_error)
                    .resizeDimen(R.dimen.weather_image_size, R.dimen.weather_image_size)
                    .centerInside().into(imageView);
    }
}
