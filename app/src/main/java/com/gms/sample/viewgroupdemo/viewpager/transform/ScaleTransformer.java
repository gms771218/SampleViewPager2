package com.gms.sample.viewgroupdemo.viewpager.transform;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

/**
 * 縮放效果
 */
public class ScaleTransformer implements ViewPager2.PageTransformer {

    private static final float SCALE = 0.9f;

    @Override
    public void transformPage(@NonNull View page, float position) {
        View view = ((ViewGroup) page).getChildAt(0) ;
        if( view instanceof ImageView){
            if (position >= -1 && position <= 1) {
                // [-1,1]，中间以及相邻的页面，一般相邻的才会用于计算动画
                float scale = SCALE + (1 - SCALE) * (1 - Math.abs(position));
                page.setScaleX(scale);
                page.setScaleY(scale);
            } else {
                // [-Infinity,-1)、(1,+Infinity]，超出相邻的范围
                page.setScaleX(SCALE);
                page.setScaleY(SCALE);
            }
        }
    }
}
