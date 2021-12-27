package com.gms.sample.viewgroupdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.gms.sample.viewgroupdemo.viewpager.Item;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CusViewPager cusViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cusViewPager = findViewById(R.id.cusViewpager);
        cusViewPager.setSource(createItems());
        cusViewPager.setSelectListener((position, item) -> {
            Snackbar.make(cusViewPager.getRootView() ,"position : "+position+" / "+item.name , 500 ).show();
        });
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

}