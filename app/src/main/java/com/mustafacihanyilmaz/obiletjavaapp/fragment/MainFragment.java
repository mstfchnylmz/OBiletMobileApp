package com.mustafacihanyilmaz.obiletjavaapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.mustafacihanyilmaz.obiletjavaapp.adapters.MainViewPagerAdapter;
import com.mustafacihanyilmaz.obiletjavaapp.R;

public class MainFragment extends Fragment {

    private View mainFragmentView;
    private TabLayout mainTabLayout;
    private ViewPager mainViewPager;
    private MainViewPagerAdapter viewPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainFragmentView = inflater.inflate(R.layout.fragment_main, container, false);

        initViews();

        /**
         * Tablayout ve ViewPager işlemleri
         */
        mainTabLayout.addTab(mainTabLayout.newTab().setText("Otobüs Bileti").setIcon(R.drawable.ic_directions_bus_16));
        mainTabLayout.addTab(mainTabLayout.newTab().setText("Uçak Bileti").setIcon(R.drawable.ic_flight_24));

        viewPagerAdapter = new MainViewPagerAdapter(getActivity().getSupportFragmentManager(), getContext(),mainTabLayout.getTabCount(), mainFragmentView);
        mainViewPager.setAdapter(viewPagerAdapter);

        mainViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainTabLayout));

        mainTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // binding.mainViewPager.currentItem = tab.position
                mainViewPager.setCurrentItem(tab.getPosition());
            }

            /**
             * Bu fonksiyonlar bilerek boş bırakıldı
             */
            @SuppressLint("ResourceAsColor")
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return mainFragmentView;
    }

    /**
     * Tablayout ve viewpager bu metodda tanımlanıyor
     */
    private void initViews(){
        mainTabLayout = mainFragmentView.findViewById(R.id.mainTabLayout);
        mainViewPager = mainFragmentView.findViewById(R.id.mainViewPager);
    }
}