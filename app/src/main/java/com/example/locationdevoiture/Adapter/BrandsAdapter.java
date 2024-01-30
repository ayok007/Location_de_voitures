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
import com.example.locationdevoiture.Activity.ListCarsActivity;
import com.example.locationdevoiture.Domain.Brand;
import com.example.locationdevoiture.Domain.Cars;
import com.example.locationdevoiture.R;

import java.util.ArrayList;

public class BrandsAdapter extends RecyclerView.Adapter<BrandsAdapter.viewHolder> {
    ArrayList<Brand> items;
    Context context;

    public BrandsAdapter(ArrayList<Brand> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public BrandsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_brand,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandsAdapter.viewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getName());

        switch (position){
            case 0:{
                holder.pic.setBackgroundResource(R.drawable.brand_1_background);
                break;
            }
            case 1:{
                holder.pic.setBackgroundResource(R.drawable.brand_2_background);
                break;
            }
            case 2:{
                holder.pic.setBackgroundResource(R.drawable.brand_3_background);
                break;
            }
            case 3:{
                holder.pic.setBackgroundResource(R.drawable.brand_4_background);
                break;
            }
            case 4:{
                holder.pic.setBackgroundResource(R.drawable.brand_5_background);
                break;
            }
            case 5:{
                holder.pic.setBackgroundResource(R.drawable.brand_6_background);
                break;
            }
            case 6:{
                holder.pic.setBackgroundResource(R.drawable.brand_7_background);
                break;
            }
            case 7:{
                holder.pic.setBackgroundResource(R.drawable.brand_8_background);
                break;
            }
        }

        int drawableResourceId = context.getResources().getIdentifier(items.get(position).getImagePath()
                ,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ListCarsActivity.class);
            intent.putExtra("brandId",position);
            intent.putExtra("BrandName",items.get(position).getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView titleTxt;
        ImageView pic;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            titleTxt = itemView.findViewById(R.id.brandNameTxt);
            pic = itemView.findViewById(R.id.imgBrand);
        }
    }
}
