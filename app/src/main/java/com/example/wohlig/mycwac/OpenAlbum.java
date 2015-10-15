package com.example.wohlig.mycwac;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;



public class OpenAlbum extends AppCompatActivity {

    private TextView tvHead;
    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_album);

        tvHead = (TextView) findViewById(R.id.tvHead);
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec compat = tabHost.newTabSpec("Group");
        compat.setIndicator("Photos");
        compat.setContent(R.id.tab1);
        tabHost.addTab(compat);

        TabHost.TabSpec compat1 = tabHost.newTabSpec("User");
        compat1.setIndicator("Videos");
        compat1.setContent(R.id.tab2);
        tabHost.addTab(compat1);


        getSupportActionBar().hide();
        tvHead.setText("Camera Roll");

        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.parseColor("#009587"));
        }
        /*tabHost.getTabWidget().setStripEnabled(true);*/
        /*tabHost.getTabWidget().setCurrentTab(1);
        tabHost.getTabWidget().focusCurrentTab(1);*/


        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String arg0) {
                int x = tabHost.getCurrentTab();
                Log.d("Y", Integer.toString(x));
                tabHost.getTabWidget().setCurrentTab(x);
                tabHost.getTabWidget().focusCurrentTab(x);


            }
        });
    }



    public void back (View v){
        finish();
    }

    public void openFilmStrip (View v){

        Intent intent = new Intent(OpenAlbum.this, FilmStrip.class);
        startActivity(intent);

    }

}
