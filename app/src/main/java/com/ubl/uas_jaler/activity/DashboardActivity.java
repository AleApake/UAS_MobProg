package com.ubl.uas_jaler.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ubl.uas_jaler.R;
import com.ubl.uas_jaler.adapter.TournamentAdapter;
import com.ubl.uas_jaler.api.ApiClient;
import com.ubl.uas_jaler.api.ApiService;
import com.ubl.uas_jaler.model.ApiResponse;
import com.ubl.uas_jaler.model.Tournament;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView rvTournament;
    private ArrayList<Tournament> tournamentList;
    private TournamentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Inisialisasi RecyclerView
        rvTournament = findViewById(R.id.rvTournament);

        // RecyclerView menggunakan LinearLayout
        rvTournament.setLayoutManager(new LinearLayoutManager(this));

        // ArrayList untuk menampung data tournament
        tournamentList = new ArrayList<>();

        ApiService apiService =
                ApiClient.getClient().create(ApiService.class);

        apiService.registerTeam(
                userId,
                tournamentId,

                etTeamName.getText().toString(),
                etInstitution.getText().toString(),

                etPlayer1.getText().toString(),
                etPlayer2.getText().toString(),
                etPlayer3.getText().toString(),
                etPlayer4.getText().toString(),
                etPlayer5.getText().toString(),

                etGameId1.getText().toString(),
                etGameId2.getText().toString(),
                etGameId3.getText().toString(),
                etGameId4.getText().toString(),
                etGameId5.getText().toString()

        ).enqueue(new Callback<ApiResponse>() {

            @Override
            public void onResponse(Call<ApiResponse> call,
                                   Response<ApiResponse> response) {

                Toast.makeText(
                        RegisterTournamentActivity.this,
                        response.body().getMessage(),
                        Toast.LENGTH_SHORT
                ).show();

            }

            @Override
            public void onFailure(Call<ApiResponse> call,
                                  Throwable t) {

                Toast.makeText(
                        RegisterTournamentActivity.this,
                        t.getMessage(),
                        Toast.LENGTH_SHORT
                ).show();

            }

        });

        apiService.getTournament().enqueue(new Callback<List<Tournament>>() {

            @Override
            public void onResponse(Call<List<Tournament>> call,
                                   Response<List<Tournament>> response) {

                if(response.isSuccessful()){

                    tournamentList.clear();
                    tournamentList.addAll(response.body());

                    adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Call<List<Tournament>> call, Throwable t) {

                Toast.makeText(DashboardActivity.this,
                        t.getMessage(),
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Adapter
        adapter = new TournamentAdapter(this, tournamentList);

        // Hubungkan Adapter ke RecyclerView
        rvTournament.setAdapter(adapter);

    }
}