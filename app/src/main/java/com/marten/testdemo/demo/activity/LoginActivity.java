package com.marten.testdemo.demo.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.marten.testdemo.R;

public class LoginActivity extends BaseActivity {

    private EditText mEtAccount, mEtPassword;
    private Button mBtnLogin;
    private String account = "marten";
    private String password = "123456";

    @Override
    public void initView() {
        contentView(R.layout.m_activity_login_page);
        setMyTitle(getResources().getString(R.string.login));
        setRightText1(getString(R.string.register), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        mBtnLogin = findViewById(R.id.btn_login);
        mEtAccount = findViewById(R.id.et_account);
        mEtPassword = findViewById(R.id.et_password);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account2 = mEtAccount.getText().toString().trim();
                if (account2.isEmpty()) {
                    Toast.makeText(context, R.string.input_account, Toast.LENGTH_SHORT).show();
                    return;
                }
                String password2 = mEtPassword.getText().toString().trim();
                if (password2.isEmpty()) {
                    Toast.makeText(context, R.string.input_password, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (account.equals(account2) && password.equals(password2)) {
                    Toast.makeText(context, R.string.login_success, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(context, R.string.login_fail, Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1 && data != null) {
            account = data.getStringExtra("account");
            password = data.getStringExtra("password");

            mEtAccount.setText(account);
            mEtPassword.setText(password);
        }
    }
}
