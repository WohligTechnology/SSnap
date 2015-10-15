package com.example.wohlig.mycwac;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;


public class Chat extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView tvHead;
    private TabHost tabHost;
    private  int i=0;
    ImageView i1,i2, i3,i4,i5,i6;

    private GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        tvHead=(TextView)findViewById(R.id.tvHead);
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec compat = tabHost.newTabSpec("Group");
        compat.setIndicator("Group");
        compat.setContent(R.id.tab1);
        tabHost.addTab(compat);

        TabHost.TabSpec compat1 = tabHost.newTabSpec("User");
        compat1.setIndicator("User");
        compat1.setContent(R.id.tab2);
        tabHost.addTab(compat1);


        getSupportActionBar().hide();
        tvHead.setText("Chat");

        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.parseColor("#009587"));
        }
        /*tabHost.getTabWidget().setStripEnabled(true);*/
        /*tabHost.getTabWidget().setCurrentTab(1);
        tabHost.getTabWidget().focusCurrentTab(1);*/


        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String arg0) {
                int x=tabHost.getCurrentTab();
                Log.d("Y",Integer.toString(x));
                tabHost.getTabWidget().setCurrentTab(x);
                tabHost.getTabWidget().focusCurrentTab(x);


            }
        });


        Bitmap bitImg = BitmapFactory.decodeResource(getResources(), R.drawable.avatar);
        i1 = (ImageView) findViewById(R.id.iv1);
        i2 = (ImageView) findViewById(R.id.iv2);
        i3 = (ImageView) findViewById(R.id.iv3);
        i4 = (ImageView) findViewById(R.id.iv4);
        i5 = (ImageView) findViewById(R.id.iv5);
        i6 = (ImageView) findViewById(R.id.iv6);

        i1.setImageBitmap(getRoundedCornerImage(bitImg));
        i2.setImageBitmap(getRoundedCornerImage(bitImg));
        i3.setImageBitmap(getRoundedCornerImage(bitImg));
        i4.setImageBitmap(getRoundedCornerImage(bitImg));
        i5.setImageBitmap(getRoundedCornerImage(bitImg));
        i6.setImageBitmap(getRoundedCornerImage(bitImg));



        gestureDetectorCompat = new GestureDetectorCompat(this, new My3rdGestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class My3rdGestureListener extends GestureDetector.SimpleOnGestureListener {

        /*@Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {


            if(event2.getX() < event1.getX()){
                finish();

                overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
            }
            return true;
        }*/
    }

    public static Bitmap getRoundedCornerImage(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = 1000;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);


        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;

    }

    public void back(View v){

        finish();

        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
    }
}
