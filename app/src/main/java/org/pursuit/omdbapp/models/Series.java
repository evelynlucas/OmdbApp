package org.pursuit.omdbapp.models;

import java.util.List;

//Series Model created to obtain list of Episodes and their imdb ID's
public class Series {

    private String Title;
    private String Season;
    private List<Episode> Episodes;

    public String getTitle() {
        return Title;
    }

    public String getSeason() {
        return Season;
    }

    public List<Episode> getEpisodes() {
        return Episodes;
    }

    public class Episode {

        private String Title;
        private String Episode;
        private String imdbID;

        public String getTitle() {
            return Title;
        }

        public String getEpisode() {
            return Episode;
        }

        public String getImdbID() {
            return imdbID;
        }
    }
}
