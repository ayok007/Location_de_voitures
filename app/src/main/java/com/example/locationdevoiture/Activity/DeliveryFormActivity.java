package com.example.locationdevoiture.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.locationdevoiture.Domain.Cars;
import com.example.locationdevoiture.Domain.Form;
import com.example.locationdevoiture.R;
import com.example.locationdevoiture.databinding.ActivityDeliveryFormBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class DeliveryFormActivity extends AppCompatActivity {

    private EditText fullName, phone, email, address;
    ArrayList<Cars> orderedCars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_form);


        fullName = findViewById(R.id.userName);
        phone = findViewById(R.id.userPhone);
        email = findViewById(R.id.userEmail);
        address = findViewById(R.id.userAddress);

        getIntentExtra();
        setVariable();
    }

    private void getIntentExtra() {
        orderedCars = (ArrayList<Cars>) getIntent().getSerializableExtra("order");
    }
    private void setVariable() {

        View submitBtn = findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userFullName = fullName.getText().toString();
                String userPhone = phone.getText().toString();
                String userEmail = email.getText().toString();
                String userAddress = address.getText().toString();

                Form userForm = new Form(userFullName, userPhone, userEmail, userAddress, orderedCars);
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference myRef = db.getReference("Users");


                myRef.child(userFullName).setValue(userForm);
                Toast.makeText(DeliveryFormActivity.this, "Your Form has been submitted successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(DeliveryFormActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}