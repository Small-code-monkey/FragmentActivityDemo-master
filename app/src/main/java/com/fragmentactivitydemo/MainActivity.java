package com.fragmentactivitydemo;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Context context = MainActivity.this;
    List<Fragment> fragments = new ArrayList<>();
    List<String> strings = new ArrayList<>();
    SuperAdapter superAdapter;
    private TabLayout tablayout1;
    private ViewPager viewpager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        for (int i = 1; i <= 3; i++) {
            strings.add("第" + i + "界面");
        }

        for (int i = 0; i <= strings.size(); i++) {
            fragments.add(new OneFragment());
        }

        superAdapter = new SuperAdapter(getSupportFragmentManager(), strings, fragments, context);
        viewpager1.setAdapter(superAdapter);

        tablayout1.setupWithViewPager(viewpager1);
        tablayout1.setTabMode(TabLayout.MODE_FIXED);

        for (int i = 0; i < tablayout1.getTabCount(); i++) {
            TabLayout.Tab tab = tablayout1.getTabAt(i);
            tab.setCustomView(superAdapter.getTabview(i));
        }

    }

    private void initView() {
        tablayout1 = (TabLayout) findViewById(R.id.tablayout1);
        tablayout1.setSelectedTabIndicatorHeight(0);
        viewpager1 = (ViewPager) findViewById(R.id.viewpager1);
    }
}
