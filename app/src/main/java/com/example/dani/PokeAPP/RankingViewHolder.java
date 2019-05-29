package com.example.dani.PokeAPP;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;



public class RankingViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView score;


    public RankingViewHolder(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.rankingName);
        score = itemView.findViewById(R.id.rankingScore);


    }
}
