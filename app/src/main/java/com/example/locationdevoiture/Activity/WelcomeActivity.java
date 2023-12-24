package com.example.locationdevoiture.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.locationdevoiture.R;
import com.example.locationdevoiture.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends BaseActivity {
    ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
        getWindow().setStatusBarColor(Color.parseColor("#EDD44F"));
    }

    private void setVariable() {
        binding.loginBtn.setOnClickListener(v -> {
            if (mAuth.getCurrentUser() != null){
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            } else {
                startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
            }
        });

        binding.signupBtn.setOnClickListener(v -> startActivity(new Intent(WelcomeActivity.this, SignupActivity.class)));
    }
}