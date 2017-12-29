package com.example.qwang.logintest.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qwang.logintest.R;

/**
 * Created by QWang on 2017/12/29.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView tv_test;
    private TextView mTitle;
    private TextView mAuthor;
    private TextView mTime;
    private ImageView mPreImage;

    public TextView getmTitle() {
        return mTitle;
    }

    public void setmTitle(TextView mTitle) {
        this.mTitle = mTitle;
    }

    public TextView getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(TextView mAuthor) {
        this.mAuthor = mAuthor;
    }

    public TextView getmTime() {
        return mTime;
    }

    public void setmTime(TextView mTime) {
        this.mTime = mTime;
    }

    public ImageView getmPreImage() {
        return mPreImage;
    }

    public void setmPreImage(ImageView mPreImage) {
        this.mPreImage = mPreImage;
    }



    public TextView getTv_test() {
        return tv_test;
    }

    public void setTv_test(TextView tv_test) {
        this.tv_test = tv_test;
    }

    public ViewHolder(View itemView) {
        super(itemView);
        tv_test = itemView.findViewById(R.id.tv_test);
        mTitle = itemView.findViewById(R.id.tv_news_title);
        mAuthor = itemView.findViewById(R.id.tv_author);
        mTime = itemView.findViewById(R.id.tv_time);
        mPreImage = itemView.findViewById(R.id.iv_pre_image);
    }
}