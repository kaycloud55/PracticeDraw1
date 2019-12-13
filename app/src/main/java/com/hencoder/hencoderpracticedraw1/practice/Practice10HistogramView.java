package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Data;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

    private List<Data> datas = new ArrayList<>();
    private Paint mPaint;
    private float max;

    private float itemWidth;
    private float space;

    public Practice10HistogramView(Context context) {
        this(context, null);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs,
                                   int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setStrokeWidth(2);
        generateData();
    }

    private void generateData() {
        Data data = new Data("Froyo", 10.0f, Color.GREEN);
        datas.add(data);
        data = new Data("ICS", 18.0f, Color.GREEN);
        datas.add(data);
        data = new Data("JB", 22.0f, Color.GREEN);
        datas.add(data);
        data = new Data("KK", 27.0f, Color.GREEN);
        datas.add(data);
        data = new Data("L", 40.0f, Color.GREEN);
        datas.add(data);
        data = new Data("M", 60.0f, Color.GREEN);
        datas.add(data);
        data = new Data("N", 33.5f, Color.GREEN);
        datas.add(data);
        max = Float.MIN_VALUE;
        for (Data data1 : datas) {
            max = Math.max(max, data1.getNumber());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        //绘制标题
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(72);
        canvas.drawText("直方图", getWidth() / 2 - mPaint.measureText("直方图") / 2,
                getHeight() * 0.9f, mPaint);
        //移动原点到坐标轴原点
        canvas.translate(getWidth() * 0.1f, getWidth() * 0.7f);
        //绘制坐标轴
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(0, 0, getWidth() * 0.8f, 0, mPaint);   // 画x轴
        canvas.drawLine(0, 0, 0, -getHeight() * 0.6f, mPaint); // 画y轴

        //计算item宽度
        itemWidth = ((getWidth() * (0.8f - 0.1f)) / datas.size()) * 0.8f;
        space = ((getWidth() * (0.8f - 0.1f)) / datas.size()) * 0.2f;
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(36);
        for (int i = 0; i < datas.size(); i++) {
            mPaint.setColor(datas.get(i).getColor());
            float textWidth = mPaint.measureText(datas.get(i).getName());
            canvas.drawText(datas.get(i).getName(),
                    (space + (itemWidth + space) * i + itemWidth / 2) - textWidth / 2, 40,
                    mPaint);
            canvas.drawRect(space + (itemWidth + space) * i,
                    -(datas.get(i).getNumber() / max * getHeight() * 0.6f),
                    space + (itemWidth + space) * i + itemWidth,
                    0, mPaint);
        }
    }
}
