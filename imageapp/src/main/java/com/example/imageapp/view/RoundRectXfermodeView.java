package com.example.imageapp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.example.imageapp.R;

/**
 * Created by Administrator on 2017/2/24.
 */

public class RoundRectXfermodeView extends View {

    private Bitmap bitmap, bmpout;
    private Paint paint;

    public RoundRectXfermodeView(Context context) {
        super(context);
        initview();
    }

    public RoundRectXfermodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initview();
    }

    public RoundRectXfermodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initview();
    }

    private void initview() {
        //关闭硬件加速,因为xfermode不支持硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic04);
        bmpout = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),
                Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bmpout);
        //抗锯齿
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //Dst  遮罩层
        canvas.drawRoundRect(0, 0, bitmap.getWidth(), bitmap.getHeight(),
                20, 20, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //Src
        canvas.drawBitmap(bitmap, 0, 0, paint);
        paint.setXfermode(null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bmpout, 0, 0, null);

    }
}
