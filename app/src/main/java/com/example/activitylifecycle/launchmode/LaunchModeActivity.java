package com.example.activitylifecycle.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.activitylifecycle.R;

/*
 * adb shell dumpsys activity activities命令，打印出来的顺序，就是Activity在back stack中的顺序
 *
 */

public abstract class LaunchModeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);

        mTitle = (TextView) findViewById(R.id.title);
        findViewById(R.id.standard).setOnClickListener(this);
        findViewById(R.id.singleTop).setOnClickListener(this);
        findViewById(R.id.singleTask).setOnClickListener(this);
        findViewById(R.id.singleInstance).setOnClickListener(this);

        mTitle.setText(getTitleString());
    }

    protected abstract String getTitleString();

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        Class clazz = null;

        switch (v.getId()) {
            case R.id.standard:
                clazz = StandardActivity.class;
                break;
            case R.id.singleTop:
                clazz = SingleTopActivity.class;
                break;
            case R.id.singleTask:
                clazz = SingleTaskActivity.class;
                break;
            case R.id.singleInstance:
                clazz = SingleInstanceActivity.class;
                break;
        }
        intent.setClass(this, clazz);
        startActivity(intent);
    }
}
