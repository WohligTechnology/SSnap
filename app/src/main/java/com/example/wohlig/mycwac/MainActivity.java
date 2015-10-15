package com.example.wohlig.mycwac;

/*
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.commonsware.cwac.camera.CameraHost;
import com.commonsware.cwac.camera.CameraHostProvider;
import com.commonsware.cwac.camera.SimpleCameraHost;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    // Tab titles

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);


    }
}*/

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;

import com.commonsware.cwac.camera.CameraHost;
import com.commonsware.cwac.camera.CameraHostProvider;
import com.commonsware.cwac.camera.SimpleCameraHost;

public class MainActivity extends AppCompatActivity implements CameraHostProvider{

    private GestureDetectorCompat gestureDetectorCompat;
    private DemoCameraFragment current=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());

        getSupportActionBar().hide();

        current=new DemoCameraFragment();

        getFragmentManager().beginTransaction()
                .replace(R.id.container, current).commit();


    }

    @Override
    public CameraHost getCameraHost() {
        return(new SimpleCameraHost(this));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        //handle 'swipe left' action only

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {


            if(event2.getX() > event1.getX()){

                /*Toast.makeText(getBaseContext(),
                        "Swipe right - finish()",
                        Toast.LENGTH_SHORT).show();*/

                //finish();

                /*Intent intent = new Intent(
                        MainActivity.this, Chat.class);
                startActivity(intent);

                overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in);*/

                //overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
            }

            if(event2.getX() < event1.getX()){
                /*Toast.makeText(getBaseContext(),
                        "Swipe right - finish()",
                        Toast.LENGTH_SHORT).show();*/

                //finish();

                /*Intent intent = new Intent(
                        MainActivity.this, Contact.class);
                startActivity(intent);

                overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);*/
                
                //overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
            }
            return true;
        }
    }

    public void right(View v){

        Intent intent = new Intent(
                MainActivity.this, Contact.class);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
    }

    public void left(View v){

        Intent intent = new Intent(
                MainActivity.this, Chat.class);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in);
    }

    public void gallery(View v){

        Intent intent = new Intent(
                MainActivity.this, Gallery.class);
        startActivity(intent);

        //overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in);
    }
}
