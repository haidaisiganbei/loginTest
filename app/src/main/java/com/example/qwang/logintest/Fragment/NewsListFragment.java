package com.example.qwang.logintest.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qwang.logintest.Adapter.NewsListAdapter;
import com.example.qwang.logintest.Model.NewsResponse;
import com.example.qwang.logintest.Presenter.NewsListPresenter;
import com.example.qwang.logintest.R;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by QWang on 2017/12/28.
 */

public class NewsListFragment extends Fragment implements IGetNewsListView{

    private RecyclerView mNewslist;
    private NewsListAdapter newsListAdapter;
    private NewsListPresenter newsListPresenter;

    public static NewsListFragment getInstance(String type){
        NewsListFragment fragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String type = getArguments().getString("type");
        Log.d(TAG, "onCreate: "+type);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_list,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        newsListPresenter = new NewsListPresenter(this,getArguments().getString("type"));
        initView();
        initData();
    }

    private void initData() {
        newsListPresenter.getNewsList();
        final SwipeRefreshLayout swipeRefreshLayout=  getActivity().findViewById(R.id.srl_swipeRefreshLayout);
        //setColorSchemeResources()可以改变加载图标的颜色。
        swipeRefreshLayout.setColorSchemeResources(new int[]{R.color.colorAccent, R.color.colorPrimary});
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    private void initView() {
        mNewslist = getView().findViewById(R.id.rcv_news_list);
    }

    @Override
    public void getNewsListViewSuccess(List<NewsResponse.ResultEntity.ListEntity> newsList) {
        mNewslist.setLayoutManager(new LinearLayoutManager(getContext()));
        newsListAdapter = new NewsListAdapter(getContext(),newsList);
        mNewslist.setAdapter(newsListAdapter);
//        newsListAdapter.notifyDataSetChanged();
    }

    @Override
    public void getNewsListViewFail() {

    }
}
