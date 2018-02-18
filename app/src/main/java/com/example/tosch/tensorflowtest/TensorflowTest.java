package com.example.tosch.tensorflowtest;

import android.content.Context;
import android.content.res.AssetManager;
import org.tensorflow.contrib.android.TensorFlowInferenceInterface;

/**
 * Created by tosch on 10.02.2018.
 */

public class TensorflowTest {

    static {
        System.loadLibrary("tensorflow_inference");
    }

    private static TensorflowTest activityInferenceInstance;
    private TensorFlowInferenceInterface inferenceInterface;
    private static final String MODEL_FILE = "file:///android_asset/model_with_pca_256_1.17.pb";
    private static final String INPUT_NODE = "flatten_22_input";
    private static final String[] OUTPUT_NODES = {"output_node0"};
    private static final String OUTPUT_NODE = "output_node0";
    private static final long[] INPUT_SIZE = {1,4608};
    private static final int OUTPUT_SIZE = 21;
    private static AssetManager assetManager;

    public static TensorflowTest getInstance(final Context context)
    {
        if (activityInferenceInstance == null)
        {
            activityInferenceInstance = new TensorflowTest(context);
        }
        return activityInferenceInstance;
    }

    public TensorflowTest(final Context context) {
        this.assetManager = context.getAssets();
        inferenceInterface = new TensorFlowInferenceInterface(assetManager, MODEL_FILE);
    }

    public float[] feed(float[] input_signal)
    {
        float[] result = new float[OUTPUT_SIZE];
        inferenceInterface.feed(INPUT_NODE,input_signal,INPUT_SIZE);
        inferenceInterface.run(OUTPUT_NODES);
        inferenceInterface.fetch(OUTPUT_NODE,result);
        //Downstairs	Jogging	  Sitting	Standing	Upstairs	Walking
        return result;
    }
}
