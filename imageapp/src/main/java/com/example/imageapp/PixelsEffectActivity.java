package com.example.imageapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.imageapp.utils.ImageHelper;

public class PixelsEffectActivity extends AppCompatActivity {

    private ImageView imageView1,imageView2,imageView3,imageView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pixels_effect);
        imageView1 = (ImageView) findViewById(R.id.imageview1);
        imageView2 = (ImageView) findViewById(R.id.imageview2);
        imageView3 = (ImageView) findViewById(R.id.imageview3);
        imageView4 = (ImageView) findViewById(R.id.imageview4);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pic03);
        imageView1.setImageBitmap(bitmap);
        imageView2.setImageBitmap(ImageHelper.handleImageNegative(bitmap));
        imageView3.setImageBitmap(ImageHelper.handleImagePixelsOldPhoto(bitmap));
        imageView4.setImageBitmap(ImageHelper.handleImagePixelsRelief(bitmap));
    }
}
