package com.example.imageapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/3/18.
 */

public class TestLeakcanaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testleakcanary);
    }

    public void testOnClickListener(View view) {
        Toast.makeText(this, "点击了按钮喔!", Toast.LENGTH_SHORT).show();
    }
}
