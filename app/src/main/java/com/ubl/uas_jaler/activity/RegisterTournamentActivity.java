package com.ubl.uas_jaler.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.ubl.uas_jaler.R;

public class RegisterTournamentActivity extends AppCompatActivity {

    private TextView txtSelectedTournament;

    private TextInputEditText etTeamName;
    private TextInputEditText etInstitution;

    private TextInputEditText etPlayer1, etPlayer2, etPlayer3, etPlayer4, etPlayer5;
    private TextInputEditText etGameId1, etGameId2, etGameId3, etGameId4, etGameId5;

    private MaterialButton btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_tournament);

        txtSelectedTournament = findViewById(R.id.txtSelectedTournament);

        etTeamName = findViewById(R.id.etTeamName);
        etInstitution = findViewById(R.id.etInstitution);

        etPlayer1 = findViewById(R.id.etPlayer1);
        etPlayer2 = findViewById(R.id.etPlayer2);
        etPlayer3 = findViewById(R.id.etPlayer3);
        etPlayer4 = findViewById(R.id.etPlayer4);
        etPlayer5 = findViewById(R.id.etPlayer5);

        etGameId1 = findViewById(R.id.etGameId1);
        etGameId2 = findViewById(R.id.etGameId2);
        etGameId3 = findViewById(R.id.etGameId3);
        etGameId4 = findViewById(R.id.etGameId4);
        etGameId5 = findViewById(R.id.etGameId5);

        btnRegister = findViewById(R.id.btnRegister);

        String namaTournament =
                getIntent().getStringExtra("nama");

        txtSelectedTournament.setText(namaTournament);

        btnRegister.setOnClickListener(v -> {
            String teamName = etTeamName.getText().toString().trim();
            String institution = etInstitution.getText().toString().trim();

            String player1 = etPlayer1.getText().toString().trim();
            String player2 = etPlayer2.getText().toString().trim();
            String player3 = etPlayer3.getText().toString().trim();
            String player4 = etPlayer4.getText().toString().trim();
            String player5 = etPlayer5.getText().toString().trim();

            String gameId1 = etGameId1.getText().toString().trim();
            String gameId2 = etGameId2.getText().toString().trim();
            String gameId3 = etGameId3.getText().toString().trim();
            String gameId4 = etGameId4.getText().toString().trim();
            String gameId5 = etGameId5.getText().toString().trim();

            if(etTeamName.getText().toString().trim().isEmpty()){

                etTeamName.setError("Nama Team wajib diisi");

                return;

            }

            if(etInstitution.getText().toString().trim().isEmpty()){

                etInstitution.setError("Asal Instansi wajib diisi");

                return;

            }

            if(etPlayer1.getText().toString().trim().isEmpty()){

                etPlayer1.setError("Player 1 wajib diisi");

                return;

            }

            if(etGameId1.getText().toString().trim().isEmpty()){

                etGameId1.setError("Game ID wajib diisi");

                return;

            }

            Toast.makeText(this, "Team Name : " + teamName + "\n" +
                    "Pendaftaran Berhasil",
                    Toast.LENGTH_SHORT).show();

        });
        Intent intent = new Intent(
                RegisterTournamentActivity.this,
                MyRegistrationActivity.class
        );

        startActivity(intent);
        getIntent().getBooleanExtra(
                "edit_mode",
                false
        );

    }

}