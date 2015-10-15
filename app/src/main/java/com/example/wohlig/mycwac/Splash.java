package com.example.wohlig.mycwac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        Thread timer = new Thread(){

            public void run(){
                try{
                    sleep(3000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent main = new Intent(Splash.this,MainActivity.class);
                    startActivity(main);
                }
            }
        };
        timer.start();
    }

    @Override
    protected  void onPause(){
        super.onPause();
        finish();
    }

}
