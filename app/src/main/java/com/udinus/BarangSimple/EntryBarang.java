package com.udinus.BarangSimple;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.UUID;

public class EntryBarang extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    EditText edtKode, edtNama, edtSatuan, edtHarga;

    Button btnSimpan, btnBatal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_barang);

        // Mengubah judul yang ada pada App Bar
        Objects.requireNonNull(getSupportActionBar()).setTitle("Menambahkan Data Barang");

        databaseHelper = new DatabaseHelper(this);

        edtKode = findViewById(R.id.edt_kode);
        UUID uuid = UUID.randomUUID();
        String randomUUID8Char = uuid.toString().replaceAll("-", "").substring(0, 8);
        edtKode.setText(randomUUID8Char);

        edtNama = findViewById(R.id.edt_nama);
        edtSatuan = findViewById(R.id.edt_satuan);
        edtHarga = findViewById(R.id.edt_harga);

        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(view -> insertBarang());

        btnBatal = findViewById(R.id.btn_batal);
        btnBatal.setOnClickListener(view -> batal());
    }

    private void insertBarang() {
        // Membuat obyek barang/ModelBarang
        ModelBarang barang = new ModelBarang();

        // Set/Input/Masukan nilai ke obyek barang/ModelBarang
        barang.setKode(edtKode.getText().toString());
        barang.setNama(edtNama.getText().toString());
        barang.setSatuan(edtSatuan.getText().toString());
        barang.setHarga(Double.valueOf(edtHarga.getText().toString()));

        // insert obyek barang yang sudah ada nilainya diatas ke database
        databaseHelper.insertBarang(barang);

        // Pindah dari halaman EntryBarang/InputBarang ke MainActivity/DaftarBarang
        Intent intent = new Intent(EntryBarang.this, MainActivity.class);
        startActivity(intent);
    }

    private void batal() {
        // Pindah dari halaman EntryBarang/InputBarang ke MainActivity/DaftarBarang
        Intent intent = new Intent(EntryBarang.this, MainActivity.class);
        startActivity(intent);
    }
}