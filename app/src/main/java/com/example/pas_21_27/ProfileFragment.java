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
    private TextView tvNama2, tvNis2, tvKelas2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        tvNama = view.findViewById(R.id.tvNama);
        tvNis = view.findViewById(R.id.tvNis);
        tvKelas = view.findViewById(R.id.tvKelas);

        tvNama2 = view.findViewById(R.id.tvNama2);
        tvNis2 = view.findViewById(R.id.tvNis2);
        tvKelas2 = view.findViewById(R.id.tvKelas2);


        UserProfile user1 = new UserProfile("Osmar Ghalib Albani", "123456", "X PPLG 1");


        UserProfile user2 = new UserProfile("L", "789012", "X PPLG 1");


        tvNama.setText("Nama: " + user1.getNama());
        tvNis.setText("NIS: " + user1.getNis());
        tvKelas.setText("Kelas: " + user1.getKelas());

        tvNama2.setText("Nama: " + user2.getNama());
        tvNis2.setText("NIS: " + user2.getNis());
        tvKelas2.setText("Kelas: " + user2.getKelas());

        return view;
    }
}

