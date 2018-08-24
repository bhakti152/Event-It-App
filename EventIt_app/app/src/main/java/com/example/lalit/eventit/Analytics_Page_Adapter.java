package com.example.lalit.eventit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class Analytics_Page_Adapter extends FragmentStatePagerAdapter {
    int mNoOfTabs;
    public Analytics_Page_Adapter(FragmentManager fm,int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                FrgSold tab1 = new FrgSold();
                return tab1;
            case 1:
                FrgAttendee tab2 = new FrgAttendee();
                return  tab2;
            case 2:
                FrgFeedback tab3 = new FrgFeedback();
                return  tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
