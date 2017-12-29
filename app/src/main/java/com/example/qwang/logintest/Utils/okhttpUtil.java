package com.example.qwang.logintest.Utils;

import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;

import cn.bmob.v3.Bmob;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static cn.bmob.v3.Bmob.getApplicationContext;

/**
 * Created by QWang on 2017/12/28.
 */

public class okhttpUtil {

    public void getAsynHttp(String url) {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Handler handler = new Handler();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);

        call.enqueue(new Callback() {
            String text = null;
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (null != response.cacheResponse()) {
                    String str = response.cacheResponse().toString();
                    Log.d("okhttpUtil", "cache---" + str);
                } else {
//                    response.body().string();
                    String str = response.networkResponse().toString();
                    text = response.body().string();
                    Log.d("okhttpUtil", "network---" + str+"\n"+text);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                }
            }


        });
    }
}
