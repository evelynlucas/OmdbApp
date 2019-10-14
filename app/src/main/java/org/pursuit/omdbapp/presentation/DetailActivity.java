package org.pursuit.omdbapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import org.pursuit.omdbapp.R;
import org.pursuit.omdbapp.models.EpisodeInfo;
import org.pursuit.omdbapp.rv.EpisodeViewHolder;


/*
DetailActivity created to receive intent from EpisodeViewHolder for
each itemview's Episode
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView detailImageView = findViewById(R.id.detail_imageview);
        TextView detailTitleTextView = findViewById(R.id.detail_title_textview);
        TextView detailDirectorTextView = findViewById(R.id.detail_director_textview);
        TextView detailWriterTextView = findViewById(R.id.detail_writer_textview);
        TextView detailPlotTextView = findViewById(R.id.detail_plot_textview);

        Intent intent = getIntent();
        EpisodeInfo episodeInfo = (EpisodeInfo) intent.getSerializableExtra(EpisodeViewHolder.EPISODE_KEY);

        Picasso.get()
                .load(episodeInfo.getPoster())
                .into(detailImageView);

        detailTitleTextView.setText(getString(R.string.title_string, episodeInfo.getTitle()));
        detailDirectorTextView.setText(getString(R.string.director_string, episodeInfo.getDirector()));
        detailWriterTextView.setText(getString(R.string.writer_string, episodeInfo.getWriter()));
        detailPlotTextView.setText(getString(R.string.plot_string, episodeInfo.getPlot()));

    }
}
