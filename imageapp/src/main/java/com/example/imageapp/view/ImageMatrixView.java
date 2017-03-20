package com.example.imageapp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

import com.example.imageapp.R;

/**
 * Created by Administrator on 2017/2/23.
 */

public class ImageMatrixView extends View {
    private Bitmap bitmap;
    private Matrix matrix;
    public ImageMatrixView(Context context) {
        super(context);
        initView();
    }

    public ImageMatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ImageMatrixView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        setImageMatrix(new Matrix());
    }
    public void setImageMatrix(Matrix matrix){
        this.matrix = matrix;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //原图
        canvas.drawBitmap(bitmap,0,0,null);
        //对比图
        canvas.drawBitmap(bitmap,matrix,null);
    }
}
