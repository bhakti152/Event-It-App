package com.example.lalit.eventit;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrgAnalytic extends Fragment {


    public FrgAnalytic() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_frg_analytic, container, false);
        final TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Sold"));
        tabLayout.addTab(tabLayout.newTab().setText("Check In"));
        tabLayout.addTab(tabLayout.newTab().setText("FeedBack"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager)view.findViewById(R.id.pager);

        final com.example.lalit.eventit.Analytics_Page_Adapter Adapter = new com.example.lalit.eventit.Analytics_Page_Adapter(getFragmentManager(), tabLayout.getTabCount());


        viewPager.setAdapter(Adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }

}
