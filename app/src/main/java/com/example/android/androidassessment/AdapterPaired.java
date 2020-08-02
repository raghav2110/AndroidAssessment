package com.example.android.androidassessment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPaired extends RecyclerView.Adapter<AdapterPaired.viewHolder> {
    private ArrayList<CardViewPaired> cardViewPairedArrayList;
    public static class viewHolder extends RecyclerView.ViewHolder{
        public ImageView aImageView;
        public TextView aTextView1;
        public TextView aTextView2;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            aImageView = itemView.findViewById(R.id.imageView);
            aTextView1 = itemView.findViewById(R.id.tvDeviceName);
            aTextView2 = itemView.findViewById(R.id.tvStatus);
        }
    }
    public AdapterPaired(ArrayList<CardViewPaired> cardViewPaired){
        cardViewPairedArrayList = cardViewPaired;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewpaired,parent,false);
        viewHolder viewHolder = new viewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        CardViewPaired currentItem = cardViewPairedArrayList.get(position);

        holder.aImageView.setImageResource(currentItem.getImageRes());
        holder.aTextView1.setText(currentItem.getDeviceName());
        holder.aTextView2.setText(currentItem.getDeviceStatus());

    }

    @Override
    public int getItemCount() {
        return cardViewPairedArrayList.size();
    }
}
