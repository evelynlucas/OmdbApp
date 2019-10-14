package org.pursuit.omdbapp.presentation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.pursuit.omdbapp.R;
import org.pursuit.omdbapp.data.DataConversion;
import org.pursuit.omdbapp.models.EpisodeInfo;
import org.pursuit.omdbapp.network.OmdbApi;
import org.pursuit.omdbapp.network.OmdbRetrofit;
import org.pursuit.omdbapp.rv.EpisodeAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter presenter;
    private static List<EpisodeInfo> officeEpisodesList;
    private static List<EpisodeInfo> parksEpisodesList;
    private static List<EpisodeInfo> goodPlaceEpisodesList;
    private static EpisodeAdapter officeAdapter;
    private static EpisodeAdapter parksAdapter;
    private static EpisodeAdapter goodPlaceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final OmdbApi api = OmdbRetrofit.getOmdbRetrofit()
                .create(OmdbApi.class);

        presenter = new MainPresenter(this, api);
        presenter.getOfficeEpisodes();
        presenter.getParksEpisodes();
        presenter.getGoodPlaceEpisodes();
    }


    @Override
    public void showOfficeEpisodes(List<EpisodeInfo> list) {
        officeEpisodesList = list;
        RecyclerView officeRecyclerView = findViewById(R.id.recyclerview_office);
        officeRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        officeAdapter = new EpisodeAdapter(list);
        officeRecyclerView.setAdapter(officeAdapter);
    }

    @Override
    public void showParksEpisodes(List<EpisodeInfo> list) {
        parksEpisodesList = list;
        RecyclerView parksRecyclerView = findViewById(R.id.recyclerview_parks);
        parksRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        parksAdapter = new EpisodeAdapter(list);
        parksRecyclerView.setAdapter(parksAdapter);
    }

    @Override
    public void showGoodPlaceEpisodes(List<EpisodeInfo> list) {
        goodPlaceEpisodesList = list;
        RecyclerView goodPlaceRecyclerView = findViewById(R.id.recyclerview_goodplace);
        goodPlaceRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        goodPlaceAdapter = new EpisodeAdapter(list);
        goodPlaceRecyclerView.setAdapter(goodPlaceAdapter);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_by_rating:
                sortByRating();
                return true;
            case R.id.sort_by_title:
                sortByTitle();
                return true;
            case R.id.sort_by_episode_number:
                sortByEpisodeNumber();
                return true;
            default:
                sortByEpisodeNumber();
        }
        return super.onOptionsItemSelected(item);
    }

    private static void sortByTitle() {
        DataConversion.sortByTitle(officeEpisodesList);
        DataConversion.sortByTitle(parksEpisodesList);
        DataConversion.sortByTitle(goodPlaceEpisodesList);

        officeAdapter.setData(officeEpisodesList);
        parksAdapter.setData(parksEpisodesList);
        goodPlaceAdapter.setData(goodPlaceEpisodesList);
    }

    private static void sortByRating() {
        DataConversion.sortByRating(officeEpisodesList);
        DataConversion.sortByRating(parksEpisodesList);
        DataConversion.sortByRating(goodPlaceEpisodesList);

        officeAdapter.setData(officeEpisodesList);
        parksAdapter.setData(parksEpisodesList);
        goodPlaceAdapter.setData(goodPlaceEpisodesList);
    }

    private static void sortByEpisodeNumber() {
        DataConversion.sortByEpisodeNumber(officeEpisodesList);
        DataConversion.sortByEpisodeNumber(parksEpisodesList);
        DataConversion.sortByEpisodeNumber(goodPlaceEpisodesList);

        officeAdapter.setData(officeEpisodesList);
        parksAdapter.setData(parksEpisodesList);
        goodPlaceAdapter.setData(goodPlaceEpisodesList);
    }
}
