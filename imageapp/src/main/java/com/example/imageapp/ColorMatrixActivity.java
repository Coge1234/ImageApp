package com.example.imageapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

public class ColorMatrixActivity extends AppCompatActivity {

    private ImageView imageView;
    private GridLayout gridLayout;
    private Bitmap bitmap;
    private int etWidth, etHeight;
    private EditText[] ets = new EditText[20];
    //对应的矩阵
    private float[] colorMatrixs = new float[20];
    private Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matrix);

        imageView = (ImageView) findViewById(R.id.imageview2Id);
        gridLayout = (GridLayout) findViewById(R.id.group);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic02);
        imageView.setImageBitmap(bitmap);

        gridLayout.post(new Runnable() {
            @Override
            public void run() {
                //绘制后执行
                etWidth = gridLayout.getWidth()/5;
                etHeight = gridLayout.getHeight()/4;
                addEts();
                initMatrix();
            }
        });
    }

    private void addEts(){
        //按住ctrl+J弹出for模板
        for (int i = 0; i < 20; i++) {
            EditText editText = new EditText(ColorMatrixActivity.this);
            editText.setGravity(Gravity.CENTER);
            ets[i] = editText;
            gridLayout.addView(editText,etWidth,etHeight);
        }
    }

    private void initMatrix(){
        for (int i = 0; i < 20; i++) {
            if (i%6 == 0){
                ets[i].setText(String.valueOf(1));
            }else{
                ets[i].setText(String.valueOf(0));
            }
        }
    }

    private void getMatrix(){
        for (int i = 0; i < 20; i++) {
            colorMatrixs[i] = Float.valueOf(ets[i].getText().toString());
        }
    }

    private void setImageMatrix(){
        bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(colorMatrixs);

        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap,0,0,paint);
        imageView.setImageBitmap(bmp);
    }
    public void changebtnOnClickListener(View view) {
        getMatrix();
        setImageMatrix();
    }

    public void resetbtnOnClickListener(View view) {
        initMatrix();
        getMatrix();
        setImageMatrix();
    }
}
