package com.example.tempapp;

public class Calculations {

    protected float convertCelciusToFahrenheit(Float value) {
        Float ans = (value * 9 / 5) + 32;
        return ans;  // return the answer
    }

    protected float convertFahrenheitToCelcius(Float value) {
        Float ans = (value - 32) * 5 / 9;
        return ans;
    }
}