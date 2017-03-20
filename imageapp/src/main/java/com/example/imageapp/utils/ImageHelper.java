package com.example.imageapp.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by Administrator on 2017/2/22.
 */
/*
* 1.实现静态方法
* 2.创建Bitmap对象
* 3.创建画笔对象
* 4.调整图像效果
* 5.返回图像
* */
public class ImageHelper {
    //图像，色相，饱和度，亮度  ARGB_888832位ARGB位图
    public static Bitmap handleImageEffect(Bitmap bm, float hue, float saturation, float lum) {
        Bitmap bitmap = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.setRotate(0, hue);
        hueMatrix.setRotate(1, hue);
        hueMatrix.setRotate(2, hue);

        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum, lum, lum, 1);

        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
        //绘制画布
        canvas.drawBitmap(bm, 0, 0, paint);
        return bitmap;
    }

    public static Bitmap handleImageNegative(Bitmap bm) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        int color;
        int r, g, b, a;
        Bitmap bmp = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        int[] oldPx = new int[width * height];
        //存储像素点的数组，起点数组像素点的偏移量，控制多少个像素为一行，第一次读取的xy坐标，从bitmap读取的长度高度
        //保存像素点数组到图像
        bm.getPixels(oldPx, 0, width, 0, 0, width, height);
        int[] newPx = new int[width * height];
        for (int i = 0; i < width * height; i++) {
            color = oldPx[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r = 255 - r;
            g = 255 - g;
            b = 255 - b;

            if (r > 255) {
                r = 255;
            } else if (r < 0) {
                r = 0;
            }
            if (g > 255) {
                g = 255;
            } else if (g < 0) {
                g = 0;
            }
            if (b > 255) {
                b = 255;
            } else if (b < 0) {
                b = 0;
            }
            newPx[i] = Color.argb(a, r, g, b);
        }
        bmp.setPixels(newPx, 0, width, 0, 0, width, height);
        return bmp;
    }

    public static Bitmap handleImagePixelsOldPhoto(Bitmap bm) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        int color;
        int r, g, b, a, r1, g1, b1;

        Bitmap bmp = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);

        int[] oldPx = new int[width * height];
        int[] newPx = new int[width * height];

        //存储像素点的数组，起点数组像素点的偏移量，控制多少个像素为一行，第一次读取的xy坐标，从bitmap读取的长度高度
        //保存像素点数组到图像
        bm.getPixels(oldPx, 0, width, 0, 0, width, height);

        for (int i = 0; i < width * height; i++) {
            color = oldPx[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r1 = (int) (0.393 * r + 0.769 * g + 0.189 * b);
            g1 = (int) (0.349 * r + 0.686 * g + 0.168 * b);
            b1 = (int) (0.272 * r + 0.534 * g + 0.131 * b);

            if (r1 > 255) {
                r1 = 255;
            } else if (r1 < 0) {
                r1 = 0;
            }
            if (g1 > 255) {
                g1 = 255;
            } else if (g1 < 0) {
                g1 = 0;
            }
            if (b1 > 255) {
                b1 = 255;
            } else if (b1 < 0) {
                b1 = 0;
            }
            newPx[i] = Color.argb(a, r1, g1, b1);
        }
        bmp.setPixels(newPx, 0, width, 0, 0, width, height);
        return bmp;
    }

    public static Bitmap handleImagePixelsRelief(Bitmap bm) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        int color, colorbefore;
        int r, g, b, a, r1, g1, b1;

        Bitmap bmp = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);

        int[] oldPx = new int[width * height];
        int[] newPx = new int[width * height];

        //存储像素点的数组，起点数组像素点的偏移量，控制多少个像素为一行，第一次读取的xy坐标，从bitmap读取的长度高度
        //保存像素点数组到图像
        bm.getPixels(oldPx, 0, width, 0, 0, width, height);

        for (int i = 1; i < width * height; i++) {
            colorbefore = oldPx[i - 1];
            r = Color.red(colorbefore);
            g = Color.green(colorbefore);
            b = Color.blue(colorbefore);
            a = Color.alpha(colorbefore);

            color = oldPx[i];
            r1 = Color.red(color);
            g1 = Color.green(color);
            b1 = Color.blue(color);

            r = r - r1 + 127;
            g = g - g1 + 127;
            b = b - b1 + 127;
            if (r1 > 255) {
                r1 = 255;
            } else if (r1 < 0) {
                r1 = 0;
            }
            if (g1 > 255) {
                g1 = 255;
            } else if (g1 < 0) {
                g1 = 0;
            }
            if (b1 > 255) {
                b1 = 255;
            } else if (b1 < 0) {
                b1 = 0;
            }
            newPx[i] = Color.argb(a, r, g, b);
        }
        bmp.setPixels(newPx, 0, width, 0, 0, width, height);
        return bmp;
    }
}
