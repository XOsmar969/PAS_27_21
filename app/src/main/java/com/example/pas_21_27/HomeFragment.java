package com.example.pas_21_27;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private TeamAdapter adapter;
    private List<Team> teamList;
    private ProgressBar progressBar;
    private BottomNavigationView bottomNavigationView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.rvTeams);
        progressBar = view.findViewById(R.id.progressBar);
        bottomNavigationView = view.findViewById(R.id.bottomNavigationView);

        // Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        teamList = new ArrayList<>();
        adapter = new TeamAdapter(teamList);
        recyclerView.setAdapter(adapter);

        loadTeams();

        // BottomNavigationView listener (jika mau buat aksi)
        bottomNavigationView.setOnItemSelectedListener(item -> {
            // handle menu item clicks di sini, contoh:
            switch (item.getItemId()) {
                case R.id.home_fragment:
                    // sudah di home, mungkin reload data
                    loadTeams();
                    return true;
                case R.id.menu_profile:
                    // navigasi ke profil atau apa saja
                    return true;
                case R.id.menu_settings:
                    // navigasi ke settings
                    return true;
                default:
                    return false;
            }
        });

        return view;
    }

    private void loadTeams() {
        // Simulasi load data, misalnya bisa dari API, database, atau static list
        progressBar.setVisibility(View.VISIBLE);

        // Clear dulu list sebelum diisi ulang
        teamList.clear();

        // Contoh data static dengan logo drawable dan nama
        teamList.add(new Team("Liga Inggris", R.drawable.logo_liga_inggris));
        teamList.add(new Team("Liga Spanyol", R.drawable.logo_liga_spanyol));
        teamList.add(new Team("Liga Italia", R.drawable.logo_liga_italia));
        teamList.add(new Team("Liga Jerman", R.drawable.logo_liga_jerman));

        // Setelah data masuk ke list, kasih notify ke adapter
        adapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }
}
