package com.example.registrationexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registrationexample.data.DataHolder;
import com.example.registrationexample.data.Mahasiswa;

public class HomeActivity extends AppCompatActivity {
    TextView tvWelcome, tvName, tvMail, tvGender, tvProvince;
    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvWelcome = findViewById(R.id.tvWelcome);
        tvName = findViewById(R.id.tvName);
        tvMail = findViewById(R.id.tvMail);
        tvGender = findViewById(R.id.tvGender);
        tvProvince = findViewById(R.id.tvProvince);
        btnChange = findViewById(R.id.btnEdit);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        final String mail = intent.getStringExtra("mail");
        String gender = intent.getStringExtra("gender");
        String province = intent.getStringExtra("province");

        tvWelcome.setText("Selamat datang, "+name);
        tvName.setText(name);
        tvMail.setText(mail);
        tvGender.setText(gender);
        tvProvince.setText(province);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent change = new Intent(HomeActivity.this, UbahDataActivity.class);
                Mahasiswa student = DataHolder.getByEmail(mail);
                change.putExtra("name", student.getName());
                change.putExtra("mail", student.getEmail());
                change.putExtra("username", student.getUsername());
                change.putExtra("password", student.getPassword());
                change.putExtra("gender", student.getGender());
                change.putExtra("province", student.getProvince());
                startActivity(change);
            }
        });
    }
}
