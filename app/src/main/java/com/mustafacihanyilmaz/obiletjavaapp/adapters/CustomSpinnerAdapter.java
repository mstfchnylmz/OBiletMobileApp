package com.mustafacihanyilmaz.obiletjavaapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mustafacihanyilmaz.obiletjavaapp.models.getBusLocation.Datum;

import com.mustafacihanyilmaz.obiletjavaapp.R;

import java.util.List;

public class CustomSpinnerAdapter extends BaseAdapter {

    private final Context context;
    private final List<Datum> citiesList;

    public CustomSpinnerAdapter(Context context, List<Datum> citiesList) {
        this.context = context;
        this.citiesList = citiesList;
    }

    @Override
    public int getCount() {
        return citiesList != null ? citiesList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_spinner, viewGroup, false);

        TextView spinnerElement = rootView.findViewById(R.id.spinnerElement);

        spinnerElement.setText(citiesList.get(i).getName());

        return rootView;
    }
}
