package com.example.imageapp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.example.imageapp.R;

/**
 * Created by Administrator on 2017/2/24.
 */

public class MeshView extends View {
    private int WIDTH = 200;
    private int HEIGHT = 200;
    private int COUNT = (WIDTH + 1) * (HEIGHT + 1);
    //用一位数组表达二维数组，奇数位存储横坐标，偶数位存储纵坐标
    private float[] verts = new float[COUNT * 2];
    //用于存储图像原有交点
    private float[] orig = new float[COUNT * 2];
    private Bitmap bitmap;
    private float K = 1;

    public MeshView(Context context) {
        super(context);
        initView();
    }

    public MeshView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MeshView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        int index = 0;
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic05);
        float bmWidth = bitmap.getWidth();
        float bmHeight = bitmap.getHeight();

        for (int i = 0; i < HEIGHT + 1; i++) {
            float fy = bmHeight * i / HEIGHT;
            for (int j = 0; j < WIDTH + 1; j++) {
                float fx = bmWidth * j / WIDTH;
                orig[index * 2 + 0] = verts[index * 2 + 0] = fx;
                orig[index * 2 + 1] = verts[index * 2 + 1] = fy + 100;
                index++;
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < HEIGHT + 1; i++) {
            for (int j = 0; j < WIDTH + 1; j++) {
//                verts[(i*(WIDTH+1)+j)*2+0] += 0;
                float offsetY = (float) Math.sin((float) j / WIDTH * 2 * Math.PI + K * 2 * Math.PI);
                verts[(i * (WIDTH + 1) + j) * 2 + 1] =
                        orig[(i * (WIDTH + 1) + j) * 2 + 1] + offsetY * 20;
            }
        }
        K += 0.1f;
        canvas.drawBitmapMesh(bitmap, WIDTH, HEIGHT,
                verts, 0, null, 0, null);
        invalidate();
    }
}
