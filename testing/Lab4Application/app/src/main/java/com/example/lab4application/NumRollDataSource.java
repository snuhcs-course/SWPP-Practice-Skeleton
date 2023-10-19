package com.example.lab4application;

import android.content.Context;
import android.content.SharedPreferences;

public class NumRollDataSource {
    private final SharedPreferences sharedPref;
    private final SharedPreferences.Editor editor;
    private final String keyActivity = "DiceRoll";
    private final String keyNumRoll = "NumRoll";
    private final int getDefaultValue = 0;

    public NumRollDataSource(Context context) {
        sharedPref = context.getSharedPreferences(keyActivity, Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public int getNumRoll() {
        return sharedPref.getInt(keyNumRoll, getDefaultValue);
    }
    public void storeNumRoll(int numRoll) {
        editor.putInt(keyNumRoll, numRoll);
        editor.apply();
    }
    public void resetNumRoll() {
        storeNumRoll(0);
    }
}
