package com.marten.testdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.marten.testdemo.R;

public class FirstActivity extends BaseActivity implements View.OnClickListener {

    private TextView textView1;
    private Context context;

    @Override
    public void initView() {
        contentView(R.layout.activity_first_page);
        setTitle(getString(R.string.first_activity));
        context = this;
        textView1 = findViewById(R.id.text1);
        textView1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.text1:
                Intent intent = new Intent(context, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }
}
