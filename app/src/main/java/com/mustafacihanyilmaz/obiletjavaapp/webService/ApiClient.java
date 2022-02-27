package com.mustafacihanyilmaz.obiletjavaapp.webService;

import static com.mustafacihanyilmaz.obiletjavaapp.utils.Utils.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;
    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }

    public static ApiService getAPIService() {
        return getClient().create(ApiService.class);
    }
}
