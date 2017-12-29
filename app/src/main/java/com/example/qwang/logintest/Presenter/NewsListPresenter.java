package com.example.qwang.logintest.Presenter;

import android.os.Handler;

import com.example.qwang.logintest.Biz.GetNewsListImp;
import com.example.qwang.logintest.Biz.IGetNewsList;
import com.example.qwang.logintest.Biz.IGetNewsListListener;
import com.example.qwang.logintest.Fragment.IGetNewsListView;
import com.example.qwang.logintest.Model.NewsResponse;

import java.util.List;

/**
 * Created by QWang on 2017/12/29.
 */

public class NewsListPresenter {
    private IGetNewsList getNewsList;
    private IGetNewsListView getNewsListView;
    private Handler mHandle = new Handler();
    private String category;
    public NewsListPresenter(IGetNewsListView getNewsListView, String category) {
        this.getNewsListView = getNewsListView;
        this.getNewsList = new GetNewsListImp();
        this.category = category;
    }

    public void getNewsList(){
        mHandle.post(new Runnable() {
            @Override
            public void run() {
                getNewsList.getNewsList(new IGetNewsListListener() {
                    @Override
                    public void getNewsListSuccess(List<NewsResponse.ResultEntity.ListEntity> newslist) {
                        getNewsListView.getNewsListViewSuccess(newslist);
                    }

                    @Override
                    public void getNewsListFail() {

                    }
                }, category);
            }
        });
    }
}
