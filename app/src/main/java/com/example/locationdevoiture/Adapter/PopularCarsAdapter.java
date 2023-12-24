package com.example.locationdevoiture.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.locationdevoiture.Activity.DetailActivity;
import com.example.locationdevoiture.Domain.Cars;
import com.example.locationdevoiture.R;

import java.util.ArrayList;

public class PopularCarsAdapter extends RecyclerView.Adapter<PopularCarsAdapter.viewHolder> {
    ArrayList<Cars> items;
    Context context;

    public PopularCarsAdapter(ArrayList<Cars> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PopularCarsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular_cars,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularCarsAdapter.viewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.priceTxt.setText("£"+items.get(position).getPrice());
        holder.starTxt.setText(""+items.get(position).getStar());
        holder.timeTxt.setText(items.get(position).getTimeValue()+" min");

        Glide.with(context)
                .load(items.get(position).getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object",items.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView titleTxt, priceTxt, starTxt, timeTxt;
        ImageView pic;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            titleTxt = itemView.findViewById(R.id.titleTxt);
            priceTxt = itemView.findViewById(R.id.priceTxt);
            starTxt = itemView.findViewById(R.id.starTxt);
            timeTxt = itemView.findViewById(R.id.timeTxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
