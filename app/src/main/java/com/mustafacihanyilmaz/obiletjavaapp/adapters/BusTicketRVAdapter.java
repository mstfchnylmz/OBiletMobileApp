package com.mustafacihanyilmaz.obiletjavaapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafacihanyilmaz.obiletjavaapp.fragment.BusTicketFragment;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys.Journey;
import com.mustafacihanyilmaz.obiletjavaapp.recyclerViewInterface.TicketRVInterface;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys.Datum;
import com.mustafacihanyilmaz.obiletjavaapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BusTicketRVAdapter extends RecyclerView.Adapter<BusTicketRVAdapter.BusTicketViewHolder> {
    private static final String TAG = BusTicketRVAdapter.class.getName();
    private View busTicketAdapterView;
    private Context context;
    private ArrayList<Datum> busJourneyList;
    private TicketRVInterface clickInterface;
    private String simpleDateString = "yyyy-MM-dd'T'HH:mm:ss";
    private String simpleHourString = "hh:mm";

    public BusTicketRVAdapter(Context context, ArrayList<Datum> busJourneyList, TicketRVInterface clickInterface) {
        this.context = context;
        this.busJourneyList = busJourneyList;
        this.clickInterface = clickInterface;

    }

    @NonNull
    @Override
    public BusTicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        busTicketAdapterView = LayoutInflater.from(context).inflate(R.layout.card_journey_detail, parent, false);

        return new BusTicketViewHolder(busTicketAdapterView);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull BusTicketViewHolder holder, int position) {
        if (busJourneyList != null) {
            Journey journey = busJourneyList.get(position).getJourney();

            String originTime = journey.getDeparture();
            String destinationTime = journey.getArrival();
            Double ticketPrice = journey.getInternetPrice();
            String originLocation = journey.getOrigin();
            String destinationLocation = journey.getDestination();

            try {
                /**
                 * Saatler formatlanıyor
                 */
                SimpleDateFormat format = new SimpleDateFormat(simpleDateString);
                Date originTimeFormated = format.parse(originTime);
                Date destinationFormated = format.parse(destinationTime);
                format = new SimpleDateFormat(simpleHourString);
                String originDate = format.format(originTimeFormated);
                String destinationDate = format.format(destinationFormated);

                /**
                 * Recyclerview card'ına veriler aktarılıyor
                 */
                holder.originTimeTextCard.setText(originDate);
                holder.destinationTimeTextCard.setText(destinationDate);
                holder.priceTextCard.setText(ticketPrice + " TL");
                holder.originLocationTextCard.setText(originLocation);
                holder.destinationLocationTextCard.setText(destinationLocation);
            } catch (ParseException e) {
                e.printStackTrace();
                Log.e(TAG,"Saat formatlama hatası! Hata mesajı: "+e.getLocalizedMessage());
                Toast.makeText(context, "Hata meydana geldi!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public int getItemCount() {

        return busJourneyList !=null ?  busJourneyList.size() : 0;

    }

    public class BusTicketViewHolder extends RecyclerView.ViewHolder {

        private TextView originTimeTextCard, destinationTimeTextCard,
                priceTextCard, originLocationTextCard, destinationLocationTextCard;
        private CardView busTicketRVCard;

        public BusTicketViewHolder(@NonNull View itemView) {
            super(itemView);

            originTimeTextCard = itemView.findViewById(R.id.originTimeTextCard);
            destinationTimeTextCard = itemView.findViewById(R.id.destinationTimeTextCard);
            priceTextCard = itemView.findViewById(R.id.priceTextCard);
            originLocationTextCard = itemView.findViewById(R.id.originLocationTextCard);
            destinationLocationTextCard = itemView.findViewById(R.id.destinationLocationTextCard);
            busTicketRVCard = itemView.findViewById(R.id.busTicketRVCard);

        }
    }
}
