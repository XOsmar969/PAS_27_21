package com.example.pas_21_27;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private TextView tvNama, tvNis, tvKelas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Inisialisasi TextView
        tvNama = view.findViewById(R.id.tvNama);
        tvNis = view.findViewById(R.id.tvNis);
        tvKelas = view.findViewById(R.id.tvKelas);

        // Data diri statis (kamu bisa ubah isinya sesuai dirimu)
        UserProfile user = new UserProfile("Osmar Ghalib Albani", "123456", "X PPLG 1");

        // Tampilkan ke TextView
        tvNama.setText("Nama: " + user.getNama());
        tvNis.setText("NIS: " + user.getNis());
        tvKelas.setText("Kelas: " + user.getKelas());

        return view;
    }
}
