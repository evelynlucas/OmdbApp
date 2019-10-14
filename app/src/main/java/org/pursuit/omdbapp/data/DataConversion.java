package org.pursuit.omdbapp.data;

import org.pursuit.omdbapp.models.EpisodeInfo;

import java.util.Collections;
import java.util.List;

public class DataConversion {

    public static void sortByTitle(List<EpisodeInfo> episodeInfoList) {
        Collections.sort(episodeInfoList, (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
    }

    public static void sortByRating(List<EpisodeInfo> episodeInfoList) {
        Collections.sort(episodeInfoList, (o1, o2) -> {
            if(o1.getRating() == o2.getRating())
                return 0;
            return o1.getRating() > o2.getRating() ? -1 : 1;
        });
    }

    public static void sortByEpisodeNumber(List<EpisodeInfo> episodeInfoList) {
        Collections.sort(episodeInfoList, (o1, o2) -> {
            if(o1.getEpisodeNumber() == o2.getEpisodeNumber())
                return 0;
            return o1.getEpisodeNumber() < o2.getEpisodeNumber() ? -1 : 1;
        });
    }

    public static String titleAdjuster(String string) {
        if (string.length() > 15) {
            return string.substring(0, 13) + "...";
        } else {
            return string;
        }
    }
}
