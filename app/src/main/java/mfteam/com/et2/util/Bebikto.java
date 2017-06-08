package mfteam.com.et2.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import mfteam.com.et2.R;

/**
 * Created by redugsi on 07/06/17.
 */

public class Bebikto {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView, String url){
        if (url == null)return;
        Picasso.with(imageView.getContext()).load(url).rotate(Util.getCameraPhotoOrientation(url)).placeholder(R.drawable.deneme).into(imageView);
    }
}
