package com.example.qwang.logintest.Activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.qwang.logintest.Fragment.NewsListFragment;
import com.example.qwang.logintest.Fragment.TestFragment;
import com.example.qwang.logintest.R;
import com.example.qwang.logintest.User;
import com.example.qwang.logintest.Utils.okhttpUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.qwang.logintest.config.NEWS_TOP;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity {
    private Button btn_setting;
    private TextView tv_username;
    private User user;

    private TabLayout mNewsCategory;
    private ViewPager mNewsList;
    private String[] titles = {"头条","新闻","财经","体育","娱乐","军事","教育","科技","NBA","股票","星座","女性","健康","育儿"};
    private List<Fragment> fragments = new ArrayList<>();
//    private okhttpUtil okhttpUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        user = (User) getIntent().getSerializableExtra("user");
        initView();
        listener();
//        okhttpUtil = new okhttpUtil();
//        okhttpUtil.getAsynHttp(NEWS_TOP);
    }

    private void listener() {
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));

            }
        });
    }

    private void initView() {
        btn_setting = findViewById(R.id.btn_setting);
        tv_username = findViewById(R.id.tv_username);
//        tv_username.setText("用户名：" + user.getUsername());
        mNewsCategory = findViewById(R.id.tl_news_category);
        mNewsList = findViewById(R.id.vp_news_list);

        for (int i=0;i<titles.length;i++){
            fragments.add(NewsListFragment.getInstance(titles[i]));
//            fragments.add(new NewsListFragment());
        }
//        fragments.add(new NewsListFragment());
//        fragments.add(new TestFragment());
        mNewsList.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        mNewsCategory.setupWithViewPager(mNewsList);

    }
}
