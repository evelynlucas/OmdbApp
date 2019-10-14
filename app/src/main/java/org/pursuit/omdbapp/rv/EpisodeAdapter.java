package org.pursuit.omdbapp.rv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.pursuit.omdbapp.R;
import org.pursuit.omdbapp.models.EpisodeInfo;

import java.util.List;

// Adapter for setting appropriate data to RecyclerView viewholder
public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeViewHolder> {

    private List<EpisodeInfo> episodeList;

    public EpisodeAdapter(List<EpisodeInfo> episodeList) {
        this.episodeList = episodeList;
    }


    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new EpisodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        holder.onBind(episodeList.get(position));
    }

    @Override
    public int getItemCount() {
        return episodeList.size();
    }

    public void setData(List<EpisodeInfo> list) {
        this.episodeList = list;
        notifyDataSetChanged();
    }
}
