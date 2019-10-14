package org.pursuit.omdbapp.presentation;

import org.pursuit.omdbapp.models.EpisodeInfo;

import java.util.List;

// Main Contract interface for MVP architecture. View interface methods will be implemented by Activity
// and Presenter methods will be implemented for MainPresenter
public interface MainContract {

    interface View {
        void showOfficeEpisodes(List<EpisodeInfo> list);

        void showParksEpisodes(List<EpisodeInfo> list);

        void showGoodPlaceEpisodes(List<EpisodeInfo> list);

        void showError();
    }

    interface Presenter{
        void getOfficeEpisodes();

        void getParksEpisodes();

        void getGoodPlaceEpisodes();
    }
}
