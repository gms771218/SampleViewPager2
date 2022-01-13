package com.gms.sample.viewgroupdemo.viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    public ArrayList<Item> mSource ;

    ISelectListener mSelectListener ;

    public ItemAdapter(ArrayList<Item> source , ISelectListener selectListener){
        super();
        this.mSource = source;
        this.mSelectListener = selectListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemView itemView = new ItemView(LayoutInflater.from(parent.getContext()), parent);
        itemView.rootView.setOnClickListener(v -> {
            if(itemView.item.enabled){
               int index = mSource.indexOf(itemView.item) ;
                mSelectListener.onSelect(index,itemView.item);
            }

        });
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(getItem((position)));
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE; // (mSource ==null) ? 0 :mSource.size() ;
    }

    public Item getItem(int position){
        return mSource.get(position % mSource.size());
    }

}

class ItemViewHolder extends RecyclerView.ViewHolder {
    ItemView itemView;

    public ItemViewHolder(@NonNull ItemView itemView) {
        super(itemView.rootView);
        this.itemView = itemView;
    }

    public void bind(Item item){
        this.itemView.bind(item);
    }
}