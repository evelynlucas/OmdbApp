package org.pursuit.omdbapp.rv;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.pursuit.omdbapp.R;
import org.pursuit.omdbapp.data.DataConversion;
import org.pursuit.omdbapp.models.EpisodeInfo;
import org.pursuit.omdbapp.presentation.DetailActivity;

// ItemView implementation for the RecyclerView
public class EpisodeViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView textView;
    public static final String EPISODE_KEY = "episode_key";


    public EpisodeViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.itemview_episode_image);
        textView = itemView.findViewById(R.id.itemview_episode_title);
    }

    public void onBind(final EpisodeInfo episode) {
        textView.setText(DataConversion.titleAdjuster(episode.getTitle()));

        // Using Picasso library for easy resizing and placeholder method for no network
        Picasso.get()
                .load(episode.getPoster())
                .placeholder(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .resize(120, 120)
                .into(imageView);

        // Passes the serializable episode info through an intent
        itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetailActivity.class);
            intent.putExtra(EPISODE_KEY, episode);
            v.getContext().startActivity(intent);
        });
    }

}
