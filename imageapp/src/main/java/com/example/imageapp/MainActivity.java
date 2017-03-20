package com.example.imageapp;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PrimaryBtnOnClickListener(View view) {
        Intent intent = new Intent(this, PrimaryColorActivity.class);
        startActivity(intent);
    }

    public void ColorMatrixBtnOnClickListener(View view) {
        Intent intent = new Intent(this, ColorMatrixActivity.class);
        startActivity(intent);
    }

    public void PixelsEffectOnClickListener(View view) {
        Intent intent = new Intent(this, PixelsEffectActivity.class);
        startActivity(intent);
    }

    public void MatrixOnClickListener(View view) {
        Intent intent = new Intent(this, ImageMatrixActivity.class);
        startActivity(intent);
    }

    public void XfermodeOnClickListener(View view) {
        Intent intent = new Intent(this, RoundRectxfermodeActivity.class);
        startActivity(intent);
    }

    public void ShaderOnClickListener(View view) {
        Intent intent = new Intent(this, BitmapShaderActivity.class);
        startActivity(intent);
    }

    public void ReflectOnClickListener(View view) {
        Intent intent = new Intent(this, ReflectViewActivity.class);
        startActivity(intent);
    }

    public void MeshViewOnClickListener(View view) {
        Intent intent = new Intent(this, MeshViewActivity.class);
        startActivity(intent);
    }

    public void TestLeakcanaryOnClickListener(View view) {
        test();
        finish();
        Intent intent = new Intent(this, TestLeakcanaryActivity.class);
        startActivity(intent);
    }

    // 这里会发生内存泄漏
    public static void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
