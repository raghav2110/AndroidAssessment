package com.example.android.androidassessment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMessage extends RecyclerView.Adapter<AdapterMessage.viewHolder> {
    private ArrayList<CardViewMessage> cardViewMessageArrayList;
    public static class viewHolder extends RecyclerView.ViewHolder{
        public TextView message;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.tvMessageRecevied);
        }
    }
    public AdapterMessage(ArrayList<CardViewMessage> cardViewMessages){
        cardViewMessageArrayList = cardViewMessages;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewmessage,parent,false);
        viewHolder viewHolder = new viewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        CardViewMessage currentItem = cardViewMessageArrayList.get(position);

        holder.message.setText(currentItem.getMessage());

    }

    @Override
    public int getItemCount() {
         return cardViewMessageArrayList.size();
    }
}
