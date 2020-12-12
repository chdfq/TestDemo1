package com.marten.testdemo.activity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.marten.testdemo.R;

public class SecondActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        button = this.findViewById(R.id.button_1);
        imageView = this.findViewById(R.id.img_1);

        Intent intent = getIntent();
        String str = intent.getStringExtra("text");

        button.setText(str);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent1 = new Intent(Intent.ACTION_VIEW); //android.intent.action.VIEW 浏览器
//                intent1.setData(Uri.parse("https://www.baidu.com")); //必须设定网址
//                startActivity(intent1);

//                //明天会更好
//                Intent intent1 = new Intent();
//                intent1.putExtra("str","明天会更好");
//                setResult(2020, intent1);
//                finish();

                Intent intent1 = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent1);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(SecondActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                Intent intent2 = new Intent(Intent.ACTION_CALL); //ACTION_DIAL拨号界面 ACTION_CALL直接拨打（需要manifest权限 和 动态申请）
                intent2.setData(Uri.parse("tel:13270332023"));
                startActivity(intent2);
            }
        });
    }
}
