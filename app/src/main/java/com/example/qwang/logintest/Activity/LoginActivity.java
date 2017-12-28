package com.example.qwang.logintest.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

import static com.example.qwang.logintest.config.appid;

/**
 * 登陆界面
 */
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "login";
    private EditText mLoginEtPhone;
    private EditText mLoginEtPassword;
    private Button mLoginTvLogin;
    private TextView mLoginTvRegister;
    private TextView mForgetPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bmob.initialize(this, appid);
        initView();
        listener();
    }

    private void listener() {
//        登陆
        mLoginTvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String account = mLoginEtPhone.getText().toString();
                final String password = mLoginEtPassword.getText().toString();
                Log.d(TAG, "onClick: " + account + ":" + password);
                if (TextUtils.isEmpty(mLoginEtPhone.getText().toString())){
                    Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mLoginEtPassword.getText().toString())){
                    Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                BmobUser bmobUser = new BmobUser();
                bmobUser.setUsername(account);
                bmobUser.setPassword(MD5Utils.encode(password));
                bmobUser.login(LoginActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        User user = BmobUser.getCurrentUser(LoginActivity.this,User.class);
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        intent.putExtra("user",user);
                        startActivity(intent);
                        //登录成功
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onFailure: "+s);
                    }
                });
//                if (!TextUtils.isEmpty(account)&&!TextUtils.isEmpty(password)){
//                    final BmobUser bmobUser = new BmobUser();
//                    bmobUser.setUsername(account);
////                    登陆密码使用MD5加密之后与注册加密后一样
//                    bmobUser.setPassword(MD5Utils.encode(password));
//                    bmobUser.login(LoginActivity.this, new SaveListener() {
//                        @Override
//                        public void onSuccess() {
//                            Log.d(TAG, "进入: " + account + ":" + password);
//                            User user = BmobUser.getCurrentUser(LoginActivity.this,User.class);
//                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                            intent.putExtra("user",user);
//                            startActivity(intent);
//                            //登录成功
//                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
//                            finish();
//                        }
//
//                        @Override
//                        public void onFailure(int i, String s) {
//                            Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
//                            Log.d(TAG, "onFailure: "+s);
//                        }
//                    });
//                }


            }
        });

//        注册按钮
        mLoginTvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

            }
        });
//        忘记密码
        mForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
            }
        });
    }

    private void initView() {
        mLoginEtPhone = findViewById(R.id.register_et_phone);
        mLoginEtPassword = findViewById(R.id.register_et_password);
        mLoginTvLogin = findViewById(R.id.login_tv_login);
        mLoginTvRegister = findViewById(R.id.login_tv_register);
        mForgetPassword = findViewById(R.id.login_tv_forget_password);
    }


}
