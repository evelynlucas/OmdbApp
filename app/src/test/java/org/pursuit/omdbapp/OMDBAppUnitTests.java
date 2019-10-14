package org.pursuit.omdbapp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.pursuit.omdbapp.data.DataConversion;
import org.pursuit.omdbapp.models.EpisodeInfo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class OMDBAppUnitTests {

    List<EpisodeInfo> episodeInfoList;
    EpisodeInfo episodeA = new EpisodeInfo("A Day", "9.0", "3");
    EpisodeInfo episodeB = new EpisodeInfo("B Day", "3.0", "2");
    EpisodeInfo episodeC = new EpisodeInfo("C Day", "6.0", "7");

    @Before
    public void setUp() {
        episodeInfoList = new ArrayList<>();
        episodeInfoList.add(episodeB);
        episodeInfoList.add(episodeA);
        episodeInfoList.add(episodeC);

    }

    // Deposit_ShouldIncreaseBalance_WhenGivenPositiveValue
    @Test
    public void EpisodeInfoList_ShouldBeSortedByTitle_WhenGivenNonEmptyList() {

        List<EpisodeInfo> expectedList = new ArrayList<>();
        expectedList.add(episodeA);
        expectedList.add(episodeB);
        expectedList.add(episodeC);
        DataConversion.sortByTitle(episodeInfoList);

        Assert.assertEquals(expectedList, episodeInfoList);
    }

    @Test
    public void EpisodeInfoList_ShouldBeSortedByEpisodeNumber_WhenGivenNonEmptyList() {

        List<EpisodeInfo> expectedList = new ArrayList<>();
        expectedList.add(episodeB);
        expectedList.add(episodeA);
        expectedList.add(episodeC);
        DataConversion.sortByEpisodeNumber(episodeInfoList);

        Assert.assertEquals(expectedList, episodeInfoList);
    }

    @Test
    public void EpisodeInfoList_ShouldBeSortedByHighestRating_WhenGivenNonEmptyList() {

        List<EpisodeInfo> expectedList = new ArrayList<>();
        expectedList.add(episodeA);
        expectedList.add(episodeC);
        expectedList.add(episodeB);
        DataConversion.sortByRating(episodeInfoList);

        Assert.assertEquals(expectedList, episodeInfoList);
    }

    @Test
    public void StringTitle_ShouldBeShortened_WhenTitleLengthIsGreaterThan15Characters() {
        String episodeTitle = "This is A Very Long Title To Be Tested By Algorithm";
        String expectedTitle = "This is A Ver...";
        episodeTitle = DataConversion.titleAdjuster(episodeTitle);
        Assert.assertEquals(expectedTitle, episodeTitle);
    }

    @Test
    public void StringTitle_ShouldRemainSame_WhenTitleLengthIsLessThan15Characters() {
        String episodeTitle = "New Title";
        String expectedTitle = "New Title";
        episodeTitle = DataConversion.titleAdjuster(episodeTitle);
        Assert.assertEquals(expectedTitle, episodeTitle);
    }

    @After
    public void breakDown() {
        episodeInfoList = null;
    }

}