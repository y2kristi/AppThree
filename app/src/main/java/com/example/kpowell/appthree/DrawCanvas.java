package com.example.kpowell.appthree;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kpowell on 3/22/15.
 */
public class DrawCanvas extends View {

    public DrawCanvas(Context context) {

        super(context );

        paint.setAntiAlias(true);
        paint.setStrokeWidth(10f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);

    }

    private Paint paint = new Paint();
    private Path path = new Path();


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // Get the coordinates of the touch event.
        float actionX = event.getX();
        float actionY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Set a new starting point
                path.moveTo(actionX, actionY);
                return true;
            case MotionEvent.ACTION_MOVE:
                // Connect the points
                path.lineTo(actionX, actionY);
                break;
            default:
                return false;
        }

        // Makes our view repaint and call onDraw
        invalidate();
        return true;
    }



}

