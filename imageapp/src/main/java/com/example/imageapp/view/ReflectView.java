package com.example.imageapp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.example.imageapp.R;

/**
 * Created by Administrator on 2017/2/24.
 */

public class ReflectView extends View {

    private Bitmap srcBitmap, refBitmap;
    private Paint paint;

    public ReflectView(Context context) {
        super(context);
        initView();
    }

    public ReflectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ReflectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic05);
        Matrix matrix = new Matrix();
        //以x轴为对称轴
        matrix.setScale(1,-1);
        refBitmap = Bitmap.createBitmap(
                srcBitmap,0,0,
                srcBitmap.getWidth(),srcBitmap.getHeight(),
                matrix,true);
        paint = new Paint();
        paint.setShader(new LinearGradient(
                0, srcBitmap.getHeight(),
                0,srcBitmap.getHeight()*1.4f,
                0xDD000000,0x10000000,
                Shader.TileMode.CLAMP));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(srcBitmap,0,0,null);
        canvas.drawBitmap(refBitmap,0,srcBitmap.getHeight(),null);
        canvas.drawRect(0, refBitmap.getHeight(), refBitmap.getWidth(),
                refBitmap.getHeight() * 2, paint);
    }
}
