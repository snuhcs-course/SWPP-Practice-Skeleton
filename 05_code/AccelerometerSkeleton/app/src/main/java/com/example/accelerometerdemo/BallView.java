package com.example.accelerometerdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class BallView extends View {
    private float x;
    private float y;
    private final int radius;
    private float dirX = 0; // The x acceleration
    private float dirY = 0; // The y acceleration
    private float velocityX = 0;  // The ball's x velocity
    private float velocityY = 0;  // The ball's y velocity
    float damping = 0.65f;
    float accelerationFactor = 20;
    long targetTime = System.currentTimeMillis();
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public BallView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.YELLOW);
        radius = 20;  // radius of the ball
        x = radius + 1;
        y = radius + 1;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawVector(canvas);

        int width = getWidth();
        int height = getHeight();

        if (targetTime - System.currentTimeMillis() > 0) {
            x += velocityX * (targetTime - System.currentTimeMillis()) / 1000f;
            y += velocityY * (targetTime - System.currentTimeMillis()) / 1000f;
        }

        // Check horizontal boundaries
        if (x - radius < 0) {
            x = radius;
            velocityX = -velocityX * damping;
        } else if (x + radius > width) {
            x = width - radius;
            velocityX = -velocityX * damping;
        }

        // Check vertical boundaries
        if (y - radius < 0) {
            y = radius;
            velocityY = -velocityY * damping;
        } else if (y + radius > height) {
            y = height - radius;
            velocityY = -velocityY * damping;
        }

        // Draw the ball and invalidate the view to continue updating
        canvas.drawCircle(x, y, radius, paint);
        invalidate();
    }

    private void drawVector(Canvas canvas) {
        // Center of the screen
        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;

        // Calculate end points for the acceleration arrow
        float arrowEndX = centerX + dirX * 2.5f;
        float arrowEndY = centerY + dirY * 2.5f;

        // Drawing the arrow for acceleration
        Paint arrowPaint = new Paint();
        arrowPaint.setColor(Color.RED);
        arrowPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        float arrowWidth = 45;
        arrowPaint.setStrokeWidth(arrowWidth);
        canvas.drawLine(centerX, centerY, arrowEndX, arrowEndY, arrowPaint);

        // Draw the arrowhead
        float angle = (float) Math.atan2(arrowEndY - centerY, arrowEndX - centerX);

        Path path = new Path();
        path.moveTo(arrowEndX, arrowEndY);
        path.lineTo(arrowEndX - arrowWidth * (float) Math.cos(angle - Math.PI / 6),
                arrowEndY - arrowWidth * (float) Math.sin(angle - Math.PI / 6));
        path.lineTo(arrowEndX - arrowWidth * (float) Math.cos(angle + Math.PI / 6),
                arrowEndY - arrowWidth * (float) Math.sin(angle + Math.PI / 6));
        path.close();

        canvas.drawPath(path, arrowPaint);
    }

    // This method is to be called when accelerometer readings change
    public void updateBall(float ax, float ay, long deltaTime) {
        /** TODO
         * Update dirX and dirY which are the acceleration values multiplied with accelerationFactor
         * Update velocityX and velocityY which are computed with dirX and dirY */
        targetTime = System.currentTimeMillis() + deltaTime;
        invalidate();
    }
}