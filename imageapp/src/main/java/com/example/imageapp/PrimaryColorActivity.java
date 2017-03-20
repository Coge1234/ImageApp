package com.example.imageapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.imageapp.utils.ImageHelper;

public class PrimaryColorActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private ImageView imageView;
    private SeekBar HueSeekbar, SaturationSeekbar, LumSeekbar;

    private static int MAX_VALUE = 255;
    private static int MID_VALUE = 127;
    private float mHue, mSaturation, mLum;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_color);

        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pic01);
        imageView = (ImageView) findViewById(R.id.imageviewId);
        HueSeekbar = (SeekBar) findViewById(R.id.HueSeekbarId);
        SaturationSeekbar = (SeekBar) findViewById(R.id.SaturationSeekbar);
        LumSeekbar = (SeekBar) findViewById(R.id.LumSeekBar);

        HueSeekbar.setOnSeekBarChangeListener(this);
        SaturationSeekbar.setOnSeekBarChangeListener(this);
        LumSeekbar.setOnSeekBarChangeListener(this);

        HueSeekbar.setMax(MAX_VALUE);
        SaturationSeekbar.setMax(MAX_VALUE);
        LumSeekbar.setMax(MAX_VALUE);

        HueSeekbar.setProgress(MID_VALUE);
        SaturationSeekbar.setProgress(MID_VALUE);
        LumSeekbar.setProgress(MID_VALUE);

        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.HueSeekbarId:
                mHue = ((progress-MID_VALUE)*1.0f)/MID_VALUE*180;
                break;
            case R.id.SaturationSeekbar:
                mSaturation = progress*1.0f/MID_VALUE;
                break;
            case R.id.LumSeekBar:
                mLum = progress*1.0f/MID_VALUE;
                break;
        }
        imageView.setImageBitmap(ImageHelper.handleImageEffect(bitmap,mHue,mSaturation,mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
