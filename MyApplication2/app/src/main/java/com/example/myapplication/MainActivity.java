package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private ImageView h;
    private Animation topanim,bottomanim;
    private static int SPLASH_SCREEN =5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView((R.layout.activity_main));
        text=findViewById(R.id.txt);
        h=findViewById(R.id.home);
        topanim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomanim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        h.setAnimation(topanim);
        text.setAnimation(bottomanim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,login.class));
            }
        },SPLASH_SCREEN);
        Thread thread=new Thread(){
            @Override
            public void run(){
                try {
                    sleep(4000);
                    Intent russplash=new Intent(getApplicationContext(),login.class);
                    startActivities(new Intent[]{russplash});
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }}};
        thread.start();
    }
}