package com.marten.testdemo.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.marten.testdemo.ListAdapter;
import com.marten.testdemo.R;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private ListView mLvFirst;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        mLvFirst = findViewById(R.id.first_list);

        List<String> data = new ArrayList<>();
        data.add("星期一");
        data.add("星期二");
        data.add("星期三");
        data.add("星期四");
        data.add("星期五");
        data.add("星期六");
        data.add("星期日");

        listAdapter = new ListAdapter(SecondActivity.this, data);
        mLvFirst.setAdapter(listAdapter);


    }
}
