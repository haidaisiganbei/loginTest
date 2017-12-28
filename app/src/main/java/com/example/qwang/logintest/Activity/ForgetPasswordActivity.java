package com.example.qwang.logintest.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.qwang.logintest.R;

/**
 * Created by QWang on 2017/12/27.
 */


public class ForgetPasswordActivity extends AppCompatActivity {
    private EditText mEmail;
    private Button mSentEmail;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        mEmail = findViewById(R.id.forget_password_et_email);
        mSentEmail = findViewById(R.id.btn_forget_password);

        mSentEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAdress = mEmail.getText().toString();
                
            }
        });

    }
}
