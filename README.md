# Program BarangSimple

CRUD simple pemprograman Android Mobile dengan Java &amp; XML.

- `C`REATE
- `R`EAD
- `U`PDATE
- `D`ELETE

## Cara Mengunduh/Mendownload/Clone `Repository BarangSimple`

Sebelum clone, pastikan anda sudah memasang [git/git bash](https://git-scm.com/downloads) pada komputer anda.

Setelah itu ketik perintah dibawah pada `git bash here` atau buka `terminal` Anda!

```bash
git clone https://github.com/lyrihkaesa/BarangSimple.git
```

Selanjutnya, buka project BarangSimple di Android Studio dengan klik **File > Open** pada TabBar.

## Cara Menduplikat/Fork Repostiory lyrihkaesa ke Repository Milik Sendiri

Silahkan klik tombol `Fork` pada kanan atas sebelah kiri ⭐ `star`.

| Fork Repository `Utama` ke Repository `Pribadi`                                  |
| -------------------------------------------------------------------------------- |
| ![Fork-SimpleBarang](https://lyrihkaesa.github.io/gif/git-fork-BarangSimple.gif) |

Setelah itu, Anda dapat `git clone` dengan link/tautan repository pribadi Anda.

| Git Clone Repository hasil Fork                                                    |
| ---------------------------------------------------------------------------------- |
| ![Clone-SimpleBarang](https://lyrihkaesa.github.io/gif/git-clone-BarangSimple.gif) |

## Membuat Branch Baru & Pindah Branch

Untuk membuat branch baru pada Git dan masuk ke branch tersebut, Anda dapat mengikuti langkah-langkah berikut:

1. Klik kanan pada folder proyek Anda, kemudian pilih ‘Git Bash Here’.
2. Ketikkan perintah:

```bash
git branch <nama-branch-yang-dibuat>
```

3. Masuk ke branch yang baru saja dibuat dengan perintah:

```bash
git checkout <nama-branch-yang-dibuat>
```

4. Jika Anda ingin membuat branch baru dan langsung pindah ke branch bersangkutan, gunakan perintah:

```bash
git checkout -b <nama-branch-yang-dibuat>
```

### Contoh

```bash
git checkout -b 99999-Kaesa/latihan
```

| `git checkout -b <nama-branch-anda>`                                                    |
| --------------------------------------------------------------------------------------- |
| ![Clone-SimpleBarang](https://lyrihkaesa.github.io/gif/git-checkout-b-SimpleBarang.gif) |

### Aturan Penamaan Branch

Berikut adalah beberapa best practice penamaan branch pada Git:

1. Gunakan nama yang deskriptif dan mudah dipahami oleh tim Anda.
2. Gunakan tAnda `-` atau `_` untuk memisahkan kata dalam nama branch.
3. Gunakan huruf kecil untuk semua karakter dalam nama branch.
4. Gunakan awalan yang jelas untuk menunjukkan jenis branch tersebut, seperti `feature/`, `bugfix/`, atau `hotfix/`.
5. Hindari menggunakan spasi dalam nama branch. Jika perlu, gunakan tAnda `-` atau `_`.
6. Hindari menggunakan karakter khusus seperti `~`, `^`, atau `:` dalam nama branch.

Berikut contoh penamaan branch:

- NIM-Nama/tugas/<nama-tugas>
  - 09999-Kaesa/tugas/lingkaran
- NIM-Nama/latihan/<nama-latihan>
  - 09999-Kaesa/latihan/kubus
- NIM-Nama/praktek/<nama-praktek>
  - 09999-Kaesa/praktek/<nama-praktek>

## Kriteria

- Terdapat `RecycleView`, `CardView`, dan `Parcelable`.
- Menggunakan `SQLite` dan `ModelBarang`.
- Terdapat Halaman `Daftar Barang` (MainActivity).
- Terdapat Halaman `Input Barang` (EntryBarang).
- Terdapat Halaman `Update & Delete Barang` (EditPage).
- Terdapat konfirmasi berupa `popup` saat klik tombol/button `hapus`.

## Berikut Contoh Tampilannya

| CREATE/INSERT                                                                | EDIT/UPDATE & DELETE                                                                           |
| ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- |
| ![create-2-barang.gif](https://lyrihkaesa.github.io/gif/create-2-barang.gif) | ![update-and-delete-barang.gif](https://lyrihkaesa.github.io/gif/update-and-delete-barang.gif) |
