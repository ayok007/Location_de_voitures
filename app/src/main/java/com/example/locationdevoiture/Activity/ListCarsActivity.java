package com.example.locationdevoiture.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.locationdevoiture.Adapter.CarListAdapter;
import com.example.locationdevoiture.Domain.Cars;
import com.example.locationdevoiture.R;
import com.example.locationdevoiture.databinding.ActivityListCarsBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListCarsActivity extends BaseActivity {
    ActivityListCarsBinding binding;
    private RecyclerView.Adapter adapterListCar;
    private int BrandId;
    private String brandName;
    private String searchText;
    private boolean isSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListCarsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        initList();
    }

    private void initList() {
        DatabaseReference myRef = database.getReference("Cars");
        binding.progressBar.setVisibility(View.VISIBLE);
        ArrayList<Cars> list = new ArrayList<>();

        Query query;
        if (isSearch){
            query = myRef.orderByChild("Title").startAt(searchText).endAt(searchText+'\uf8ff');
        } else {
            query = myRef.orderByChild("BrandId").equalTo(BrandId);
        }
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot issue: snapshot.getChildren()){
                        list.add(issue.getValue(Cars.class));
                    }
                    if (list.size()>0){
                        binding.carListRecyclerView.setLayoutManager(new GridLayoutManager(ListCarsActivity.this,2));
                        adapterListCar = new CarListAdapter(list);
                        binding.carListRecyclerView.setAdapter(adapterListCar);
                    }
                    binding.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getIntentExtra() {
        brandName = getIntent().getStringExtra("BrandName");
        BrandId = getIntent().getIntExtra("brandId",1);
        searchText = getIntent().getStringExtra("text");
        isSearch = getIntent().getBooleanExtra("isSearch",false);

        binding.titleTxt.setText(brandName);
        binding.backBtn.setOnClickListener(v ->finish());
    }
}