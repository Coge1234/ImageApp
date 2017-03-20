package com.example.imageapp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.example.imageapp.R;

/**
 * Created by Administrator on 2017/2/24.
 */

public class BitmapSharderView extends View {

    private Bitmap bitmap;
    private Paint paint;
    private BitmapShader bitmapShader;

    public BitmapSharderView(Context context) {
        super(context);
    }

    public BitmapSharderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BitmapSharderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic05);
        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(bitmapShader);
        canvas.drawCircle(100,100,100,paint);
    }
}
