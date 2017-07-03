package com.jcj.royalni.jizhihu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcj.royalni.jizhihu.MyApplication;
import com.jcj.royalni.jizhihu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Royal Ni on 2017/7/3.
 * 新闻列表adapter
 */

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.NewsViewHolder>{

    List newsList = new ArrayList();

    public NewsRecyclerAdapter(List newsList) {
        this.newsList = newsList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newslist,parent,false);
        NewsViewHolder holder = new NewsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_pre)
        ImageView iv_pre;
        @BindView(R.id.news_topic)
        TextView tv_title;
        @BindView(R.id.news_brief)
        TextView getTv_titlebrief;
        @BindView(R.id.iv_share)
        ImageView iv_share;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
