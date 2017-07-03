package com.jcj.royalni.jizhihu.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcj.royalni.jizhihu.R;
import com.jcj.royalni.jizhihu.adapter.NewsRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsListFragment extends Fragment {
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.news_rv)
    RecyclerView mRecyclerView;

    List newsList = new ArrayList();
    public NewsListFragment() {

    }
//aaa
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i=0;i<20;i++) {
            newsList.add(1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        ButterKnife.bind(this,view);
        RecyclerView.LayoutManager llm = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        NewsRecyclerAdapter adapter = new NewsRecyclerAdapter(newsList);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setAdapter(adapter);
        return view;
    }
}
