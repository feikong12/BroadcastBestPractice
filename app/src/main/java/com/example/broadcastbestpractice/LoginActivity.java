package com.example.broadcastbestpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.broadcastbestpractice.ActivitiesManager.BaceActivity;

public class LoginActivity extends BaceActivity {

    private EditText et_userAccount;
    private EditText et_userPassword;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        clickFunction();
    }

    /*初始化控件*/
    private void initView() {
        et_userAccount = findViewById(R.id.et_userAccount);
        et_userPassword = findViewById(R.id.et_userPassword);
        btn_login = findViewById(R.id.btn_Login);
    }

    /*点击按钮功能*/
    private void clickFunction() {
        MyOnClickListener myOnClickListener = new MyOnClickListener();
        btn_login.setOnClickListener(myOnClickListener);
    }

    private class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_Login) {
                String userAccount = et_userAccount.getText().toString();
                String userPassword = et_userPassword.getText().toString();
                //如果账号是admin，密码是123456，则成功登录
                if (userAccount.equals("admin") && userPassword.equals("123456")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "账号或密码错误，请重新登陆！", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(LoginActivity.this, "无效按钮！", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
