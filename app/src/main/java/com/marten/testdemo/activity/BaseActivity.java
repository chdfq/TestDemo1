package com.marten.testdemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.marten.testdemo.R;

import static com.marten.testdemo.R.id;
import static com.marten.testdemo.R.layout;
import static com.marten.testdemo.R.string;

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {

    private LinearLayout llbase;
    private TextView mTvTitle, mTvMessage;
    private ImageView mIvBack, mIvQR;
    private View view;
    private Context context;
    private String title;


    public void setTitle(String title) {
        this.title = title;
        if (title != null) {
            mTvTitle.setText(title);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.base_activity_page);
        context = BaseActivity.this;
        llbase = findViewById(id.ll_base);
        mTvTitle = findViewById(id.title);
        mTvMessage = findViewById(id.message);
        mIvBack = findViewById(id.back_img);
        mIvQR = findViewById(id.qr_image);
        initView();
        mIvQR.setOnClickListener(this);
        mIvBack.setOnClickListener(this);
        mTvMessage.setOnClickListener(this);
    }

    protected void contentView(int layoutId) {
        view = getLayoutInflater().inflate(layoutId, null);
        if (view != null) {
            llbase.addView(view);
        }
    }

    public abstract void initView();

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qr_image:
                Toast.makeText(context, string.bit_qr, Toast.LENGTH_SHORT).show();
                break;
            case R.id.back_img:
                Toast.makeText(context, string.bit_back, Toast.LENGTH_SHORT).show();
                break;
            case R.id.message:
                Toast.makeText(context, string.bit_message, Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(context, string.error_message, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
