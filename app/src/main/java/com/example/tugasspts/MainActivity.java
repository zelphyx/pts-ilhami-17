package com.example.tugasspts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import com.example.tugasspts.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


 private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);
        GameAdapter adapter = new GameAdapter(getListGames());
        binding.rvGame.setLayoutManager(new LinearLayoutManager(this));
        binding.rvGame.setAdapter(adapter);
    }



    private ArrayList<Game> getListGames(){
    String[] gamename =getResources().getStringArray(R.array.gamename);
    String[] gamedesc =getResources().getStringArray(R.array.gamedesc);
    TypedArray picture =getResources().obtainTypedArray(R.array.gamepict);
    TypedArray coverposter =getResources().obtainTypedArray(R.array.gamecover);
    ArrayList<Game> games = new ArrayList<>();
    for (int i = 0; i < gamename.length ;i++){
     Game game = new Game();
     game.setName(gamename[i]);
     game.setDesc(gamedesc[i]);
     game.setPict(picture.getResourceId(i,-1));
     game.setCover(coverposter.getResourceId(i,-1));
     games.add(game);
}
        return games;
    }
}



