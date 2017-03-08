package com.edwinb.swipetabexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by EDWINB on 2/27/2017.
 */

public class MyFragPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> pages = new ArrayList<>();

    public MyFragPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    // Add a page
    public void addPage(Fragment f)
    {
        pages.add(f);
    }

    // Set title for tabs


    @Override
    public CharSequence getPageTitle(int position) {
        return pages.get(position).toString();
    }
}
