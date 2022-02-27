package com.mustafacihanyilmaz.obiletjavaapp.adapters;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mustafacihanyilmaz.obiletjavaapp.fragment.BusTicketFragment;
import com.mustafacihanyilmaz.obiletjavaapp.fragment.FlightTicketFragment;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private FragmentManager fm;
    private Integer totalTabs;
    private View adapterView;

    public MainViewPagerAdapter(@NonNull FragmentManager fm, Context context, Integer totalTabs, View adapterView) {
        super(fm);
        this.context = context;
        this.fm = fm;
        this.totalTabs = totalTabs;
        this.adapterView = adapterView;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
         switch (position){
            case 0: return new BusTicketFragment();
            case 1: return new FlightTicketFragment();
            default: return new BusTicketFragment();
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
