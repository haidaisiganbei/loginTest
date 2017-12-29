package com.example.qwang.logintest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qwang.logintest.Model.NewsResponse;
import com.example.qwang.logintest.R;
import com.example.qwang.logintest.ViewHolder.ViewHolder;

import java.util.List;

/**
 * Created by QWang on 2017/12/28.
 */

public class NewsListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private List<NewsResponse.ResultEntity.ListEntity> data;

    public NewsListAdapter(Context mContext,List<NewsResponse.ResultEntity.ListEntity> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.news_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getmTitle().setText(data.get(position).getTitle());
        holder.getmTime().setText(data.get(position).getTime());
        holder.getmAuthor().setText(data.get(position).getSrc());
        Glide.with(mContext).load(data.get(position).getPic()).into(holder.getmPreImage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



}
