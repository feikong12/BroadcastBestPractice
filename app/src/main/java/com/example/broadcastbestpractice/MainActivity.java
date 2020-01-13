package com.example.broadcastbestpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.broadcastbestpractice.ActivitiesManager.BaceActivity;

public class MainActivity extends BaceActivity {

    private Button btn_forceOffline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        clickFunction();
    }

    /*初始化控件*/
    private void initView() {
        btn_forceOffline = findViewById(R.id.btn_forceOffline);
    }

    /*点击按钮函数*/
    private void clickFunction() {
        OnClickListenerOfMain onClickListener = new OnClickListenerOfMain();
        btn_forceOffline.setOnClickListener(onClickListener);
    }

    private class OnClickListenerOfMain implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_forceOffline) {
                Intent intent = new Intent("FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        }
    }
}
