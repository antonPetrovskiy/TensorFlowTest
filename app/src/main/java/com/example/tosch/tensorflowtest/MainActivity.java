package com.example.tosch.tensorflowtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TensorflowTest activityInference;
    private static float [] input_signal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityInference = new TensorflowTest(getApplicationContext());

        randomArray();
        test();
    }

    public void test(){
        // Perform inference using Tensorflow
        float[] results = activityInference.feed(input_signal);
        for(int i = 0; i < 21; i++){
            String ss = String.valueOf(results[i]);
            String s = String.valueOf(results[i]);
            Log.i("a", ss);
        }
    }

    public void randomArray(){
        Random r = new Random();
        input_signal = new float[4608];
        for(int i = 0; i < 4608; i++){
            input_signal[i] = 0;
        }
        for(int i = 0; i < 21; i++){
            Log.i("b", String.valueOf(input_signal[i]));
        }
    }

    public void out(){
        for(int i = 0; i < 21; i++){
            String s = String.valueOf(input_signal[i]);
            Log.i("a", s);
        }
    }
}
