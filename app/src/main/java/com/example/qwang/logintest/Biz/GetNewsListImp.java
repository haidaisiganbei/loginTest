package com.example.qwang.logintest.Biz;

import android.os.Handler;
import android.util.Log;

import com.example.qwang.logintest.Model.NewsResponse;
import com.example.qwang.logintest.Utils.GsonUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.qwang.logintest.config.NEWS_KEY;

/**
 * Created by QWang on 2017/12/29.
 */

public class GetNewsListImp implements IGetNewsList {

    @Override
    public void getNewsList(final IGetNewsListListener getNewsListListener, String category) {
        String url = "http://api.jisuapi.com/news/get?channel="+category+"&start=0&num=10&appkey=" + NEWS_KEY;
        OkHttpClient client = new OkHttpClient();
        final Handler mHandler = new Handler();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
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
                    String text = response.body().string();
                    Log.d("okhttpUtil", "network---" + str+"\n"+text);
                    final NewsResponse newsResponse = GsonUtil.GsonToBean(text,NewsResponse.class);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            getNewsListListener.getNewsListSuccess(newsResponse.getResult().getList());
                        }
                    });
                }
            }
        });
    }
}
