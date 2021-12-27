package com.gms.sample.viewgroupdemo.viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.gms.sample.viewgroupdemo.R;

class ItemView {

    View rootView ;
    ImageButton imgButton;

    Item item;

    ItemView(LayoutInflater layoutInflater , ViewGroup container){
        rootView = layoutInflater.inflate(R.layout.item_layout , container , false);
        imgButton = rootView.findViewById(R.id.imageButton);
    }

    public void bind(Item item){
        this.item = item;
        imgButton.setImageResource(item.resId);
    }


}
