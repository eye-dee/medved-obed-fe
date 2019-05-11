package com.igor.medevobed;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.EditText;

import java.util.Arrays;

public class SensorTextViewListener implements SensorEventListener {

    private final EditText view;

    public SensorTextViewListener(EditText view) {
        this.view = view;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        view.setText(Arrays.toString(event.values));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
