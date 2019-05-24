package com.example.dani.dgonzalezapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dani.dgonzalezapp.model.Ranking;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class RankingViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView score;

    public RankingViewHolder(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.rankingName);
        score = itemView.findViewById(R.id.rankingScore);




        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Ranking>()
                .setIndexedQuery(
                        FirebaseDatabase.getInstance().getReference().child("Rankings/ranking"),
                        FirebaseDatabase.getInstance().getReference().child("posts/data"),
                        Ranking.class)
                .setLifecycleOwner(this)
                .build();



        FirebaseRecyclerAdapter firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Ranking, RankingViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull RankingViewHolder viewholder, int position, Ranking ranking) {

            }

            @Override
            public RankingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_ranking, parent, false);

                return new RankingViewHolder(view);
            }
        };
    }
}
