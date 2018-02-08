package com.example.activitylifecycle.lifecircle;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.activitylifecycle.R;

/*
 * 项目1：
 *
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

/*
 * 项目2：鉴定onStart()是在界面可见之前被调用，还是界面可见之后被调用？
 *
 * 测试：
 * 1.如果onStart()在界面可见之前被调用，那么应该直接ANR，当前Activity的界面应该是看不到的
 * 2.如果在之后被调用，界面首先会显示在屏幕上，然后ANR。
 *
 * 运行结果：
 * 界面没有展示到屏幕上，并一直卡死在白屏状态。
 *
 * 结论：
 * 在onStart()之后展示。
 *
 */


/*
 * 项目3：鉴定onStop()是在界面变为不可见之前被调用，还是之后被调用？
 *
 * 测试：
 * 1.如果在界面变为不可见之前被调用，则界面会因为while卡死，一直可见。
 * 2.如果在之后被调用，界面首先会从屏幕上消失，然后卡死
 *
 * 运行结果：
 * 界面没有展示到屏幕上，并一直卡死在白屏状态。
 *
 * 结论：
 * 在onStop()之前已经变为不可见。
 *
 */

/*
 * 项目4：
 *
 *
 */

public class No1Activity extends BaseNoActivity {

    private TextView textView;

    @Override
    protected int getActivityNo() {
        return 1;
    }

    @Override
    protected int getResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();

        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //*************************************************************while (true);

        /*
         * 题目：鉴定onStart()是在界面可见之前被调用，还是界面可见之后被调用？
         *
         * 测试：
         * 1.如果onStart()在界面可见之前被调用，那么应该直接ANR，当前Activity的界面应该是看不到的
         * 2.如果在之后被调用，界面首先会显示在屏幕上，然后ANR。
         *
         * 运行结果：
         * 界面没有展示到屏幕上，并一直卡死在白屏状态。
         *
         * 结论：
         * 在onStart()之后展示。
         *
         */

        //while (true);

        //*************************************************************while (true);

    }

    @Override
    protected void onStop() {
        super.onStop();

        //*************************************************************while (true);

        /*
         * 题目：鉴定onStop()是在界面变为不可见之前被调用，还是之后被调用？
         *
         * 测试：
         * 1.如果在界面变为不可见之前被调用，则界面会因为while卡死，一直可见。
         * 2.如果在之后被调用，界面首先会从屏幕上消失，然后卡死
         *
         * 运行结果：
         * 界面没有展示到屏幕上，并一直卡死在白屏状态。
         *
         * 结论：
         * 在onStop()之前已经变为不可见。
         *
         */

        //while (true);

        //*************************************************************while (true);

    }

    public void click(View v) {
        startActivity(new Intent(this, No2Activity.class));
    }
}
