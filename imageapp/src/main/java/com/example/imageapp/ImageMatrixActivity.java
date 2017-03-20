package com.example.imageapp;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;

import com.example.imageapp.view.ImageMatrixView;

public class ImageMatrixActivity extends AppCompatActivity {

    private GridLayout gridLayout;
    private ImageMatrixView imageMatrixView;
    private int edWidth, edHeight;
    private float[] ImageMatrix = new float[9];
    private EditText[] ets = new EditText[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_matrix);

        imageMatrixView = (ImageMatrixView) findViewById(R.id.view);
        gridLayout = (GridLayout) findViewById(R.id.grid_group);

        gridLayout.post(new Runnable() {
            @Override
            public void run() {
                edWidth = gridLayout.getWidth() / 3;
                edHeight = gridLayout.getHeight() / 3;
                addEts();
                initImagematrix();
            }
        });
    }

    private void addEts() {
        for (int i = 0; i < 9; i++) {
            EditText et = new EditText(ImageMatrixActivity.this);
            et.setGravity(Gravity.CENTER);
            ets[i] = et;
            gridLayout.addView(et, edWidth, edHeight);
        }
    }

    private void initImagematrix() {
        for (int i = 0; i < 9; i++) {
            if (i % 4 == 0) {
                ets[i].setText(String.valueOf(1));
            } else {
                ets[i].setText(String.valueOf(0));
            }
        }
    }

    public void change(View view) {
        getImageMatrix();
        Matrix matrix = new Matrix();
        matrix.setValues(ImageMatrix);
        //x轴偏移量 y轴偏移量
//        matrix.setTranslate(150, 150);
//        matrix.setScale(2,2);
        //为了显示顺序效果所以使用post
//        matrix.postTranslate(100,100);
        imageMatrixView.setImageMatrix(matrix);
        imageMatrixView.invalidate();
    }

    public void reset(View view) {
        initImagematrix();
        getImageMatrix();
        Matrix matrix = new Matrix();
        matrix.setValues(ImageMatrix);
        imageMatrixView.setImageMatrix(matrix);
        imageMatrixView.invalidate();
    }

    private void getImageMatrix() {
        for (int i = 0; i < 9; i++) {
            EditText ed = ets[i];
            ImageMatrix[i] = Float.parseFloat(ed.getText().toString());
        }
    }
}
