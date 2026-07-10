package com.ubl.uas_jaler.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.ubl.uas_jaler.R;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText etNickname, etEmail, etPhone;
    private MaterialButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etNickname = findViewById(R.id.etNickname);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> validateLogin());
    }

    private void validateLogin() {

        String nickname = etNickname.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();

        if (nickname.isEmpty()) {
            etNickname.setError("Nickname wajib diisi");
            etNickname.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            etEmail.setError("Email wajib diisi");
            etEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Format email tidak valid");
            etEmail.requestFocus();
            return;
        }

        if (phone.isEmpty()) {
            etPhone.setError("Nomor telepon wajib diisi");
            etPhone.requestFocus();
            return;
        }

        if (phone.length() < 10) {
            etPhone.setError("Nomor telepon minimal 10 digit");
            etPhone.requestFocus();
            return;
        }

        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}