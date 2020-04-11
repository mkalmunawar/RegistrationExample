package com.example.registrationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.registrationexample.data.DataHolder;
import com.example.registrationexample.data.Mahasiswa;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DataHolder.initData();
        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);

        findViewById(R.id.tvRegistration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sUsername = username.getText().toString();
                String sPassword = password.getText().toString();

                if (sUsername.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Username tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (sPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else {
                    Mahasiswa student = DataHolder.getByUsername(sUsername);
                    if (student != null) {
                        if (student.getPassword().equals(sPassword)) {
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            intent.putExtra("name", student.getName());
                            intent.putExtra("mail", student.getEmail());
                            intent.putExtra("gender", student.getGender());
                            intent.putExtra("province", student.getProvince());

                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Password tidak valid!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Mahasiswa tidak terdaftar!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
