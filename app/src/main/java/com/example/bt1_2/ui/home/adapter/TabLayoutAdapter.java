package com.example.bt1_2.ui.home.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TabLayoutAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment>fragmentArrayList=new ArrayList<>();
    private ArrayList<String>titleArraylist=new ArrayList<>();

    public TabLayoutAdapter(FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleArraylist.get(position);
    }

public void add(Fragment fragment,String title){
        fragmentArrayList.add(fragment);
        titleArraylist.add(title);
}
}
