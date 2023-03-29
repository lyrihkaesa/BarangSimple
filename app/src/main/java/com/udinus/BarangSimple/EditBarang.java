package com.udinus.BarangSimple;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class EditBarang extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    TextView tvKode;
    EditText edtNama, edtSatuan, edtHarga;
    Button btnSimpan, btnBatal, btnHapus;

    ModelBarang barang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_barang);

        // Mengubah judul yang ada pada App Bar
        Objects.requireNonNull(getSupportActionBar()).setTitle("Mengubah Data Barang");

        // Mengambil data dari intent dengan ParcelableExtra
        barang = getIntent().getParcelableExtra("key_barang");

        databaseHelper = new DatabaseHelper(this);

        tvKode = findViewById(R.id.tv_kode);
        tvKode.setText(barang.getKode());

        edtNama = findViewById(R.id.edt_nama);
        edtNama.setText(barang.getNama());

        edtSatuan = findViewById(R.id.edt_satuan);
        edtSatuan.setText(barang.getSatuan());

        edtHarga = findViewById(R.id.edt_harga);
        edtHarga.setText(String.format(String.valueOf(barang.getHarga())));

        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(view -> editBarang());

        btnBatal = findViewById(R.id.btn_batal);
        btnBatal.setOnClickListener(view -> batal());

        btnHapus = findViewById(R.id.btn_hapus);
        btnHapus.setOnClickListener(view -> {
            AlertDialog diaBox = AskOption();
            diaBox.show();
        });
    }

    private void editBarang() {
        // Membuat obyek barang/ModelBarang
        ModelBarang barang = new ModelBarang();

        // Set/Input/Masukan nilai ke obyek barang/ModelBarang
        barang.setKode(tvKode.getText().toString());
        barang.setNama(edtNama.getText().toString());
        barang.setSatuan(edtSatuan.getText().toString());
        barang.setHarga(Double.valueOf(edtHarga.getText().toString()));

        // insert obyek barang yang sudah ada nilainya diatas ke database
        databaseHelper.updateBarang(barang);

        // Pindah dari halaman EntryBarang/InputBarang ke MainActivity/DaftarBarang
        Intent intent = new Intent(EditBarang.this, MainActivity.class);
        startActivity(intent);
    }

    private void deleteBarang() {
        // insert obyek barang yang sudah ada nilainya diatas ke database
        databaseHelper.deleteBarang(barang.getKode());

        // Pindah dari halaman EntryBarang/InputBarang ke MainActivity/DaftarBarang
        Intent intent = new Intent(EditBarang.this, MainActivity.class);
        startActivity(intent);
    }

    private void batal() {
        // Pindah dari halaman EntryBarang/InputBarang ke MainActivity/DaftarBarang
        Intent intent = new Intent(EditBarang.this, MainActivity.class);
        startActivity(intent);
    }

    private AlertDialog AskOption() {
        return new AlertDialog.Builder(this)
                // set message, title, and icon
                .setTitle("Hapus")
                .setMessage("Apakah anda ingin menghapus " + barang.getNama() + "?")
                .setIcon(R.drawable.round_delete_24)
                .setPositiveButton("Hapus", (dialog, whichButton) -> {
                    //your deleting code
                    deleteBarang();
                    dialog.dismiss();
                })
                .setNegativeButton("Batal", (dialog, which) -> dialog.dismiss())
                .create();
    }
}