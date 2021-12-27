package com.gms.sample.viewgroupdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.gms.sample.viewgroupdemo.viewpager.ISelectListener;
import com.gms.sample.viewgroupdemo.viewpager.Item;
import com.gms.sample.viewgroupdemo.viewpager.ItemAdapter;
import com.gms.sample.viewgroupdemo.viewpager.transform.TintColorTransformer;

import java.util.ArrayList;

public class CusViewPager extends FrameLayout {

    ViewPager2 viewPager;
    ArrayList<Item> mSource = new ArrayList<Item>();
    ISelectListener mSelectListener ;
    ISelectListener SelectListener = new ISelectListener() {
        @Override
        public void onSelect(int position, Item item) {
            if(mSelectListener != null){
                mSelectListener.onSelect(position,item);
            }
        }
    };

    public CusViewPager(@NonNull Context context) {
        super(context);
        init();
    }

    public CusViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CusViewPager(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void init(){
        viewPager = new ViewPager2(getContext());
        viewPager.setAdapter(new ItemAdapter(mSource, SelectListener));
        viewPager.setOffscreenPageLimit(5);
        //一屏多页
        View recyclerView = viewPager.getChildAt(0);
        if(recyclerView != null && recyclerView instanceof RecyclerView){
            int padding = (int)getResources().getDimension(R.dimen.item_padding);
            recyclerView.setPadding(padding, 0, padding, 0);
            ((RecyclerView) recyclerView).setClipToPadding(false);
        }
        viewPager.setPageTransformer(getPageTransformer());
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                for (int i = 0 ; i<mSource.size() ; i++){
                    mSource.get(i).enabled = false;
                }
                Item item = mSource.get(position);
                item.enabled = true;
//                Toast.makeText(getContext() , item.name , Toast.LENGTH_SHORT ).show();
            }
        });

        this.addView(viewPager);


        //        viewPager2.setPageTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
//                float alpha = 0.0f;
//                if(0.0f <= position && position <= 1 ){
//                    alpha = 1.0f - position ;
//                }else if(-1.0f <= position && position <0.0f){
//                alpha = position + 1.0f;
//                }
//                page.setAlpha(alpha);
//            }
//        });
    }

    /**
     * 設定資源
     * @param source
     */
    public void setSource(ArrayList<Item> source) {
        mSource.clear();
        mSource.addAll(source);
        viewPager.getAdapter().notifyDataSetChanged();
    }

    /**
     * 設定SelectListener
     * @param selectListener
     */
    public void setSelectListener(ISelectListener selectListener) {
        mSelectListener = selectListener;
    }

    protected ViewPager2.PageTransformer getPageTransformer(){
        CompositePageTransformer pageTransformer = new CompositePageTransformer();
        pageTransformer.addTransformer(new MarginPageTransformer(0));
        pageTransformer.addTransformer(new TintColorTransformer());
        return  pageTransformer ;
    }


    private ArrayList<Item> createItems(){
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("home", R.drawable.icon_home));
        items.add(new Item("face", R.drawable.icon_face));
        items.add(new Item("info", R.drawable.icon_info));
        items.add(new Item("setting", R.drawable.icon_settings));
        items.add(new Item("thumb", R.drawable.icon_thumb));
        return  items;
    }

} // class close
