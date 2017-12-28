package com.example.qwang.logintest.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qwang.logintest.R;
import com.example.qwang.logintest.User;
import com.example.qwang.logintest.Utils.MD5Utils;

import cn.bmob.v3.listener.SaveListener;

/**
 * 注册界面
 */
public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "注册";
    private EditText register_et_phone;
    private EditText register_et_password;
    private Button register_tv;
    private TextView login_iv_back;
    private String MD5password = null;
//    private String password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        listener();

    }

    private void listener() {
        register_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerData();
            }
        });

    }

    private void registerData() {
        String userName = register_et_phone.getText().toString();
        String password = register_et_password.getText().toString();
        if (TextUtils.isEmpty(register_et_phone.getText().toString())) {
            Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(register_et_password.getText().toString())) {
            Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        //        使用MD5加密再传输给Bmob后端
        MD5password = MD5Utils.encode(password);

        User user = new User();
        user.setUsername(userName);
        user.setEmail(userName);
        user.setPassword(MD5password);
        user.signUp(RegisterActivity.this, new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure: " + i + ":" + s);
            }
        });
    }

    private void initView() {
        register_et_phone = findViewById(R.id.register_et_phone);
        register_et_password = findViewById(R.id.register_et_password);
        register_tv = findViewById(R.id.register_tv);
    }
}
