package com.example.touchcircleexample;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView

extends View {
	private static final float radius = 10;
	private Paint paint = new Paint();
	private float xPos;
	private float yPos;

	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);

		paint.setAntiAlias(true);
		paint.setStrokeWidth(6f);
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeJoin(Paint.Join.ROUND);

	}

	@Override
	protected void onDraw(Canvas canvas) {

		canvas.drawCircle(xPos, yPos, radius, paint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			xPos = event.getX();
			yPos = event.getY();
			return true;
		case MotionEvent.ACTION_MOVE:
			break;
		case MotionEvent.ACTION_UP:
			// nothing to do
			break;
		default:
			return false;
		}

		// Schedules a repaint.
		invalidate();
		return true;
	}
}
