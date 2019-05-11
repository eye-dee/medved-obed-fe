package com.igor.medevobed;

public class MetricsRequestBody {
    private String name;
    private double value;

    public MetricsRequestBody(String name, double value) {
        this.name = name;
        this.value = value;
    }
}
