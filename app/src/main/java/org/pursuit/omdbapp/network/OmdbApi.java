package org.pursuit.omdbapp.network;

import org.pursuit.omdbapp.BuildConfig;
import org.pursuit.omdbapp.models.EpisodeInfo;
import org.pursuit.omdbapp.models.Series;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OmdbApi {

    // Hidden APIKey in local build.gradle
    String API_KEY = BuildConfig.OmdbApiKey;

    //Using query for title of series
    @GET("?apikey=" + API_KEY + "&plot=full&Season=1")
    Observable<Series> getSeriesInfo(@Query("t") String title);

    // Using query for valid imdb ID for each episode
    @GET("?apikey=" + API_KEY)
    Observable<EpisodeInfo> getEpisodeInfo(@Query("i") String imdbID);

}
