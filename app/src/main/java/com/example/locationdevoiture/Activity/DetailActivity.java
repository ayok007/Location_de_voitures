package com.example.locationdevoiture.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.locationdevoiture.Domain.Cars;
import com.example.locationdevoiture.Helper.ManagmentCart;
import com.example.locationdevoiture.R;
import com.example.locationdevoiture.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity {
    ActivityDetailBinding binding;
    private Cars object;
    private ManagmentCart managmentCart;
    private int num=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));

        getIntentExtra();
        setVariable();
    }

    private void setVariable() {
        managmentCart = new ManagmentCart(this);
        binding.backBtn.setOnClickListener(v -> finish());

        Glide.with(DetailActivity.this)
                .load(object.getImagePath())
                .into(binding.pic);

        binding.priceTxt.setText("£"+object.getPrice());
        binding.titleTxt.setText(object.getTitle());
        binding.descriptionTxt.setText(object.getDescription());
        binding.rateTxt.setText(object.getStar()+" Rating");
        binding.ratingBar.setRating((float) object.getStar());
        binding.totalTxt.setText("£"+(num * object.getPrice()));

        binding.plusBtn.setOnClickListener(v -> {
            num=num+1;
            binding.numTxt.setText(num+" ");
            binding.totalTxt.setText("£"+(num * object.getPrice()));
        });

        binding.minusBtn.setOnClickListener(v -> {
            if (num>1){
                num = num - 1;
                binding.numTxt.setText(num+"");
                binding.totalTxt.setText("£"+(num * object.getPrice()));
            }
        });

        binding.addBtn.setOnClickListener(v -> {
            object.setNumberInCart(num);
            managmentCart.insertCar(object);
        });
    }

    private void getIntentExtra() {
        object = (Cars) getIntent().getSerializableExtra("object");
    }
}