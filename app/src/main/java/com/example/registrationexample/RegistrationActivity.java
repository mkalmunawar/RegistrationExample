package com.example.registrationexample;

import androidx.appcompat.app.AppCompatActivity;

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

public class RegistrationActivity extends AppCompatActivity {
    EditText etUsername, etPassword, etName, etMail;
    RadioGroup rgGender;
    Spinner sProvince;
    Button btnRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etName = findViewById(R.id.etName);
        etMail = findViewById(R.id.etMail);
        rgGender = findViewById(R.id.rgGender);
        sProvince = findViewById(R.id.sProvince);
        btnRegistration = findViewById(R.id.btnRegistration);

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String mail = etMail.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String gender = "";
                String province = sProvince.getSelectedItem().toString();
                RadioButton radioButton = findViewById(rgGender.getCheckedRadioButtonId());
                gender = radioButton.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (mail.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Email tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (username.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Username tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (gender.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Jenis Kelamin tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (province.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Provinsi tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else {
                    //Verifikasi username sama atau tidak
                    if (DataHolder.getUsername(username) != null) {
                        Toast.makeText(RegistrationActivity.this, "Username yang dibuat sudah ada!", Toast.LENGTH_SHORT).show();
                    } else {
                        Mahasiswa student = new Mahasiswa();
                        student.setName(name);
                        student.setEmail(mail);
                        student.setUsername(username);
                        student.setPassword(password);
                        student.setGender(gender);
                        student.setProvince(province);

                        DataHolder.addStudent(student);
                        Toast.makeText(RegistrationActivity.this, "Good Job!, Data Berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
