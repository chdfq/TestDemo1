package com.marten.testdemo.demo.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marten.testdemo.R;

public class RegisterActivity extends BaseActivity {

    private EditText mEtAccount, mEtPassword, mEtAgainPassword;
    private Button mBtnRegister;

    @Override
    public void initView() {
        contentView(R.layout.m_activity_register);
        setMyTitle(getResources().getString(R.string.register));

        mBtnRegister = findViewById(R.id.btn_register);
        mEtAccount = findViewById(R.id.et_account);
        mEtPassword = findViewById(R.id.et_password);
        mEtAgainPassword = findViewById(R.id.et_again_password);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
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
                String password3 = mEtAgainPassword.getText().toString().trim();
                if (password3.isEmpty()) {
                    Toast.makeText(context, R.string.input_password_again, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password2.equals(password3)) {
                    Toast.makeText(context, R.string.register_success, Toast.LENGTH_SHORT).show();
                    Intent intent = getIntent();
                    intent.putExtra("account", account2);
                    intent.putExtra("password", password2);
                    setResult(1, intent);
                    finish();
                } else {
                    Toast.makeText(context, R.string.register_not_equal, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
