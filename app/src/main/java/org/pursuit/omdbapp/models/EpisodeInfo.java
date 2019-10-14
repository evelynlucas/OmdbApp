package org.pursuit.omdbapp.models;

import java.io.Serializable;

//Class created for each episode information needed. Implements Serializable to pass object to detail activity
public class EpisodeInfo implements Serializable {

    private String Title;
    private String Director;
    private String Writer;
    private String Plot;
    private String Poster;
    private String imdbRating;
    private String Episode;

    //Constructor with three parameters created for testing JUnit tests
    public EpisodeInfo(String title, String imdbRating, String episode) {
        Title = title;
        this.imdbRating = imdbRating;
        Episode = episode;
    }

    public String getTitle() {
        return Title;
    }

    public String getDirector() {
        return Director;
    }

    public String getWriter() {
        return Writer;
    }

    public String getPlot() {
        return Plot;
    }

    public String getPoster() {
        return Poster;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getEpisode() {
        return Episode;
    }

    public double getRating() {
        return Double.parseDouble(getImdbRating());
    }

    public int getEpisodeNumber() {
        return Integer.parseInt(getEpisode());
    }

}
