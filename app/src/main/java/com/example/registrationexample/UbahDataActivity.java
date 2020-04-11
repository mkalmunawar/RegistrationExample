package com.example.registrationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.registrationexample.data.DataHolder;
import com.example.registrationexample.data.Mahasiswa;

public class UbahDataActivity extends AppCompatActivity {

    EditText etName, etMail, etPassword, etUsername;
    RadioGroup rgGender;
    Spinner sProvince;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_data);
        etName = findViewById(R.id.etName);
        etUsername = findViewById(R.id.etUsername);
        etMail = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPassword);
        rgGender = findViewById(R.id.rgGender);
        sProvince = findViewById(R.id.sProvince);
        btnSave = findViewById(R.id.btnSave);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String mail = intent.getStringExtra("mail");
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");

        etName.setText(name);
        etMail.setText(mail);
        etUsername.setText(username);
        etPassword.setText(password);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioButton = findViewById(rgGender.getCheckedRadioButtonId());
                String gender = radioButton.getText().toString();

                Mahasiswa student = new Mahasiswa();
                student.setName(etName.getText().toString());
                student.setEmail(etMail.getText().toString());
                student.setPassword(etPassword.getText().toString());
                student.setGender(gender);
                student.setProvince(sProvince.getSelectedItem().toString());

                DataHolder.editStudentByUsername(student, etUsername.getText().toString());
                Toast.makeText(UbahDataActivity.this, "Data Berhasil Diubah!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
