package com.example.wohlig.mycwac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Gallery extends AppCompatActivity {

    private TextView tvHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        getSupportActionBar().hide();

        tvHead=(TextView)findViewById(R.id.tvHead);
        tvHead.setText("Gallery");



    }

    public void backMain (View v){
        finish();
    }

    public void openAlbum (View v){

        Intent intent = new Intent(Gallery.this, OpenAlbum.class);
        startActivity(intent);
    }


}
