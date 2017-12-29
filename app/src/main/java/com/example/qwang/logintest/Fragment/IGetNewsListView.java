package com.example.qwang.logintest.Fragment;

import com.example.qwang.logintest.Model.NewsResponse;

import java.util.List;

/**
 * Created by QWang on 2017/12/29.
 */

public interface IGetNewsListView {
    void getNewsListViewSuccess(List<NewsResponse.ResultEntity.ListEntity> newsList);
    void getNewsListViewFail();
}
