package com.example.accelerometerdemo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private BallView ballView;
    private long lastUpdateTime;
    private SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ballView = findViewById(R.id.ballView);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                long currentTime = System.currentTimeMillis();
                long deltaTime = currentTime - lastUpdateTime;
                lastUpdateTime = currentTime;

                /** TODO
                 * Fill in ax and ay with proper values from sensor event */
                ballView.updateBall(ax, ay, deltaTime);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                // Not used
            }
        };

        lastUpdateTime = System.currentTimeMillis();
    }

    @Override
    protected void onResume() {
        super.onResume();
        /** TODO: register listener */
    }

    @Override
    protected void onPause() {
        super.onPause();
        /** TODO: unregister listener */
    }
}
