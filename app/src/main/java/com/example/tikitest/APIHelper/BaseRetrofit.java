package com.example.tikitest.APIHelper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.example.tikitest.APIHelper.Constant.URL_BASE;

public class BaseRetrofit {
    private Retrofit retrofit;
    private static BaseRetrofit instanceRetrofit;
    private BaseRetrofit()
    {

        retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


    }


    public static synchronized BaseRetrofit getInstanceRetrofit()
    {
        if(instanceRetrofit == null)
        {
            instanceRetrofit = new BaseRetrofit();
        }

        return instanceRetrofit;

    }

    public API getAPI()
    {
        return retrofit.create(API.class);
    }
}
