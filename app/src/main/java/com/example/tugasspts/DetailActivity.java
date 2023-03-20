package com.example.tugasspts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tugasspts.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);



        Intent intent = getIntent();
        String gamename = intent.getStringExtra("name");
        String gamedesc = intent.getStringExtra("desc");
        int gameimage = intent.getIntExtra("image",R.drawable.valorantpict);
        int gamecover = intent.getIntExtra("cover",R.drawable.valorantcover);

        binding.gameName.setText(gamename);
        binding.gameDesc.setText(gamedesc);
        binding.gamePict.setImageResource(gameimage);
        binding.cover.setImageResource(gamecover);
}}