package com.example.pas_21_27;

public class UserProfile {
    private String nama;
    private String nis;
    private String kelas;

    public UserProfile(String nama, String nis, String kelas) {
        this.nama = nama;
        this.nis = nis;
        this.kelas = kelas;
    }

    public String getNama() {
        return nama;
    }

    public String getNis() {
        return nis;
    }

    public String getKelas() {
        return kelas;
    }
}
