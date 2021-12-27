package com.gms.sample.viewgroupdemo.viewpager.transform;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class TintColorTransformer implements ViewPager2.PageTransformer {

    @Override
    public void transformPage(@NonNull View page, float position) {
        View view = ((ViewGroup) page).getChildAt(0) ;
        if( view instanceof ImageView){

            if(position == 0) {
                ((ImageView) view).setColorFilter(Color.RED);
            }else {
                ((ImageView) view).setColorFilter(Color.TRANSPARENT);
            }

        }
    }
}
