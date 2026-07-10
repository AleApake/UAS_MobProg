package com.ubl.uas_jaler.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ubl.uas_jaler.R;
import com.ubl.uas_jaler.activity.RegisterTournamentActivity;
import com.ubl.uas_jaler.api.ApiClient;
import com.ubl.uas_jaler.api.ApiService;
import com.ubl.uas_jaler.model.ApiResponse;
import com.ubl.uas_jaler.model.Registration;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistrationAdapter
        extends RecyclerView.Adapter<RegistrationAdapter.ViewHolder> {


    private Context context;
    private List<Registration> registrationList;


    public RegistrationAdapter(Context context,
                               List<Registration> registrationList){

        this.context = context;
        this.registrationList = registrationList;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {


        View view = LayoutInflater
                .from(context)
                .inflate(
                        R.layout.item_registration,
                        parent,
                        false
                );


        return new ViewHolder(view);

    }



    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {


        Registration registration =
                registrationList.get(position);


        holder.tvTournamentName
                .setText(
                        "Tournament ID : "
                                + registration.getTournamentId()
                );


        holder.tvTeamName
                .setText(
                        "Team : "
                                + registration.getTeamName()
                );


        holder.tvInstitution
                .setText(
                        "Instansi : "
                                + registration.getInstitution()
                );


        holder.tvPlayers
                .setText(
                        "Player : "
                                + registration.getPlayer1()
                                + ", "
                                + registration.getPlayer2()
                                + ", "
                                + registration.getPlayer3()
                                + ", "
                                + registration.getPlayer4()
                                + ", "
                                + registration.getPlayer5()
                );



        // =====================
        // BUTTON EDIT
        // =====================

        holder.btnEdit.setOnClickListener(v -> {


            Intent intent =
                    new Intent(
                            context,
                            RegisterTournamentActivity.class
                    );


            intent.putExtra(
                    "edit_mode",
                    true
            );


            intent.putExtra(
                    "registration_id",
                    registration.getId()
            );


            intent.putExtra(
                    "team_name",
                    registration.getTeamName()
            );


            intent.putExtra(
                    "institution",
                    registration.getInstitution()
            );


            intent.putExtra(
                    "player1",
                    registration.getPlayer1()
            );

            intent.putExtra(
                    "player2",
                    registration.getPlayer2()
            );

            intent.putExtra(
                    "player3",
                    registration.getPlayer3()
            );

            intent.putExtra(
                    "player4",
                    registration.getPlayer4()
            );

            intent.putExtra(
                    "player5",
                    registration.getPlayer5()
            );


            intent.putExtra(
                    "gameid1",
                    registration.getGameId1()
            );

            intent.putExtra(
                    "gameid2",
                    registration.getGameId2()
            );

            intent.putExtra(
                    "gameid3",
                    registration.getGameId3()
            );

            intent.putExtra(
                    "gameid4",
                    registration.getGameId4()
            );

            intent.putExtra(
                    "gameid5",
                    registration.getGameId5()
            );


            context.startActivity(intent);


        });



        // =====================
        // BUTTON DELETE
        // =====================

        holder.btnDelete.setOnClickListener(v -> {


            new AlertDialog.Builder(context)

                    .setTitle("Hapus Pendaftaran")

                    .setMessage(
                            "Apakah Anda yakin ingin menghapus data ini?"
                    )

                    .setPositiveButton(
                            "Ya",
                            (dialog, which) -> {


                                deleteRegistration(
                                        registration.getId(),
                                        position
                                );


                            }
                    )

                    .setNegativeButton(
                            "Tidak",
                            null
                    )

                    .show();


        });


    }



    private void deleteRegistration(
            int id,
            int position){



        ApiService apiService =
                ApiClient
                        .getClient()
                        .create(ApiService.class);



        apiService.deleteRegistration(id)

                .enqueue(new Callback<ApiResponse>() {


                    @Override
                    public void onResponse(
                            Call<ApiResponse> call,
                            Response<ApiResponse> response) {


                        if(response.isSuccessful()
                                && response.body()!=null){


                            Toast.makeText(
                                    context,
                                    response.body().getMessage(),
                                    Toast.LENGTH_SHORT
                            ).show();


                            registrationList.remove(position);

                            notifyItemRemoved(position);


                        }


                    }


                    @Override
                    public void onFailure(
                            Call<ApiResponse> call,
                            Throwable t) {


                        Toast.makeText(
                                context,
                                t.getMessage(),
                                Toast.LENGTH_SHORT
                        ).show();


                    }


                });


    }



    @Override
    public int getItemCount(){

        return registrationList.size();

    }



    public class ViewHolder
            extends RecyclerView.ViewHolder{


        TextView tvTournamentName;
        TextView tvTeamName;
        TextView tvInstitution;
        TextView tvPlayers;

        Button btnEdit;
        Button btnDelete;



        public ViewHolder(
                @NonNull View itemView) {

            super(itemView);


            tvTournamentName =
                    itemView.findViewById(
                            R.id.tvTournamentName
                    );


            tvTeamName =
                    itemView.findViewById(
                            R.id.tvTeamName
                    );


            tvInstitution =
                    itemView.findViewById(
                            R.id.tvInstitution
                    );


            tvPlayers =
                    itemView.findViewById(
                            R.id.tvPlayers
                    );


            btnEdit =
                    itemView.findViewById(
                            R.id.btnEdit
                    );


            btnDelete =
                    itemView.findViewById(
                            R.id.btnDelete
                    );


        }

    }

}