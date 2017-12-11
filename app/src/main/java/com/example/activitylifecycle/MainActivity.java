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
 *
 * 1.需求介绍
 *  公司项目的某个业务，需要在整个业务操作流程中保存一些数据，我们采用了单例模式来保存这些数据，然后在
 *  整个业务流程中随时取用。正常操作的情况下是没有问题的，但是在bugly异常上报中，出现了很多在后台拉起App
 *  时，出现空指针Crash的问题。经检查，发现是App被异常杀死后，重新创建App时单例对象中的数据为空导致的。
 * 1.什么是Activity的状态恢复？
 *  Activity提供了相应的保存状态和恢复状态的回调方法。保存状态使用的是onSaveInstanceState(Bundle)，同时
 *  还提供了另一个方法onSaveInstanceState(Bundle,PersistableBundle)。恢复状态使用的是onCreate(Bundle)
 *  、onRestoreInstanceState(Bundle)以及onRestoreInstanceState(Bundle,PersistableBundle)。
 *      通过上述方法，在Activity销毁时保存状态，在需要重建时恢复状态，从而保证全局数据的恢复。
 * 2.怎么实现状态恢复？
 *  1) 方法简介
 *  2）方法生命周期
 *  3）保存和重置状态
 * 3.为什么要使用这种方式？
 * 4.这种方式有什么好处，又有什么局限？
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
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
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
