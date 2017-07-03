package com.jcj.royalni.jizhihu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Royal Ni on 2017/5/7.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter{
    List<String> mTitles = new ArrayList<>();
    List<Fragment> mFragments = new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm,List<String> data,List<Fragment> mFragments) {
        super(fm);
        mTitles = data;
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
