package com.example.dani.PokeAPP.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dani.PokeAPP.R;
import com.example.dani.PokeAPP.RankingViewHolder;
import com.example.dani.PokeAPP.model.Ranking;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RankingActivity extends AppCompatActivity {

    public static final String RANKING_REFERENCE = "Ranking";
    public DatabaseReference mReference;
    public FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        setupComponents();
    }

    private void setupComponents() {
        mReference = FirebaseDatabase.getInstance().getReference();
        mUser = FirebaseAuth.getInstance().getCurrentUser();

        FirebaseRecyclerOptions<Ranking> options = new FirebaseRecyclerOptions.Builder<Ranking>()
                .setIndexedQuery(mReference.child(RANKING_REFERENCE).orderByChild("score").limitToFirst(10),
                        mReference.child(RANKING_REFERENCE), Ranking.class)
                .setLifecycleOwner(this)
                .build();

        RecyclerView recyclerView = findViewById(R.id.rankingList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new FirebaseRecyclerAdapter<Ranking, RankingViewHolder>(options) {
            @NonNull
            @Override
            public RankingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ranking, parent, false);

                return new RankingViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull RankingViewHolder holder, int position, @NonNull Ranking ranking) {


                holder.name.setText("Name: " + ranking.getName());
                holder.score.setText("Score: " + ranking.getScore());

            }
        });
    }
}
