package com.example.qwang.logintest.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.qwang.logintest.R;
import com.example.qwang.logintest.User;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity {
    private  Button btn_setting;
    private TextView tv_username;
    private Intent intent;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (User) getIntent().getSerializableExtra("user");
        initView();
        listener();
    }

    private void listener() {
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SettingActivity.class));

            }
        });
    }

    private void initView() {
        btn_setting = findViewById(R.id.btn_setting);
        tv_username = findViewById(R.id.tv_username);
        tv_username.setText("用户名："+user.getUsername());
    }
}
