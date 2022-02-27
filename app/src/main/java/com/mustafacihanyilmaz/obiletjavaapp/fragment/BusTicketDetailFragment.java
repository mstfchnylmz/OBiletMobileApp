package com.mustafacihanyilmaz.obiletjavaapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mustafacihanyilmaz.obiletjavaapp.adapters.BusTicketRVAdapter;
import com.mustafacihanyilmaz.obiletjavaapp.recyclerViewInterface.TicketRVInterface;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys.Datum;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys.GetBusJourney;
import com.mustafacihanyilmaz.obiletjavaapp.R;

import java.util.ArrayList;

public class BusTicketDetailFragment extends Fragment implements TicketRVInterface {
    private static final String TAG = BusTicketDetailFragment.class.getName();
    private View busTicketDetailView;
    private BusTicketRVAdapter busTicketAdapter;
    private RecyclerView recyclerViewBusTicketDetail;
    private ArrayList<Datum> busJourneyList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        busTicketDetailView = inflater.inflate(R.layout.fragment_bus_ticket_detail, container, false);

        getData();
        initViews();

        return busTicketDetailView;
    }


    private void initViews(){

        recyclerViewBusTicketDetail = busTicketDetailView.findViewById(R.id.recyclerViewBusTicketDetail);
        recyclerViewBusTicketDetail.setLayoutManager(new LinearLayoutManager(getActivity()));
        busTicketAdapter = new BusTicketRVAdapter(getContext(), busJourneyList,this);
        recyclerViewBusTicketDetail.setAdapter(busTicketAdapter);

    }

    /**
     * BusTicketFragment'tan gönderilen veri burada alınıyor
     */
    private void getData(){

        if (getArguments()!=null){

            busJourneyList = new ArrayList<>();

            GetBusJourney getBusJourney = BusTicketDetailFragmentArgs.fromBundle(getArguments()).getSendDataToFragment();

            assert getBusJourney != null;
            busJourneyList.addAll(getBusJourney.getData());

        }
    }

    @Override
    public void onItemClick(int position) {
        Log.d(TAG,"Card tıklandı " + position);
    }

    @Override
    public void onItemLongClick(int position) {
        Log.d(TAG,"Card tıklandı " + position);
    }

}