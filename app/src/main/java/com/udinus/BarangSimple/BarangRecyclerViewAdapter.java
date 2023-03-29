package com.udinus.BarangSimple;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BarangRecyclerViewAdapter extends RecyclerView.Adapter<BarangRecyclerViewAdapter.BarangRecyclerViewHolder> {
    private final ArrayList<ModelBarang> barangArrayList;

    public BarangRecyclerViewAdapter(ArrayList<ModelBarang> barangArrayList) {
        this.barangArrayList = barangArrayList;
    }

    @NonNull
    @Override
    public BarangRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_barang, parent, false);
        return new BarangRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangRecyclerViewHolder holder, int position) {
        // Mendapatkan barang pada ArrayList<ModelBarang> sesuai dengan position/index-nya.
        ModelBarang barang = barangArrayList.get(position);

        // Memasukan isi dari variabel barang/ModelBarang ke dalam TextView
        // yang ada dalam holder item_row_barang.xml
        holder.tvItemKode.setText(barang.getKode());
        holder.tvItemNama.setText(barang.getNama());
        holder.tvItemSatuan.setText(barang.getSatuan());
        holder.tvItemHarga.setText(barang.getHargaRp());

        holder.itemView.setOnClickListener(view -> {
            Intent intentDetail = new Intent(holder.itemView.getContext(), EditBarang.class);
            intentDetail.putExtra("key_barang", barang);
            holder.itemView.getContext().startActivity(intentDetail);
        });
    }

    @Override
    public int getItemCount() {
        return barangArrayList.size();
    }

    // Class Holder untuk List Barang RecyclerView
    public static class BarangRecyclerViewHolder extends RecyclerView.ViewHolder {

        // Deklarasi TextView yang ada pada item_row_barang.xml
        TextView tvItemKode, tvItemNama, tvItemSatuan, tvItemHarga;
        public BarangRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            // Inisialisasi TextView dengan Id yang ada pada item_row_barang.xml
            tvItemKode = itemView.findViewById(R.id.tv_item_kode);
            tvItemNama = itemView.findViewById(R.id.tv_item_nama);
            tvItemSatuan = itemView.findViewById(R.id.tv_item_satuan);
            tvItemHarga = itemView.findViewById(R.id.tv_item_harga);
        }
    }
}
