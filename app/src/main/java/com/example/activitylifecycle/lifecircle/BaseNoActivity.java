package com.example.activitylifecycle.lifecircle;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by BigFaceBear on 2018.02.05
 */

public abstract class BaseNoActivity extends AppCompatActivity {
    final String TAG = "bear";

    protected abstract int getActivityNo();

    protected abstract int getResId();

    protected void initView() {
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "onAttachedToWindow: ");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(TAG, "onDetachedFromWindow: ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, getActivityNo() + " onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(getResId());
        initView();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, getActivityNo() + " onStart()");

        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, getActivityNo() + " onReStart()");

        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, getActivityNo() + " onResume()");

        super.onResume();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, getActivityNo() + " onRestoreInstanceState()");

        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onPause() {
        Log.i(TAG, getActivityNo() + " onPause()");

        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, getActivityNo() + " onSaveInstanceState(Bundle outState)");

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.i(TAG, getActivityNo() + " onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)");

        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onStop() {
        Log.i(TAG, getActivityNo() + " onStop()");

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, getActivityNo() + " onDestroy()");

        super.onDestroy();
    }
}
