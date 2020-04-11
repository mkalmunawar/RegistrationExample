package com.example.registrationexample.data;

import java.sql.Struct;
import java.util.ArrayList;

public class DataHolder {
    public static ArrayList<Mahasiswa> students = new ArrayList<>();

    public static void initData() {
        Mahasiswa student = new Mahasiswa();
        student.setName("Minatozaki Sana");
        student.setEmail("Sana@jyp.kr");
        student.setUsername("sana");
        student.setPassword("sana");
        student.setGender("perempuan");
        student.setProvince("Jawa Barat");
        students.add(student);
    }

    public static void addStudent(Mahasiswa student) {
        students.add(student);
    }

    // Ubah data berdasarkan username
    public static void editStudentByUsername(Mahasiswa student, String username){
        for (Mahasiswa m : students) {
            if (m.getUsername().equals(username)) {
                m.setName(student.getName());
                m.setEmail(student.getEmail());
                m.setPassword(student.getPassword());
                m.setGender(student.getGender());
                m.setProvince(student.getProvince());
            }
        }
    }

    public static Mahasiswa getByUsername(String username) {
        for (Mahasiswa m : students) {
            if (m.getUsername().equals(username)) {
                return m;
            }
        }
        return null;
    }

    //mencari username
    public static String getUsername(String username) {
        for (Mahasiswa m : students) {
            if (m.getUsername().equals(username)) {
                return m.getUsername();
            }
        }
        return null;
    }

    public static Mahasiswa getByEmail(String mail) {
        for (Mahasiswa m : students) {
            if (m.getEmail().equals(mail)) {
                return m;
            }
        }
        return null;
    }
}
