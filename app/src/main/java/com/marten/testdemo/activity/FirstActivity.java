package com.marten.testdemo.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.marten.testdemo.MainActivity;
import com.marten.testdemo.R;

public class FirstActivity extends AppCompatActivity {

    TextView textView1, textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("my", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, DialogActivity.class);
                //intent.putExtra("text", "今天很开心");
                startActivity(intent);

//                AlertDialog.Builder builder = new AlertDialog.Builder(FirstActivity.this);
//                builder.setTitle("提示");
//                builder.show();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.SecondActivity");
                //intent.setAction("android.intent.action.SecondActivity");
                intent.putExtra("text", "今天很开心,明天也很开心");
                //startActivity(intent);
                startActivityForResult(intent, 2020);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("my", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("my", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("my", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("my", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("my", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("my", "onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2020 && resultCode == 2020) {
            if (data != null) {
                String str = data.getStringExtra("str");
                textView2.setText(str);
            } else {

            }
        }
    }
}
