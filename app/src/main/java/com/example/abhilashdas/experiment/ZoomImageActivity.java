package com.example.abhilashdas.experiment;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class ZoomImageActivity extends AppCompatActivity {

    private ImageView imageView;
    private ScaleGestureDetector scaleGestureDetector;
    private Matrix matrix = new Matrix();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_image);

        imageView = (ImageView)findViewById(R.id.zoom_image);
        scaleGestureDetector = new ScaleGestureDetector(this,new ScaleListener());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        return super.onTouchEvent(event);
        scaleGestureDetector.onTouchEvent(event);
        return true;
    }


    private class ScaleListener extends ScaleGestureDetector.
            SimpleOnScaleGestureListener {
        float factor;
        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            factor = 1.0f;
            return true;
            //return super.onScaleBegin(detector);
        }
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float scaleFactor = detector.getScaleFactor() - 1;
            factor += scaleFactor;
            imageView.setScaleX(factor);
            imageView.setScaleY(factor);
            return true;
            //return super.onScale(detector);
           /* float scaleFactor = detector.getScaleFactor();
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));
            matrix.setScale(scaleFactor, scaleFactor);
            imageView.setImageMatrix(matrix);
            return true;*/
        }
    }

    /*@Override
    public boolean onTouch(View v, MotionEvent event) {
    ImageView view = (ImageView) v;
    dumpEvent(event);

    // Handle touch events here...
    switch (event.getAction() & MotionEvent.ACTION_MASK) {
        case MotionEvent.ACTION_DOWN:
            savedMatrix.set(matrix);
            start.set(event.getX(), event.getY());
            Log.d(TAG, "mode=DRAG");
            mode = DRAG;
            break;
        case MotionEvent.ACTION_POINTER_DOWN:
            oldDist = spacing(event);
            Log.d(TAG, "oldDist=" + oldDist);
            if (oldDist > 10f) {
                savedMatrix.set(matrix);
                midPoint(mid, event);
                mode = ZOOM;
                Log.d(TAG, "mode=ZOOM");
            }
            break;
        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_POINTER_UP:
            mode = NONE;
            Log.d(TAG, "mode=NONE");
            break;
        case MotionEvent.ACTION_MOVE:
            if (mode == DRAG) {
                // ...
                matrix.set(savedMatrix);
                matrix.postTranslate(event.getX() - start.x, event.getY()
                        - start.y);
            } else if (mode == ZOOM) {
                float newDist = spacing(event);
                Log.d(TAG, "newDist=" + newDist);
                if (newDist > 10f) {
                    matrix.set(savedMatrix);
                    float scale = newDist / oldDist;
                    matrix.postScale(scale, scale, mid.x, mid.y);
                }
            }
            break;
    }

    view.setImageMatrix(matrix);
    return true;
}

    private void dumpEvent(MotionEvent event) {
        String names[] = { "DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE",
                "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?" };
        StringBuilder sb = new StringBuilder();
        int action = event.getAction();
        int actionCode = action & MotionEvent.ACTION_MASK;
        sb.append("event ACTION_").append(names[actionCode]);
        if (actionCode == MotionEvent.ACTION_POINTER_DOWN
                || actionCode == MotionEvent.ACTION_POINTER_UP) {
            sb.append("(pid ").append(
                    action >> MotionEvent.ACTION_POINTER_ID_SHIFT);
            sb.append(")");
        }
        sb.append("[");
        for (int i = 0; i < event.getPointerCount(); i++) {
            sb.append("#").append(i);
            sb.append("(pid ").append(event.getPointerId(i));
            sb.append(")=").append((int) event.getX(i));
            sb.append(",").append((int) event.getY(i));
            if (i + 1 < event.getPointerCount())
                sb.append(";");
        }
        sb.append("]");
        Log.d(TAG, sb.toString());
    }

    *//** Determine the space between the first two fingers *//*
    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return FloatMath.sqrt(x * x + y * y);
    }

    *//** Calculate the mid point of the first two fingers *//*
    private void midPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }*/
}
