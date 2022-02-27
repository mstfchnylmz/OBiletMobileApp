package com.mustafacihanyilmaz.obiletjavaapp.fragment;

import static android.provider.MediaStore.Video.VideoColumns.LANGUAGE;
import static com.mustafacihanyilmaz.obiletjavaapp.utils.Utils.AUTHORIZATION;
import static com.mustafacihanyilmaz.obiletjavaapp.utils.Utils.CONTENT_TYPE;
import static com.mustafacihanyilmaz.obiletjavaapp.utils.Utils.SESSION_EQUIPMENT_ID;
import static com.mustafacihanyilmaz.obiletjavaapp.utils.Utils.SESSION_VERSION;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;
import com.mustafacihanyilmaz.obiletjavaapp.adapters.CustomSpinnerAdapter;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys.GetBusJourney;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys.JourneyData;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys.JourneyDeviceSession;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys.SendGetBusJourneys;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusLocation.Datum;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusLocation.DeviceSession;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusLocation.GetBusLocation;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusLocation.SendGetBusLocation;
import com.mustafacihanyilmaz.obiletjavaapp.models.getSession.Application;
import com.mustafacihanyilmaz.obiletjavaapp.models.getSession.GetSessionData;
import com.mustafacihanyilmaz.obiletjavaapp.models.getSession.SendSessionData;
import com.mustafacihanyilmaz.obiletjavaapp.R;
import com.mustafacihanyilmaz.obiletjavaapp.webService.ApiClient;
import com.mustafacihanyilmaz.obiletjavaapp.webService.ApiService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusTicketFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private static final String TAG = BusTicketFragment.class.getName();
    private View busTicketFragmentView;
    protected ApiService mApiService;

    private String sessionId, deviceId, originName, destinationName;
    private Integer originId, destinationId;

    private TextView titleTextFromWhere, titleTextToWhere, titleTextCalendar, contentTextCalendar, contentTextBusTicketFragment;
    private MaterialButton findTicketButtonBusTicketFragment;
    private Button todayButtonBusTicketFragment, tomorrowButtonBusTicketFragment;
    private ImageButton changeButtonBusTicketFragment;

    private Spinner spinnerFromWhere, spinnerToWhere;
    private CustomSpinnerAdapter customSpinnerAdapter;

    private ArrayList<Datum> busLocationList = new ArrayList<>();

    final Calendar ticketCalendar= Calendar.getInstance();
    private String departureDate;

    private ConstraintLayout mainConstraint;
    private LottieAnimationView loadindAnimationView;

    private Datum datum1, datum2;

    private int spinnerPositionFirst, spinnerPositionSecond;

    private static final int datePickerConst = 1000;
    private static final String ticketFormat = "dd MMMM yyyy EEEE";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        busTicketFragmentView = inflater.inflate(R.layout.fragment_bus_ticket, container, false);

        Log.d("fragmentControl","Bus Ticket fragmentta");

        getSessionData();
        initViews();
        initListener();

        todayWork();

        return busTicketFragmentView;
    }
    /**
     * Otobüs kalkış lokasyon verisinin elde edilmesi
     * //@param sessionId kullanıcı session id
     * //@param deviceId kullanıcın device id
     */
    private void getSessionData(){

        mApiService = ApiClient.getClient().create(ApiService.class);

        SendSessionData sendSessionData = new SendSessionData();
        sendSessionData.setType(3);

        Object connection = new Object();
        sendSessionData.setConnection(connection);

        Application application = new Application();
        application.setVersion(SESSION_VERSION);
        application.setEquipmentId(SESSION_EQUIPMENT_ID);
        sendSessionData.setApplication(application);

        Call<GetSessionData> callSessionData = mApiService.getSession(CONTENT_TYPE,AUTHORIZATION,sendSessionData);

        callSessionData.enqueue(new Callback<GetSessionData>() {
            @Override
            public void onResponse(Call<GetSessionData> call, Response<GetSessionData> response) {
                if (response.body() != null){

                    sessionId = response.body().getData().getSessionId();
                    deviceId = response.body().getData().getDeviceId();

                    getBusLocationData(sessionId,deviceId);

                }else{
                    Log.d(TAG,"Session verisi gelmiyor!");
                }
            }

            @Override
            public void onFailure(Call<GetSessionData> call, Throwable t) {
                Log.d(TAG,"Session verisini alırken hata meydana geldi. Hata mesajı: "+t.getLocalizedMessage());
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * Görsel ögelerin tanıtılması
     */
    private void initViews(){
        mainConstraint = busTicketFragmentView.findViewById(R.id.mainConstraint);
        loadindAnimationView = busTicketFragmentView.findViewById(R.id.loadindAnimationView);
        titleTextFromWhere = busTicketFragmentView.findViewById(R.id.titleTextFromWhere);
        titleTextToWhere = busTicketFragmentView.findViewById(R.id.titleTextToWhere);
        titleTextCalendar = busTicketFragmentView.findViewById(R.id.titleTextCalendar);
        contentTextCalendar = busTicketFragmentView.findViewById(R.id.contentTextCalendar);
        contentTextBusTicketFragment = busTicketFragmentView.findViewById(R.id.contentTextBusTicketFragment);

        spinnerFromWhere = busTicketFragmentView.findViewById(R.id.spinnerFromWhere);
        spinnerToWhere = busTicketFragmentView.findViewById(R.id.spinnerToWhere);

        findTicketButtonBusTicketFragment = busTicketFragmentView.findViewById(R.id.findTicketButtonBusTicketFragment);

        todayButtonBusTicketFragment = busTicketFragmentView.findViewById(R.id.todayButtonBusTicketFragment);
        tomorrowButtonBusTicketFragment = busTicketFragmentView.findViewById(R.id.tomorrowButtonBusTicketFragment);

        changeButtonBusTicketFragment = busTicketFragmentView.findViewById(R.id.changeButtonBusTicketFragment);

    }

    /**
     * Tıklanabilir ögelerin tıklanma metodları buradan çağrılıyor
     */
    private void initListener(){
        findTicketButtonBusTicketFragment.setOnClickListener(this);
        todayButtonBusTicketFragment.setOnClickListener(this);
        tomorrowButtonBusTicketFragment.setOnClickListener(this);
        changeButtonBusTicketFragment.setOnClickListener(this);
        contentTextCalendar.setOnClickListener(this);

        spinnerFromWhere.setOnItemSelectedListener(this);
        spinnerToWhere.setOnItemSelectedListener(this);
    }

    /**
     * Tıklanabilir ögelerin tıklanma metodları buradan atanıyor
     * @param view
     */
    @Override
    public void onClick(View view) {

      switch (view.getId()){
          case R.id.findTicketButtonBusTicketFragment:
              getBusJourney();
              break;
          case R.id.todayButtonBusTicketFragment:
              todayWork();
              break;
          case R.id.tomorrowButtonBusTicketFragment:
              tomorrowWork();
              break;
          case R.id.changeButtonBusTicketFragment:
              changeLocation();
              break;
          case R.id.contentTextCalendar:
              setCalendar();
              break;
      }

    }

    /**
     * Spinner'ın elemanlarından biri seçildiğinde çalışacak metod
     * @param adapterView
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()){
            case R.id.spinnerFromWhere:

                originId = busLocationList.get(i).getId();
                originName = busLocationList.get(i).getName();

                spinnerPositionFirst = adapterView.getSelectedItemPosition();

                break;
            case R.id.spinnerToWhere:

                destinationId = busLocationList.get(i).getId();
                destinationName = busLocationList.get(i).getName();

                datum2 = new Datum();
                datum2 = busLocationList.get(i);

                spinnerPositionSecond = adapterView.getSelectedItemPosition();

                break;
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /**
     * "Nereden" ve "Nereye" kısımlarının değerlerinin yer değiştirilmesi
     */
    private void changeLocation(){

        spinnerFromWhere.setSelection(spinnerPositionSecond);
        spinnerToWhere.setSelection(spinnerPositionFirst);

    }

    /**
     * Otobüs kalkış lokasyon verisinin elde edilmesi
     * @param sessionId
     * @param deviceId
     */
    private void getBusLocationData(String sessionId, String deviceId){
        mApiService = ApiClient.getClient().create(ApiService.class);

        SendGetBusLocation sendGetBusLocation = new SendGetBusLocation();

        DeviceSession deviceSession = new DeviceSession();
        deviceSession.setSessionId(sessionId);
        deviceSession.setDeviceId(deviceId);
        sendGetBusLocation.setDeviceSession(deviceSession);

        sendGetBusLocation.setDate("2016-03-11T11:33:00");
        sendGetBusLocation.setLanguage(LANGUAGE);

        Call<GetBusLocation> getBusLocation = mApiService.getBusLocationData(CONTENT_TYPE,AUTHORIZATION,sendGetBusLocation);

        getBusLocation.enqueue(new Callback<GetBusLocation>() {
            @Override
            public void onResponse(Call<GetBusLocation> call, Response<GetBusLocation> response) {
                if (response.body() != null){

                    loadindAnimationView.setVisibility(View.GONE);
                    mainConstraint.setVisibility(View.VISIBLE);
                    busLocationList = (ArrayList<Datum>) response.body().getData();

                    //spinner adapter atalamaları
                    customSpinnerAdapter = new CustomSpinnerAdapter(getContext(),busLocationList);
                    spinnerFromWhere.setAdapter(customSpinnerAdapter);
                    spinnerToWhere.setAdapter(customSpinnerAdapter);

                }else{
                    Log.d(TAG,"Lokasyon verisi gelmiyor");
                    Toast.makeText(getContext(), "Hata meydana geldi!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetBusLocation> call, Throwable t) {
                Log.d(TAG,"Lokasyon verisini alırken hata meydana geldi. Hata mesajı: "+t.getLocalizedMessage());
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * Kullanıcının takvimde seçim yapabilmesini sağlama ve seçilen tarihin istenilen formatta kulanılmasını sağlamak
     */
    private void setCalendar(){

        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                ticketCalendar.set(Calendar.YEAR, year);
                ticketCalendar.set(Calendar.MONTH,month);
                ticketCalendar.set(Calendar.DAY_OF_MONTH,day);
                dateFormat();
                setJourneyDate();
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),date,ticketCalendar.get(Calendar.YEAR),ticketCalendar.get(Calendar.MONTH),ticketCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - datePickerConst);
        datePickerDialog.show();

    }

    /**
     * Ekrana yazdırılacak tarihin formatlanması
     */
    private void dateFormat(){

        SimpleDateFormat dateFormat=new SimpleDateFormat(ticketFormat,new Locale("tr", "TR"));
        contentTextCalendar.setText(dateFormat.format(ticketCalendar.getTime()));

    }

    /**
     * getBusJourney'e göndermek için tarihin formatlanması
     */
    private void setJourneyDate(){

        String ticketDateFormat = "yyyy-MM-dd";
        SimpleDateFormat dateFormat=new SimpleDateFormat(ticketDateFormat,new Locale("tr", "TR"));
        departureDate = dateFormat.format(ticketCalendar.getTime());

    }

    /**
     * Bugünün tarihinin takvimde işaretlenmesi
     */
    private void todayWork(){

        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat=new SimpleDateFormat(ticketFormat,new Locale("tr", "TR"));
        contentTextCalendar.setText(dateFormat.format(currentTime.getTime()));
        ticketCalendar.setTime(currentTime);
        setJourneyDate();

    }

    /**
     * Yarının tarihinin sistemden alınması
     */
    private void tomorrowWork(){
        ticketCalendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = ticketCalendar.getTime();
        String ticketFormat = "dd MMMM yyyy EEEE";
        SimpleDateFormat dateFormat=new SimpleDateFormat(ticketFormat,new Locale("tr", "TR"));
        contentTextCalendar.setText(dateFormat.format(tomorrow.getTime()));

    }

    /**
     * Journey verisinin Api'den alınması
     */
    private void getBusJourney(){

        mApiService = ApiClient.getClient().create(ApiService.class);
        SendGetBusJourneys sendGetBusJourneys = new SendGetBusJourneys();

        JourneyDeviceSession journeyDeviceSession = new JourneyDeviceSession();
        journeyDeviceSession.setSessionId(sessionId);
        journeyDeviceSession.setDeviceId(deviceId);
        sendGetBusJourneys.setDeviceSession(journeyDeviceSession);

        sendGetBusJourneys.setDate("2019-02-28T10:34:00");
        sendGetBusJourneys.setLanguage(LANGUAGE);

        JourneyData journeyData = new JourneyData();
        journeyData.setOriginId(originId);
        journeyData.setDestinationId(destinationId);

        journeyData.setDepartureDate(departureDate);
        sendGetBusJourneys.setData(journeyData);

        if (originId != destinationId){
            Call<GetBusJourney> getBusJourneyCall = mApiService.getBusJourney(CONTENT_TYPE,AUTHORIZATION,sendGetBusJourneys);
            getBusJourneyCall.enqueue(new Callback<GetBusJourney>() {
                @Override
                public void onResponse(Call<GetBusJourney> call, Response<GetBusJourney> response) {
                    if (response.body()!= null){

                        GetBusJourney getBusJourney = response.body();
                        MainFragmentDirections.ActionMainFragmentToBusTicketDetailFragment mainAction = MainFragmentDirections.actionMainFragmentToBusTicketDetailFragment();
                        mainAction.setSendDataToFragment(getBusJourney);
                        Navigation.findNavController(busTicketFragmentView).navigate(mainAction);

                    }else{
                        Log.d(TAG,"Journey verisi gelmiyor");
                        Toast.makeText(getContext(), "Hata meydana geldi!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<GetBusJourney> call, Throwable t) {
                    Log.d(TAG,"Journey verisini alırken hata meydana geldi. Hata mesajı: "+t.getLocalizedMessage());
                    Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            Toast.makeText(getContext(),"Lütfen kalkış ve varış yerini seçiniz!",Toast.LENGTH_SHORT).show();
        }

    }
}