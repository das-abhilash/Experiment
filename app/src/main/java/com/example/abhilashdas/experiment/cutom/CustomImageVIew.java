package com.example.abhilashdas.experiment.cutom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

/**
 * Created by abhilashdas on 12/05/17.
 */

public class CustomImageVIew extends ImageView {

    private ScaleGestureDetector mScaleDetector;
    private float mScaleFactor = 1.f;

    public CustomImageVIew(Context context) {
        super(context);
        mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    public CustomImageVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    public CustomImageVIew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomImageVIew(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
        }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // Let the ScaleGestureDetector inspect all events.
        mScaleDetector.onTouchEvent(ev);
        return true;
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.scale(mScaleFactor, mScaleFactor);
        canvas.restore();
    }

    private class ScaleListener
            extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            mScaleFactor *= detector.getScaleFactor();

            // Don't let the object get too small or too large.
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f));

            invalidate();
            return true;

        }
    }
}
