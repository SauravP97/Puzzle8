package com.example.hp.puzzle8;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    Button Play,Credits;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        player = MediaPlayer.create(this, R.raw.mainbg);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);
        player.start();
        setContentView(R.layout.activity_main);
        Play=(Button)findViewById(R.id.button);
        Credits=(Button)findViewById(R.id.credits);
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     Intent ourintent = new Intent(getApplicationContext(),Game.class);
                     startActivity(ourintent);
            }
        });
        Credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cred = new Intent(getApplicationContext(),credits.class);
                startActivity(cred);
            }
        });
    }
    protected void onStop(){
        super.onStop();
        player.release();
    }

}
