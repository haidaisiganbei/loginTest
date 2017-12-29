package com.example.qwang.logintest.Biz;

import com.example.qwang.logintest.Model.NewsResponse;

import java.util.List;

/**
 * Created by QWang on 2017/12/29.
 */

public interface IGetNewsListListener {
    void getNewsListSuccess(List<NewsResponse.ResultEntity.ListEntity> newslist);
    void getNewsListFail();
}
