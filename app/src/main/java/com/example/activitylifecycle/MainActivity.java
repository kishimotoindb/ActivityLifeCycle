package com.example.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/*
 * 回调的时机：
 * 1.onRestoreInstanceState()
 * 1)配置改变重建Activity时（比如旋屏）
 * 2)进程被杀重建Activity时（手动在最近使用杀死app，不会发生重建行为）
 *
 * 2.onSaveInstanceState()
 * 1)配置改变
 * 2)在当前Activity开启另一个Activity，此回调在后一个Activity的onResume执行完成后执行
 * 3)锁屏或home键退出app
 * 在onPause()之后，onStop()之前执行
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("xiong", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("xiong", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("xiong", "onResume()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("xiong", "onRestoreInstanceState()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("xiong", "onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("xiong", "onSaveInstanceState(Bundle outState)");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i("xiong", "onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("xiong", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("xiong", "onDestroy()");
    }

    public void click(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
