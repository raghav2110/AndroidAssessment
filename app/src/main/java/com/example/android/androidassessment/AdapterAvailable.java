package com.example.android.androidassessment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterAvailable extends RecyclerView.Adapter<AdapterAvailable.viewHolder> {

    private ArrayList<CardViewAvailable> cardViewAvailableArrayList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        public ImageView aImageView;
        public TextView aTextView1;
        public TextView aTextView2;

        public viewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            aImageView = itemView.findViewById(R.id.imageView);
            aTextView1 = itemView.findViewById(R.id.tvDeviceName);
            aTextView2 = itemView.findViewById(R.id.tvStatus);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if (position!= RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public AdapterAvailable(ArrayList<CardViewAvailable> cardViewAvailable){
        cardViewAvailableArrayList = cardViewAvailable;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewavailable,parent,false);
        viewHolder viewHolder = new viewHolder(v,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        CardViewAvailable currentItem = cardViewAvailableArrayList.get(position);

        holder.aImageView.setImageResource(currentItem.getImageRes());
        holder.aTextView1.setText(currentItem.getDeviceName());
        holder.aTextView2.setText(currentItem.getDeviceStatus());
    }

    @Override
    public int getItemCount() {
        return cardViewAvailableArrayList.size();
    }
}
