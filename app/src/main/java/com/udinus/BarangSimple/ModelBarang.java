package com.udinus.BarangSimple;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.text.NumberFormat;
import java.util.Locale;

public class ModelBarang implements Parcelable {

    private String kode;
    private String nama;
    private String satuan;
    private Double harga;

    public ModelBarang() {

    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Double getHarga() {
        return harga;
    }

    public String getHargaRp() {
        // Mengubah format price tipe data double "1000" ke string currency indonesia "Rp1.000"
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        format.setMaximumFractionDigits(0);
        return format.format(this.harga);
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    protected ModelBarang(Parcel in) {
        this.kode = in.readString();
        this.nama = in.readString();
        this.satuan = in.readString();
        this.harga = in.readDouble();
    }

    public static final Creator<ModelBarang> CREATOR = new Creator<ModelBarang>() {
        @Override
        public ModelBarang createFromParcel(Parcel in) {
            return new ModelBarang(in);
        }

        @Override
        public ModelBarang[] newArray(int size) {
            return new ModelBarang[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.kode);
        parcel.writeString(this.nama);
        parcel.writeString(this.satuan);
        parcel.writeDouble(this.harga);
    }
}
