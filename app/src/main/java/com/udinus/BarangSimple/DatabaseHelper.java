package com.udinus.BarangSimple;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public final static String namaDatabase = "db_obat_kaesa";
    public final static String tableBarang = "barang";
    public final static String fieldKode = "kode";
    public final static String fieldNama = "nama";
    public final static String fieldSatuan = "satuan";
    public final static String fieldHarga = "harga";


    public DatabaseHelper(@Nullable Context context) {
        super(context, namaDatabase, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + tableBarang
                + "("
                + fieldKode + " PRIMARY KEY NOT NULL, "
                + fieldNama + " TEXT, "
                + fieldSatuan + " TEXT, "
                + fieldHarga + " REAL"
                + ")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + tableBarang;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public void insertBarang(ModelBarang modelBarang) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(fieldKode, modelBarang.getKode());
        contentValues.put(fieldNama, modelBarang.getNama());
        contentValues.put(fieldSatuan, modelBarang.getSatuan());
        contentValues.put(fieldHarga, modelBarang.getHarga());

        db.insert(tableBarang, null, contentValues);
        db.close();
    }

    public ArrayList<ModelBarang> getAllModelBarangs() {

        ArrayList<ModelBarang> barangArrayList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM " + tableBarang;
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            ModelBarang modelBarang = new ModelBarang();
            modelBarang.setKode(cursor.getString(0));
            modelBarang.setNama(cursor.getString(1));
            modelBarang.setSatuan(cursor.getString(2));
            modelBarang.setHarga(Double.valueOf(cursor.getString(3)));

            barangArrayList.add(modelBarang);
        }

        cursor.close();
        return barangArrayList;
    }

    public void updateBarang(ModelBarang modelBarang) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(fieldNama, modelBarang.getNama());
        contentValues.put(fieldSatuan, modelBarang.getSatuan());
        contentValues.put(fieldHarga, modelBarang.getHarga());

        db.update(tableBarang, contentValues, "kode=?", new String[]{modelBarang.getKode()});
        db.close();
    }

    public void deleteBarang(String kodeBarang) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tableBarang, "kode=?", new String[]{kodeBarang});
        db.close();
    }
}
