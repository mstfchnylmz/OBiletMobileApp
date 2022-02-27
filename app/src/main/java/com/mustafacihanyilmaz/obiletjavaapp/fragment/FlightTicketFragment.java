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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;
import com.mustafacihanyilmaz.obiletjavaapp.adapters.CustomSpinnerAdapter;
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

public class FlightTicketFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private static final String TAG = FlightTicketFragment.class.getName();
    private View flightTicketFragmentView;

    protected ApiService mApiService;

    private String sessionId, deviceId, originName, destinationName;
    private ArrayList<Datum> flightLocationList = new ArrayList<>();
    CustomSpinnerAdapter customSpinnerAdapter;
    private Integer originId, destinationId;

    private TextView titleTextFromWhereFlight, titleTextToWhereFlight,
            titleTextCalendarFlight2, numberOfPassengerText,
            addPassengerText, contentTextFlightTicketFragment,
            numberOfDayDepartureDate, monthDepartureDate, dayDepartureDate,
            numberOfDayReturnDate, monthReturnDate, dayReturnDate;
    private Spinner spinnerFromWhereFlight, spinnerToWhereFlight;
    private ImageView imageFromWhereFlight, imageToWhereFlight, imageCalendar;
    private ImageButton changeButtonFlightTicketFragment, clearDateFlightTicket;
    private MaterialButton findTicketButtonFlightTicketFragment;

    private LinearLayout linearCardDeparture, linearCardReturn;

    final Calendar flightTicketCalendar = Calendar.getInstance();

    private ConstraintLayout flightConstraint;
    private LottieAnimationView loadingFlightAnimationView;

    private String flightDepartureDate;
    private int spinnerPositionFirst, spinnerPositionSecond;
    private static final String ticketFormat2 = "dd";
    private static final String ticketFormat3 = "MMMM";
    private static final String ticketFormat4 = "EEEE";
    private static final String ticketFormat = "dd MMMM yyyy EEEE";
    private static final String ticketDateFormat = "yyyy-MM-dd";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        flightTicketFragmentView = inflater.inflate(R.layout.fragment_flight_ticket, container, false);

        initViews();
        initListener();
        getSessionData();
        tomorrowWork();

        return flightTicketFragmentView;
    }

    /**
     * View tanımlamaları
     */
    private void initViews() {
        flightConstraint = flightTicketFragmentView.findViewById(R.id.flightConstraint);
        loadingFlightAnimationView = flightTicketFragmentView.findViewById(R.id.loadingFlightAnimationView);
        titleTextFromWhereFlight = flightTicketFragmentView.findViewById(R.id.titleTextFromWhereFlight);
        titleTextToWhereFlight = flightTicketFragmentView.findViewById(R.id.titleTextToWhereFlight);
        titleTextCalendarFlight2 = flightTicketFragmentView.findViewById(R.id.titleTextCalendarFlight2);
        numberOfPassengerText = flightTicketFragmentView.findViewById(R.id.numberOfPassengerText);
        addPassengerText = flightTicketFragmentView.findViewById(R.id.addPassengerText);
        contentTextFlightTicketFragment = flightTicketFragmentView.findViewById(R.id.contentTextFlightTicketFragment);
        numberOfDayDepartureDate = flightTicketFragmentView.findViewById(R.id.numberOfDayDepartureDate);
        monthDepartureDate = flightTicketFragmentView.findViewById(R.id.monthDepartureDate);
        dayDepartureDate = flightTicketFragmentView.findViewById(R.id.dayDepartureDate);
        numberOfDayReturnDate = flightTicketFragmentView.findViewById(R.id.numberOfDayReturnDate);
        monthReturnDate = flightTicketFragmentView.findViewById(R.id.monthReturnDate);
        dayReturnDate = flightTicketFragmentView.findViewById(R.id.dayReturnDate);

        spinnerFromWhereFlight = flightTicketFragmentView.findViewById(R.id.spinnerFromWhereFlight);
        spinnerToWhereFlight = flightTicketFragmentView.findViewById(R.id.spinnerToWhereFlight);

        changeButtonFlightTicketFragment = flightTicketFragmentView.findViewById(R.id.changeButtonFlightTicketFragment);
        clearDateFlightTicket = flightTicketFragmentView.findViewById(R.id.clearDateFlightTicket);

        findTicketButtonFlightTicketFragment = flightTicketFragmentView.findViewById(R.id.findTicketButtonFlightTicketFragment);

        linearCardDeparture = flightTicketFragmentView.findViewById(R.id.linearCardDeparture);
        linearCardReturn = flightTicketFragmentView.findViewById(R.id.linearCardReturn);
    }

    /**
     * Tıklanabilir nesnelerin click tanımlamaları
     */
    private void initListener() {
        changeButtonFlightTicketFragment.setOnClickListener(this);
        clearDateFlightTicket.setOnClickListener(this);
        findTicketButtonFlightTicketFragment.setOnClickListener(this);
        addPassengerText.setOnClickListener(this);
        spinnerFromWhereFlight.setOnItemSelectedListener(this);
        spinnerToWhereFlight.setOnItemSelectedListener(this);
        linearCardDeparture.setOnClickListener(this);
        linearCardReturn.setOnClickListener(this);
    }

    /**
     * Butonlara tıklandığında çalışacak metodlara buradan ulaşılabilir
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changeButtonFlightTicketFragment:
                changeFlightSpinnerData();
                break;
            case R.id.clearDateFlightTicket:
                Toast.makeText(getContext(), "Temizleme butonu tıklandı", Toast.LENGTH_SHORT).show();
                break;
            case R.id.findTicketButtonFlightTicketFragment:
                Toast.makeText(getContext(), "Bilet arama butonu tıklandı", Toast.LENGTH_SHORT).show();
                break;
            case R.id.addPassengerText:
                Toast.makeText(getContext(), "Yolcu ekleme butonu tıklandı", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linearCardDeparture:
                Toast.makeText(getContext(), "Gidiş tarihi tıklandı", Toast.LENGTH_SHORT).show();
                setCalendar();
                break;
            case R.id.linearCardReturn:
                Toast.makeText(getContext(), "Dönüş tarihi tıklandı", Toast.LENGTH_SHORT).show();
                setCalendar();
                break;
        }
    }

    /**
     * Spinner(Dropdown)'da bir seçenek seçildiğinde çalışacak metod
     * @param adapterView
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.spinnerFromWhereFlight:

                originId = flightLocationList.get(i).getId();
                originName = flightLocationList.get(i).getName();

                spinnerPositionFirst = adapterView.getSelectedItemPosition();

                break;
            case R.id.spinnerToWhereFlight:

                destinationId = flightLocationList.get(i).getId();
                destinationName = flightLocationList.get(i).getName();

                spinnerPositionSecond = adapterView.getSelectedItemPosition();

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /**
     * Session datası Api'dan burada alınıyor
     */
    private void getSessionData() {

        mApiService = ApiClient.getClient().create(ApiService.class);

        SendSessionData sendSessionData = new SendSessionData();
        sendSessionData.setType(3);

        Object connection = new Object();
        sendSessionData.setConnection(connection);

        Application application = new Application();
        application.setVersion(SESSION_VERSION);
        application.setEquipmentId(SESSION_EQUIPMENT_ID);
        sendSessionData.setApplication(application);

        Call<GetSessionData> callSessionData = mApiService.getSession(CONTENT_TYPE, AUTHORIZATION, sendSessionData);

        callSessionData.enqueue(new Callback<GetSessionData>() {
            @Override
            public void onResponse(Call<GetSessionData> call, Response<GetSessionData> response) {
                if (response.body() != null) {

                    sessionId = response.body().getData().getSessionId();
                    deviceId = response.body().getData().getDeviceId();

                    getFlightLocationData(sessionId, deviceId);

                } else {
                    Log.d(TAG, "Session verisi gelmiyor");
                    Toast.makeText(getContext(), "Hata meydana geldi!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetSessionData> call, Throwable t) {
                Log.d(TAG, "Session verisinde hata meydana geldi. Hata mesajı: " + t.getLocalizedMessage());
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * Uçuşların olduğu lokasyonlar burada alınıyor ve spinnera yazdırılıyor
     * @param sessionId
     * @param deviceId
     */
    private void getFlightLocationData(String sessionId, String deviceId) {
        mApiService = ApiClient.getClient().create(ApiService.class);

        SendGetBusLocation sendGetBusLocation = new SendGetBusLocation();

        DeviceSession deviceSession = new DeviceSession();
        deviceSession.setSessionId(sessionId);
        deviceSession.setDeviceId(deviceId);
        sendGetBusLocation.setDeviceSession(deviceSession);
        sendGetBusLocation.setDate("2016-03-11T11:33:00");
        sendGetBusLocation.setLanguage(LANGUAGE);

        Call<GetBusLocation> getBusLocation = mApiService.getBusLocationData(CONTENT_TYPE, AUTHORIZATION, sendGetBusLocation);

        getBusLocation.enqueue(new Callback<GetBusLocation>() {
            @Override
            public void onResponse(Call<GetBusLocation> call, Response<GetBusLocation> response) {
                if (response.body() != null) {

                    loadingFlightAnimationView.setVisibility(View.GONE);
                    flightConstraint.setVisibility(View.VISIBLE);
                    flightLocationList = (ArrayList<Datum>) response.body().getData();

                    customSpinnerAdapter = new CustomSpinnerAdapter(getContext(), flightLocationList);
                    spinnerFromWhereFlight.setAdapter(customSpinnerAdapter);
                    spinnerToWhereFlight.setAdapter(customSpinnerAdapter);

                } else {
                    Log.d(TAG, "Lokasyon verisi gelmiyor");
                    Toast.makeText(getContext(), "Hata meydana geldi!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetBusLocation> call, Throwable t) {
                Log.d(TAG, "Lokasyon verileri alırken hata meydana geldi. Hata mesajı: " + t.getLocalizedMessage());
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * Kullanıcının tarih seçmesini sağlacak datepicker'ın işlemleri
     */
    private void setCalendar() {

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                flightTicketCalendar.set(Calendar.YEAR, year);
                flightTicketCalendar.set(Calendar.MONTH, month);
                flightTicketCalendar.set(Calendar.DAY_OF_MONTH, day);
                dateFormat();
                setJourneyDate();
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), date, flightTicketCalendar.get(Calendar.YEAR), flightTicketCalendar.get(Calendar.MONTH), flightTicketCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();

    }

    /**
     * Ekrandaki tarihlerin düzgün yazdırılması için tarihler burada formatlanıyor
     */
    private void dateFormat() {

        SimpleDateFormat dateFormat2 = new SimpleDateFormat(ticketFormat2, new Locale("tr", "TR"));
        SimpleDateFormat dateFormat3 = new SimpleDateFormat(ticketFormat3, new Locale("tr", "TR"));
        SimpleDateFormat dateFormat4 = new SimpleDateFormat(ticketFormat4, new Locale("tr", "TR"));

        numberOfDayDepartureDate.setText(dateFormat2.format(flightTicketCalendar.getTime()));
        monthDepartureDate.setText(dateFormat3.format(flightTicketCalendar.getTime()));
        dayDepartureDate.setText(dateFormat4.format(flightTicketCalendar.getTime()));

    }

    /**
     * Başlangıçta tarih bölümünün yarına ayarlanması için kullanılıyor
     */
    private void tomorrowWork() {
        flightTicketCalendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = flightTicketCalendar.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat(ticketFormat, new Locale("tr", "TR"));
        SimpleDateFormat dateFormat2 = new SimpleDateFormat(ticketFormat2, new Locale("tr", "TR"));
        SimpleDateFormat dateFormat3 = new SimpleDateFormat(ticketFormat3, new Locale("tr", "TR"));
        SimpleDateFormat dateFormat4 = new SimpleDateFormat(ticketFormat4, new Locale("tr", "TR"));

        numberOfDayDepartureDate.setText(dateFormat2.format(tomorrow.getTime()));
        monthDepartureDate.setText(dateFormat3.format(tomorrow.getTime()));
        dayDepartureDate.setText(dateFormat4.format(tomorrow.getTime()));

        flightTicketCalendar.setTime(tomorrow);

    }

    private void setJourneyDate() {

        SimpleDateFormat dateFormat = new SimpleDateFormat(ticketDateFormat, new Locale("tr", "TR"));
        flightDepartureDate = dateFormat.format(flightTicketCalendar.getTime());

    }

    private void changeFlightSpinnerData() {
        spinnerFromWhereFlight.setSelection(spinnerPositionSecond);
        spinnerToWhereFlight.setSelection(spinnerPositionFirst);
    }
}