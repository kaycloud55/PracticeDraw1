package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

public class Practice2DrawCircleView extends View {

    private Context mContext;
    private Paint mPaint;

    public Practice2DrawCircleView(Context context) {
        super(context);
        mContext = context;
        mPaint = new Paint();

    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mPaint = new Paint();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs,
                                   int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(100f, 100f, 100f, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(500f, 100f, 100f, mPaint);

        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(100f, 400f, 100f, mPaint);

        mPaint.setStrokeWidth(20f);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(400f, 400f, 100f, mPaint);
    }
}
