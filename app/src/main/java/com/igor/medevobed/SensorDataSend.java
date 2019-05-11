package com.igor.medevobed;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

public class SensorDataSend implements SensorEventListener {

    private static final Gson GSON = new Gson();
    private final RequestQueue queue;

    SensorDataSend(RequestQueue queue) {
        this.queue = queue;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String url ="https://medved-obed.herokuapp.com/metrics";

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, url,
                GSON.toJson(new MetricsRequestBody(event.sensor.getName(), event.values[0])),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });

        queue.add(objectRequest);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
