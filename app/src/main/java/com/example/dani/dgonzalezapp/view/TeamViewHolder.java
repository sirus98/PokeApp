package com.example.dani.dgonzalezapp.view;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dani.dgonzalezapp.R;


public class TeamViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public ImageView img1;
    public ImageView img2;
    public ImageView img3;
    public ImageView img4;
    public ImageView img5;
    public ImageView img6;


    public TeamViewHolder(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.rankingName);
        img1 = itemView.findViewById(R.id.img1);
        img2 = itemView.findViewById(R.id.img2);
        img3 = itemView.findViewById(R.id.img3);
        img4 = itemView.findViewById(R.id.img4);
        img5 = itemView.findViewById(R.id.img5);
        img6 = itemView.findViewById(R.id.img6);

    }
}
