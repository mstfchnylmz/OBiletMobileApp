package com.mustafacihanyilmaz.obiletjavaapp.webService;

import com.google.gson.JsonObject;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys.GetBusJourney;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusJourneys.SendGetBusJourneys;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusLocation.GetBusLocation;
import com.mustafacihanyilmaz.obiletjavaapp.models.getBusLocation.SendGetBusLocation;
import com.mustafacihanyilmaz.obiletjavaapp.models.getSession.GetSessionData;
import com.mustafacihanyilmaz.obiletjavaapp.models.getSession.SendSessionData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    @POST("client/getsession")
    Call<GetSessionData> getSession(@Header("Content-Type")String contentType, @Header("Authorization")String auth, @Body SendSessionData sendSessionData);

    @POST("location/getbuslocations")
    Call<GetBusLocation> getBusLocationData(@Header("Content-Type")String contentType, @Header("Authorization")String auth, @Body SendGetBusLocation sendGetBusLocation);

    @POST("journey/getbusjourneys")
    Call<JsonObject> getBusJourneyData(@Header("Content-Type")String contentType, @Header("Authorization")String auth, @Body SendGetBusJourneys sendGetBusJourneys);

    @POST("journey/getbusjourneys")
    Call<GetBusJourney> getBusJourney(@Header("Content-Type")String contentType, @Header("Authorization")String auth, @Body SendGetBusJourneys sendGetBusJourneys);


}
