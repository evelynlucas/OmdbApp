package org.pursuit.omdbapp.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

// Retrofit singleton created to for use with OmdbApi service
public class OmdbRetrofit {

    private static final String OMDB_BASE_URL = "https://www.omdbapi.com";

    private static Retrofit instance;

    private OmdbRetrofit() {
    }

    public static Retrofit getOmdbRetrofit() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(OMDB_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return instance;
    }
}
