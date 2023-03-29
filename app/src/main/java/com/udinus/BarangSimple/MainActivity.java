package com.udinus.BarangSimple;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    private ArrayList<ModelBarang> barangArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mengubah judul yang ada pada App Bar
        Objects.requireNonNull(getSupportActionBar()).setTitle("Daftar Barang");

        databaseHelper = new DatabaseHelper(this);

        RecyclerView rvBarang = findViewById(R.id.rv_barang);
        rvBarang.setHasFixedSize(true);

        // Mengatur LayoutManager pada RecycleView Barang dengan LinearLayoutManager
        rvBarang.setLayoutManager(new LinearLayoutManager(this));
        barangArrayList.clear();
        barangArrayList = databaseHelper.getAllModelBarangs();
        // Deklarasi Adapter RecyclerView Barang
        BarangRecyclerViewAdapter barangRecyclerViewAdapter = new BarangRecyclerViewAdapter(barangArrayList);
        // Menghubungkan RecyclerView dengan Adapter diatas.
        rvBarang.setAdapter(barangRecyclerViewAdapter);



        // Tombol/Button yang melayang untuk navigasi ke EntryPage/Halaman Input Barang
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, EntryBarang.class);
            startActivity(intent);
        });
    }
}