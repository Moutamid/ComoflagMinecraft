package com.moliyacentre.topcamouflageskinsmcpe.utils;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.moliyacentre.topcamouflageskinsmcpe.R;
import com.moliyacentre.topcamouflageskinsmcpe.myapplication.Myapplication;


public class ConstantFunctions {
    public static RequestOptions requestOptions = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);

    public static void loadImage(String str, ImageView imageView) {
        Glide.with(Myapplication.getContext()).load(str).thumbnail(Glide.with(Myapplication.getContext()).load(Integer.valueOf((int) R.drawable.default_skin))).apply((BaseRequestOptions<?>) requestOptions).into(imageView);
    }

    public static void loadImageWithoutThumbnail(String str, ImageView imageView) {
        Glide.with(Myapplication.getContext()).load(str).apply((BaseRequestOptions<?>) requestOptions).into(imageView);
    }
}
