package org.pursuit.omdbapp.presentation;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.annotation.NonNull;

import org.pursuit.omdbapp.models.EpisodeInfo;
import org.pursuit.omdbapp.models.Series;
import org.pursuit.omdbapp.network.OmdbApi;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

// Class is created to override methods of Presenter. This is the information that acts as buffer
// between data and UI.
public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View view;
    private final OmdbApi api;
    private static final String TAG = "MainPresenterError";

    public MainPresenter(
            @NonNull final MainContract.View view,
            @NonNull final OmdbApi api) {
        this.view = view;
        this.api = api;
    }

    @Override
    public void getOfficeEpisodes() {
        networkCall("The Office");
    }

    @Override
    public void getParksEpisodes() {
        networkCall("Parks and recreation");
    }

    @Override
    public void getGoodPlaceEpisodes() {
        networkCall("Good Place");
    }

    // This method uses RxJava flatmapping to obtain imdb ID's from list and use them
    // for subsequent network calls to obtain each episode information. It moves these to a list and
    // ensure proper asynchronous network calls from Main Thread
    @SuppressLint("CheckResult")
    private void networkCall(String series) {
        api.getSeriesInfo(series)
                .flatMapIterable(Series::getEpisodes)
                .flatMap(secondResponse -> api.getEpisodeInfo(secondResponse.getImdbID()))
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> viewCaller(series, response), error -> {
                    Log.d(TAG, "ERROR: " + error.getMessage());
                    view.showError();
                });
    }

    private void viewCaller(String series, List<EpisodeInfo> response) {
        List<EpisodeInfo> episodeInfoList = new ArrayList<>();
        for (EpisodeInfo e : response) {
            episodeInfoList.add(e);
        }

        final boolean success = !episodeInfoList.isEmpty();

        if (success && series.equals("The Office")) {
            view.showOfficeEpisodes(response);
        } else if (success && series.equals("Parks and recreation")) {
            view.showParksEpisodes(response);
        } else if (success && series.equals("Good Place")) {
            view.showGoodPlaceEpisodes(response);
        } else {
            view.showError();
        }

    }

}
