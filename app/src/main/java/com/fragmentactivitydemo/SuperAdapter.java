package com.fragmentactivitydemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2017/5/16
 * Function:Fragment适配器
 */

public class SuperAdapter extends FragmentPagerAdapter {
    List<String> strings = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();
    Context context;
    int anInt;

    public SuperAdapter(FragmentManager fm, List<String> strings, List<Fragment> fragments, Context context) {
        super(fm);
        this.strings = strings;
        this.fragments = fragments;
        this.context = context;
        anInt = strings.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return anInt;
    }

    /**
     * 自定义方法
     *
     * @param postsion
     * @return
     */
    public View getTabview(int postsion) {
        ViewHolder viewHolder = ViewHolder.getView(context, null, null, R.layout.tab_item, postsion);

        TextView textView = viewHolder.getId(R.id.textView);
        textView.setText(strings.get(postsion));

        return viewHolder.getconverView();
    }
}

