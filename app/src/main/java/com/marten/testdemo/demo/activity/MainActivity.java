package com.marten.testdemo.demo.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marten.testdemo.R;
import com.marten.testdemo.demo.adapter.FirstRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView mRvMain;
    private FirstRecyclerViewAdapter adapter;

    @Override
    public void initView() {
        contentView(R.layout.m_activity_main_page);
        mRvMain = findViewById(R.id.rv_main);

        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王麻子");

        mRvMain.setLayoutManager(new LinearLayoutManager(context));
        adapter = new FirstRecyclerViewAdapter(this,list);
        mRvMain.setAdapter(adapter);
    }
}
