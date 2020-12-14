package com.marten.testdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.marten.testdemo.ListAdapter;
import com.marten.testdemo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private ListView mLvFirst;
    private ListAdapter listAdapter;
    private SmartRefreshLayout smartRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        mLvFirst = findViewById(R.id.first_list);
        smartRefreshLayout = findViewById(R.id.smart);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                addData(0);
                smartRefreshLayout.finishRefresh();
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                addData(1);
                smartRefreshLayout.finishLoadMore();
            }
        });

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

        mLvFirst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    public void addData(int action) {
        List<String> newData = new ArrayList<>();
        newData.add("星期1");
        newData.add("星期2");
        newData.add("星期3");
        newData.add("星期4");
        newData.add("星期5");
        newData.add("星期6");
        newData.add("星期7");

        if (action == 0) {
            listAdapter = new ListAdapter(SecondActivity.this, newData);
            mLvFirst.setAdapter(listAdapter);
        } else {
            listAdapter.addAllData(newData);
        }


    }
}
