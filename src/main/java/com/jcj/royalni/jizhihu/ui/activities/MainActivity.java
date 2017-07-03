package com.jcj.royalni.jizhihu.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.jcj.royalni.jizhihu.R;
import com.jcj.royalni.jizhihu.adapter.ViewPagerAdapter;
import com.jcj.royalni.jizhihu.ui.fragments.NewsListFragment;
import com.jcj.royalni.jizhihu.utils.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
    @BindView(R.id.tool_bar)
    Toolbar mToolbar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.vp_content)
    ViewPager mViewPager;

    private static final int HOME_INDEX = 7;//主页面日期索引
    List<String> mTitles = new ArrayList<>();//标题的数据源
    List<Fragment> mFragments = new ArrayList<>();//主页面显示页面对应的fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        ButterKnife.bind(this);
        mToolbar.setTitle("知乎日报");
        mToolbar.inflateMenu(R.menu.main_page);
        mToolbar.setOnMenuItemClickListener(this);
        NewsAdapter adapter = new NewsAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    //状态栏菜单栏目点击
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(this,"search",Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

    class NewsAdapter extends FragmentStatePagerAdapter{

        public NewsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment newsFragment = new NewsListFragment();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR,1-position);

            return newsFragment;
        }

        @Override
        public int getCount() {
            return HOME_INDEX;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR,-position);
            String date = DateFormat.getDateInstance().format(calendar.getTime());
            return position == 0 ? "NEWS TODAY":date;
        }
    }
}
