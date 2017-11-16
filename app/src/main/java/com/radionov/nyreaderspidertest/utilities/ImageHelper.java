package com.radionov.nyreaderspidertest.utilities;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.radionov.nyreaderspidertest.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

/**
 * Utility class for loading images
 */

public class ImageHelper {

    private ImageHelper() {
    }

    public static void loadImage(Context context, String imageUrl, ImageView imageView) {
        Picasso.with(context)
                .load(imageUrl)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                        //Try again online if cache failed
                        Picasso.with(context)
                                .load(imageUrl)
                                .into(imageView);
                    }
                });
    }
}
