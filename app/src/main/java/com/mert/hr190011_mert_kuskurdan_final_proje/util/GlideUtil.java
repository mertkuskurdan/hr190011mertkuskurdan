package com.mert.hr190011_mert_kuskurdan_final_proje.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mert.hr190011_mert_kuskurdan_final_proje.R;

public class GlideUtil {

    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(img);
    }
}
