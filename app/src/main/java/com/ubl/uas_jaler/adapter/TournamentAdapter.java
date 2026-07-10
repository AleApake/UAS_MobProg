package com.ubl.uas_jaler.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ubl.uas_jaler.R;
import com.ubl.uas_jaler.activity.RegisterTournamentActivity;
import com.ubl.uas_jaler.model.Tournament;

import java.util.ArrayList;

public class TournamentAdapter extends RecyclerView.Adapter<TournamentAdapter.ViewHolder> {

    Context context;
    ArrayList<Tournament> tournamentList;

    public TournamentAdapter(Context context, ArrayList<Tournament> tournamentList) {
        this.context = context;
        this.tournamentList = tournamentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_tournament, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Tournament tournament = tournamentList.get(position);

        holder.txtNama.setText(tournament.getNama());
        holder.txtGame.setText("Game : " + tournament.getGame());
        holder.txtTanggal.setText("Tanggal : " + tournament.getTanggal());
        holder.imgTournament.setImageResource(tournament.getGambar());

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(context, RegisterTournamentActivity.class);

            intent.putExtra("id", tournament.getId());
            intent.putExtra("nama", tournament.getNama());
            intent.putExtra("game", tournament.getGame());

            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return tournamentList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgTournament;
        TextView txtNama;
        TextView txtGame;
        TextView txtTanggal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTournament = itemView.findViewById(R.id.imgTournament);
            txtNama = itemView.findViewById(R.id.txtTournamentName);
            txtGame = itemView.findViewById(R.id.txtGame);
            txtTanggal = itemView.findViewById(R.id.txtDate);

        }
    }

}