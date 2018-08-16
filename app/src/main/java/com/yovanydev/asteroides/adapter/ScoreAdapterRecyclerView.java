package com.yovanydev.asteroides.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yovanydev.asteroides.R;

import java.util.Vector;

public class ScoreAdapterRecyclerView extends RecyclerView.Adapter<ScoreAdapterRecyclerView.ScoreViewHolder>{

    private final Vector<String> scores;
    private final Activity activity;
    private final int resource;

    public ScoreAdapterRecyclerView(Vector<String> scores, Activity activity, int resource) {
        this.scores = scores;
        this.activity = activity;
        this.resource = resource;
    }

    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ScoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {
        String score = scores.elementAt(position);
        String[] elments = score.split("-");

        Picasso.get().load(R.drawable.rocket).into(holder.ivScorePicture);
        holder.tvGamerName.setText(elments[1]);
        holder.tvScoreValue.setText(elments[0]);
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }

    class ScoreViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivScorePicture;
        private TextView tvGamerName;
        private TextView tvScoreValue;

        public ScoreViewHolder(View itemView) {
            super(itemView);

            ivScorePicture = itemView.findViewById(R.id.ivScorePicture);
            tvGamerName = itemView.findViewById(R.id.tvGamerName);
            tvScoreValue = itemView.findViewById(R.id.tvScoreValue);
        }
    }
}
