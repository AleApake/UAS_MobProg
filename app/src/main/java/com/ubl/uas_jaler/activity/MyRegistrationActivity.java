package com.ubl.uas_jaler.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ubl.uas_jaler.R;
import com.ubl.uas_jaler.adapter.RegistrationAdapter;
import com.ubl.uas_jaler.api.ApiClient;
import com.ubl.uas_jaler.api.ApiService;
import com.ubl.uas_jaler.model.Registration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRegistrationActivity extends AppCompatActivity {

    private RecyclerView rvRegistration;
    private TextView tvEmpty;

    private RegistrationAdapter adapter;
    private List<Registration> registrationList;

    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_registration);

        rvRegistration = findViewById(R.id.rvRegistration);
        tvEmpty = findViewById(R.id.tvEmpty);

        rvRegistration.setLayoutManager(new LinearLayoutManager(this));

        registrationList = new ArrayList<>();

        adapter = new RegistrationAdapter(
                this,
                registrationList
        );

        rvRegistration.setAdapter(adapter);

        apiService = ApiClient
                .getClient()
                .create(ApiService.class);

        loadRegistration();
    }

    private void loadRegistration() {

        apiService.getRegistration()
                .enqueue(new Callback<List<Registration>>() {

                    @Override
                    public void onResponse(Call<List<Registration>> call,
                                           Response<List<Registration>> response) {

                        if (response.isSuccessful() && response.body() != null) {

                            registrationList.clear();

                            registrationList.addAll(response.body());

                            adapter.notifyDataSetChanged();

                            if (registrationList.isEmpty()) {

                                tvEmpty.setVisibility(View.VISIBLE);
                                rvRegistration.setVisibility(View.GONE);

                            } else {

                                tvEmpty.setVisibility(View.GONE);
                                rvRegistration.setVisibility(View.VISIBLE);

                            }

                        } else {

                            Toast.makeText(
                                    MyRegistrationActivity.this,
                                    "Data tidak ditemukan",
                                    Toast.LENGTH_SHORT
                            ).show();

                        }

                    }

                    @Override
                    public void onFailure(Call<List<Registration>> call,
                                          Throwable t) {

                        Toast.makeText(
                                MyRegistrationActivity.this,
                                t.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();

                    }

                });

    }

    @Override
    protected void onResume() {
        super.onResume();

        loadRegistration();
    }

}