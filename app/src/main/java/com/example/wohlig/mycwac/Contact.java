package com.example.wohlig.mycwac;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Contact extends AppCompatActivity {

    ImageView i1,i2, i3;
    private TextView tvHead;

    private GestureDetectorCompat gestureDetectorCompatContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Bitmap bitImg = BitmapFactory.decodeResource(getResources(),
                R.drawable.avatar);

        getSupportActionBar().hide();

        i1 = (ImageView) findViewById(R.id.iv1);
        i2 = (ImageView) findViewById(R.id.iv2);
        i3 = (ImageView) findViewById(R.id.iv3);

        i1.setImageBitmap(getRoundedCornerImage(bitImg));
        i2.setImageBitmap(getRoundedCornerImage(bitImg));
        i3.setImageBitmap(getRoundedCornerImage(bitImg));

        tvHead=(TextView)findViewById(R.id.tvHead);
        tvHead.setText("Contact");



        gestureDetectorCompatContact = new GestureDetectorCompat(this, new My2ndGestureListener());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompatContact.onTouchEvent(event);
        Log.d("Inside","onTouch");
        return super.onTouchEvent(event);
    }

    class My2ndGestureListener extends GestureDetector.SimpleOnGestureListener {


        /*@Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {

            Log.d("Inside","onFling");
            if(event2.getX() > event1.getX()){
                *//*Toast.makeText(getBaseContext(),
                        "Swipe left - startActivity()",
                        Toast.LENGTH_SHORT).show();*//*
                Log.d("Inside", "if");
                finish();
                Log.d("Inside", "if");
                overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in);
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
        final float roundPx = 140;

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
        Log.d("Inside", "if");
        overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in);
    }
}