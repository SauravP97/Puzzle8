package com.example.hp.puzzle8;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Game extends AppCompatActivity {
     MediaPlayer success;
     MediaPlayer fail,shuffles,won;
    Button[] b = new Button[9];
    GridLayout grid;
    ImageButton voice;
    String result;
    Button shuff;
    TextView tvr;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen2);
        grid=(GridLayout)findViewById(R.id.grid1);
        shuff=(Button)findViewById(R.id.shuf);
        b[0]=(Button)findViewById(R.id.but0);
        b[1]=(Button)findViewById(R.id.but1);
        b[2]=(Button)findViewById(R.id.but2);
        b[3]=(Button)findViewById(R.id.but3);
        b[4]=(Button)findViewById(R.id.but4);
        b[5]=(Button)findViewById(R.id.but5);
        b[6]=(Button)findViewById(R.id.but6);
        b[7]=(Button)findViewById(R.id.but7);
        b[8]=(Button)findViewById(R.id.but8);
        tvr=(TextView)findViewById(R.id.resultHere);
        success = MediaPlayer.create(this,R.raw.smb_coin);
        fail = MediaPlayer.create(this,R.raw.smb_bump);
        shuffles = MediaPlayer.create(this,R.raw.smb_breakblock);
        won=MediaPlayer.create(this,R.raw.smb_world_clear);
        voice=(ImageButton)findViewById(R.id.Voice);
        shuffle();
        color();
        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               promptSpeechInput();
            }
        });

        shuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shuffles.start();
                shuffle();
            }
        });

        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b[2].getText().toString().equals("0")){
                    String str = b[1].getText().toString();
                    b[2].setText(str);
                    b[1].setText("0");
                    success.start();
                    matchIt();
                }
                else if(b[4].getText().toString().equals("0")){
                    String str = b[1].getText().toString();
                    b[4].setText(str);
                    b[1].setText("0");
                    success.start();
                    matchIt();
                }
                else{
                     fail.start();
                }
                color();
            }
        });
        b[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b[3].getText().toString().equals("0")) {
                    String str = b[2].getText().toString();
                    b[3].setText(str);
                    b[2].setText("0");
                    success.start();
                    matchIt();
                }
                else if (b[1].getText().toString().equals("0")) {
                    String str = b[2].getText().toString();
                    b[1].setText(str);
                    b[2].setText("0");
                    success.start();
                    matchIt();
                }
                else if (b[5].getText().toString().equals("0")) {
                    String str = b[2].getText().toString();
                    b[5].setText(str);
                    b[2].setText("0");
                    success.start();
                    matchIt();
                }
                else{
                    fail.start();
                }
                color();
            }
        });
        b[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b[2].getText().toString().equals("0")) {
                    String str = b[3].getText().toString();
                    b[2].setText(str);
                    b[3].setText("0");
                    success.start();
                    matchIt();
                }
                else if (b[6].getText().toString().equals("0")) {
                    String str = b[3].getText().toString();
                    b[6].setText(str);
                    b[3].setText("0");
                    success.start();
                    matchIt();
                }
                else{
                    fail.start();
                }
                color();
            }
        });
       b[4].setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(b[1].getText().toString().equals("0")) {
                   String str = b[4].getText().toString();
                   b[1].setText(str);
                   b[4].setText("0");
                   matchIt();
                   success.start();
               }
               else if(b[5].getText().toString().equals("0")) {
                   String str = b[4].getText().toString();
                   b[5].setText(str);
                   b[4].setText("0");
                   success.start();
                   matchIt();
               }
               else if(b[7].getText().toString().equals("0")) {
                   String str = b[4].getText().toString();
                   b[7].setText(str);
                   b[4].setText("0");
                   success.start();
                   matchIt();
               }
               else{
                   fail.start();
               }
               color();
           }
       });
       b[5].setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(b[2].getText().toString().equals("0")) {
                   String str = b[5].getText().toString();
                   b[2].setText(str);
                   b[5].setText("0");
                   success.start();
                   matchIt();
               }
               else if(b[4].getText().toString().equals("0")) {
                   String str = b[5].getText().toString();
                   b[4].setText(str);
                   b[5].setText("0");
                   success.start();
                   matchIt();
               }
               else if(b[6].getText().toString().equals("0")) {
                   String str = b[5].getText().toString();
                   b[6].setText(str);
                   b[5].setText("0");
                   success.start();
                   matchIt();
               }
               else if(b[8].getText().toString().equals("0")) {
                   String str = b[5].getText().toString();
                   b[8].setText(str);
                   b[5].setText("0");
                   success.start();
                   matchIt();
               }
               else{
                   fail.start();
               }
               color();
           }
       });
       b[6].setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(b[3].getText().toString().equals("0")) {
                   String str = b[6].getText().toString();
                   b[3].setText(str);
                   b[6].setText("0");
                   success.start();
                   matchIt();
               }
               else if(b[5].getText().toString().equals("0")) {
                   String str = b[6].getText().toString();
                   b[5].setText(str);
                   b[6].setText("0");
                   success.start();
                   matchIt();
               }
               else if(b[0].getText().toString().equals("0")) {
                   String str = b[6].getText().toString();
                   b[0].setText(str);
                   b[6].setText("0");
                   success.start();
                   matchIt();
               }
               else{
                 fail.start();
               }
               color();
           }
       });
       b[7].setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(b[4].getText().toString().equals("0")) {
                   String str = b[7].getText().toString();
                   b[4].setText(str);
                   b[7].setText("0");
                   success.start();
                   matchIt();
               }
               else if(b[8].getText().toString().equals("0")) {
                   String str = b[7].getText().toString();
                   b[8].setText(str);
                   b[7].setText("0");
                   success.start();
                   matchIt();
               }
               else{
                   fail.start();
               }
               color();
           }
       });
       b[8].setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(b[5].getText().toString().equals("0")) {
                   String str = b[8].getText().toString();
                   b[5].setText(str);
                   b[8].setText("0");
                   success.start();
                   matchIt();
               }
               else if(b[7].getText().toString().equals("0")) {
                   String str = b[8].getText().toString();
                   b[7].setText(str);
                   b[8].setText("0");
                   success.start();
                   matchIt();
               }
               else if(b[0].getText().toString().equals("0")) {
                   String str = b[8].getText().toString();
                   b[0].setText(str);
                   b[8].setText("0");
                   success.start();
                   matchIt();
               }
               else{
                   fail.start();
               }
               color();
           }
       });
       b[0].setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(b[6].getText().toString().equals("0")) {
                   String str = b[0].getText().toString();
                   b[6].setText(str);
                   b[0].setText("0");
                   success.start();
                   matchIt();
               }
               else if(b[8].getText().toString().equals("0")) {
                   String str = b[0].getText().toString();
                   b[8].setText(str);
                   b[0].setText("0");
                   success.start();
                   matchIt();
               }
               else{
                   fail.start();
               }
               color();
           }
       });
    }
    public void promptSpeechInput(){
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say your Move!");

        try{
            startActivityForResult(i, 100);
        }
        catch(ActivityNotFoundException a){
            Toast.makeText(Game.this,"Sorry your device does not support speech language",Toast.LENGTH_LONG).show();
        }
    }
    public void onActivityResult(int request_code, int result_code, Intent i){
        super.onActivityResult(request_code,result_code,i);

        switch(request_code)
        {
            case 100: if(result_code== RESULT_OK && i!=null){
                         ArrayList<String> results = i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                         result=results.get(0);
                         tvr.setText(result);
                         yourMove(result);
                     }
                     break;
        }
    }
    int up(int success){
        for(int i=0;i<9;i++){
            int j=Integer.parseInt(b[i].getText().toString());
            if(j==0){
                if(i==1){
                    String str = b[4].getText().toString();
                    b[4].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==2){
                    String str = b[5].getText().toString();
                    b[5].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==3){
                    String str = b[6].getText().toString();
                    b[6].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==4){
                    String str = b[7].getText().toString();
                    b[7].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==5){
                    String str = b[8].getText().toString();
                    b[8].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==6){
                    String str = b[0].getText().toString();
                    b[0].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==0){

                    break;
                }
                else if(i==8){

                    break;
                }
                else if(i==7){

                    break;
                }
            }
        }
        return success;
    }
    int down(int success){
        for(int i=0;i<9;i++){
            int j=Integer.parseInt(b[i].getText().toString());
            if(j==0){
                if(i==0){
                    String str = b[6].getText().toString();
                    b[6].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==4){
                    String str = b[1].getText().toString();
                    b[1].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==5){
                    String str = b[2].getText().toString();
                    b[2].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==6){
                    String str = b[3].getText().toString();
                    b[3].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==7){
                    String str = b[4].getText().toString();
                    b[4].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==8){
                    String str = b[5].getText().toString();
                    b[5].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==1){

                    break;
                }
                else if(i==2){

                    break;
                }
                else if(i==3){

                    break;
                }
            }
        }
        return success;
    }

    int left(int success){
        for(int i=0;i<9;i++){
            int j=Integer.parseInt(b[i].getText().toString());
            if(j==0){
                if(i==0){

                    break;
                }
                else if(i==3){

                    break;
                }
                else if(i==6){

                    break;
                }
                else if(i==1){
                    String str = b[2].getText().toString();
                    b[2].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==2){
                    String str = b[3].getText().toString();
                    b[3].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==4){
                    String str = b[5].getText().toString();
                    b[5].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==5){
                    String str = b[6].getText().toString();
                    b[6].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==7){
                    String str = b[8].getText().toString();
                    b[8].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==8){
                    String str = b[0].getText().toString();
                    b[0].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }

            }
        }
        return success;
    }
    int right(int success){
        for(int i=0;i<9;i++){
            int j =Integer.parseInt(b[i].getText().toString());
            if(j==0){
                if(i==0){
                    String str = b[8].getText().toString();
                    b[8].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==1){

                    break;
                }
                else if(i==2){
                    String str = b[1].getText().toString();
                    b[1].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==3){
                    String str = b[2].getText().toString();
                    b[2].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==4){

                    break;
                }
                else if(i==5){
                    String str = b[4].getText().toString();
                    b[4].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==6){
                    String str = b[5].getText().toString();
                    b[5].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
                else if(i==7){

                    break;
                }
                else if(i==8){
                    String str = b[7].getText().toString();
                    b[7].setText("0");
                    b[i].setText(str);
                    success++;
                    break;
                }
            }
        }
        return success;
    }
    public void color(){
        for(int i=0;i<9;i++){
            if(b[i].getText().toString().equals("0")){
                b[i].setBackgroundColor(Color.argb(100,255,255,255));
            }
            else if(b[i].getText().toString().equals("1")||b[i].getText().toString().equals("2")||b[i].getText().toString().equals("3")){
                b[i].setBackgroundColor(Color.rgb(245,138,30));
            }
            else if(b[i].getText().toString().equals("4")||b[i].getText().toString().equals("5")||b[i].getText().toString().equals("6")){
                b[i].setBackgroundColor(Color.rgb(241,202,45));
            }
            else{
                b[i].setBackgroundColor(Color.rgb(241,229,45));
            }
        }
    }

    public void shuffle(){

        int success=0;
        while(success<20){
            Random r = new Random();
            int i1 = r.nextInt(100-1)+1;

            if(i1<=25){
               success=up(success);
            }
            else if(i1<=50){
               success = down(success);
            }
            else if(i1<=75){
              success = left(success);
            }
            else{
              success = right(success);
            }

        }
        color();

    }
    public void matchIt(){
        if(b[1].getText().toString().equals("1")&&b[2].getText().toString().equals("2")&&b[3].getText().toString().equals("3")&&b[4].getText().toString().equals("4")&&b[5].getText().toString().equals("5")&&b[6].getText().toString().equals("6")&&b[7].getText().toString().equals("7")&&b[8].getText().toString().equals("8")&&b[0].getText().toString().equals("0")){
            won.start();
            Toast.makeText(Game.this,"CONGO !!! YOU WON THE GAME",Toast.LENGTH_LONG).show();
        }

    }
    public void yourMove(String result1){

        if(result1.equals("right")){
            for(int i=0;i<9;i++){
                int j =Integer.parseInt(b[i].getText().toString());
                if(j==0){
                    if(i==0){
                        String str = b[8].getText().toString();
                        b[8].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==1){
                        Toast.makeText(Game.this,"Invalid Move",Toast.LENGTH_LONG).show();
                        fail.start();
                        break;
                    }
                    else if(i==2){
                        String str = b[1].getText().toString();
                        b[1].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;

                    }
                    else if(i==3){
                        String str = b[2].getText().toString();
                        b[2].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==4){
                        Toast.makeText(Game.this,"Invalid Move",Toast.LENGTH_LONG).show();
                        fail.start();
                        break;
                    }
                    else if(i==5){
                        String str = b[4].getText().toString();
                        b[4].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==6){
                        String str = b[5].getText().toString();
                        b[5].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==7){
                        Toast.makeText(Game.this,"Invalid Move",Toast.LENGTH_LONG).show();
                        fail.start();
                        break;
                    }
                    else if(i==8){
                        String str = b[7].getText().toString();
                        b[7].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                }
            }
            matchIt();
        }
        else if(result1.equals("left")){
            for(int i=0;i<9;i++){
                int j=Integer.parseInt(b[i].getText().toString());
                if(j==0){
                    if(i==0){
                        Toast.makeText(Game.this,"Invalid Move",Toast.LENGTH_LONG).show();
                        fail.start();
                        break;
                    }
                    else if(i==3){
                        Toast.makeText(Game.this,"Invalid Move",Toast.LENGTH_LONG).show();
                        fail.start();
                        break;
                    }
                    else if(i==6){
                        Toast.makeText(Game.this,"Invalid Move",Toast.LENGTH_LONG).show();
                        fail.start();
                        break;
                    }
                    else if(i==1){
                        String str = b[2].getText().toString();
                        b[2].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==2){
                        String str = b[3].getText().toString();
                        b[3].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==4){
                        String str = b[5].getText().toString();
                        b[5].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==5){
                        String str = b[6].getText().toString();
                        b[6].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==7){
                        String str = b[8].getText().toString();
                        b[8].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==8){
                        String str = b[0].getText().toString();
                        b[0].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }

                }
            }
            matchIt();
        }
        else if(result1.equals("up")){
            for(int i=0;i<9;i++){
                int j=Integer.parseInt(b[i].getText().toString());
                if(j==0){
                    if(i==1){
                        String str = b[4].getText().toString();
                        b[4].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==2){
                        String str = b[5].getText().toString();
                        b[5].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==3){
                        String str = b[6].getText().toString();
                        b[6].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==4){
                        String str = b[7].getText().toString();
                        b[7].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==5){
                        String str = b[8].getText().toString();
                        b[8].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==6){
                        String str = b[0].getText().toString();
                        b[0].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    }
                    else if(i==0){
                        Toast.makeText(Game.this,"Invalid Move",Toast.LENGTH_LONG).show();
                        fail.start();
                        break;
                    }
                    else if(i==8){
                        Toast.makeText(Game.this,"Invalid Move",Toast.LENGTH_LONG).show();
                        fail.start();
                        break;
                    }
                    else if(i==7){
                        Toast.makeText(Game.this,"Invalid Move",Toast.LENGTH_LONG).show();
                        fail.start();
                        break;
                    }
                }
            }
            matchIt();
        }
        else if(result1.equals("down")){
            for(int i=0;i<9;i++) {
                int j = Integer.parseInt(b[i].getText().toString());
                if (j == 0) {
                    if (i == 0) {
                        String str = b[6].getText().toString();
                        b[6].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    } else if (i == 4) {
                        String str = b[1].getText().toString();
                        b[1].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    } else if (i == 5) {
                        String str = b[2].getText().toString();
                        b[2].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    } else if (i == 6) {
                        String str = b[3].getText().toString();
                        b[3].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    } else if (i == 7) {
                        String str = b[4].getText().toString();
                        b[4].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    } else if (i == 8) {
                        String str = b[5].getText().toString();
                        b[5].setText("0");
                        b[i].setText(str);
                        success.start();
                        break;
                    } else if (i == 1) {
                        Toast.makeText(Game.this, "Invalid Move", Toast.LENGTH_LONG).show();
                        fail.start();
                        break;
                    } else if (i == 2) {
                        Toast.makeText(Game.this, "Invalid Move", Toast.LENGTH_LONG).show();
                        fail.start();
                        break;
                    } else if (i == 3) {
                        Toast.makeText(Game.this, "Invalid Move", Toast.LENGTH_LONG).show();
                        fail.start();
                        break;
                    }
                }
            }
            matchIt();

        }
      color();
    }
}
