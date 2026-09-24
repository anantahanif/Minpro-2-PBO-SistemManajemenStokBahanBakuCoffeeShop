# Mini Project 2 PBO - Sistem Manajemen Stok Bahan Baku Coffee Shop

**Nama**  : Alex  
**NIM**   : ✏️ [EDIT MANUAL: Masukkan NIM Kamu]  
**Kelas** : ✏️ [EDIT MANUAL: Masukkan Kelas/Angkatan Kamu]  

---

## Latar Belakang

Pengelolaan stok bahan baku pada usaha *coffee shop*, seperti biji kopi, susu, dan sirup, memerlukan pencatatan yang teliti agar ketersediaan bahan baku tetap terjaga dan operasi harian berjalan lancar. Pencatatan stok secara manual rentan terhadap kesalahan input, kerancuan data, hingga hilangnya riwayat bahan. Oleh karena itu, dibuat program sederhana berbasis Java untuk membantu mencatat, memperbarui, dan memantau stok bahan baku *coffee shop* sebagai pengembangan dari Mini Project 1 dengan menerapkan prinsip-prinsip Pemrograman Berorientasi Objek (PBO).

---

## Deskripsi Program

Program ini merupakan aplikasi berbasis konsol (*Command Line Interface* / CLI) yang digunakan untuk mengelola data stok bahan baku *coffee shop*. Data yang dikelola meliputi ID bahan, nama bahan, jumlah stok, serta atribut khusus sesuai jenis bahan baku, yaitu **jenis kemasan** untuk Bahan Padat dan **kemasan cair** untuk Bahan Cair.

Program menyediakan lima fitur utama:
1. **Tampilkan Semua Bahan** - Menampilkan seluruh data bahan baku yang tersimpan.
2. **Tambah Bahan Baru** - Menambahkan data bahan baku padat atau cair baru.
3. **Update Stok Bahan** - Memperbarui jumlah stok bahan berdasarkan ID.
4. **Hapus Bahan** - Menghapus data bahan baku dari sistem berdasarkan ID.
5. **Cari Bahan** - Mencari data bahan baku berdasarkan ID atau Nama (demo *Method Overloading*).

---

## MVC yang Digunakan

Program ini menerapkan arsitektur **MVC (Model-View-Controller)** untuk memisahkan tanggung jawab tiap bagian kode:

### 1. Model
Berisi class `Bahan`, `BahanCair`, dan `BahanPadat`. Bagian ini bertugas merepresentasikan dan menyimpan data entitas bahan baku.

### 2. View / Main
Berisi class `Minpro2` pada package utama. Bagian ini bertugas menampilkan antarmuka konsol (menu utama), menerima input pengguna, serta melakukan validasi awal terhadap input.

### 3. Controller
Berisi class `StokController`. Bagian ini bertugas mengelola logika bisnis program, mengoperasikan `ArrayList`, menyediakan data awal (*dummy data*), serta menjembatani interaksi antara View dan Model.

---

## Struktur Package MVC

```text
com.mycompany.minpro2
│
├── Minpro2.java (Main / View)
│
├── model
│   ├── Bahan.java (Superclass)
│   ├── BahanCair.java (Subclass)
│   └── BahanPadat.java (Subclass)
│
└── controller
    └── StokController.java (Controller & CRUD Logic)
```

📌 **[SISIPKAN GAMBAR 1: Screenshot Tampilan Struktur Package di NetBeans]**

*(Petunjuk: Tangkap layar/screenshot panel Projects di NetBeans yang menampilkan folder `Source Packages` beserta sub-package `model`, `controller`, dan file `Minpro2.java`)*

---

## Alur Program

Program dimulai dari method `main()` pada class `Minpro2`. Program membuat objek `Scanner` untuk membaca input dan objek `StokController`. Saat `StokController` diinstansiasi, *constructor*-nya secara otomatis memuat data awal (*dummy data*) ke dalam `ArrayList`. Selanjutnya, perulangan `while (berjalan)` akan menampilkan menu utama dan memproses pilihan pengguna menggunakan `switch-case`.

### Menu Utama

📌 **[SISIPKAN GAMBAR 2: Screenshot Tampilan Menu Utama saat Program Dijalankan]**

Potongan logika *switch-case* pada `Minpro2.java`:

```java
switch (pilihan) {
    case 1:
        controller.tampilkanSemuaBahan();
        break;
    case 2:
        // Proses Tambah Bahan
        break;
    case 3:
        // Proses Update Stok
        break;
    case 4:
        // Proses Hapus Bahan
        break;
    case 5:
        // Proses Cari Bahan (Overloading Demo)
        break;
    case 0:
        berjalan = false;
        System.out.println(">> Terima kasih, program selesai.");
        break;
    default:
        System.out.println(">> Pilihan menu tidak tersedia!");
}
```

---

## Operasi CRUD

Seluruh fungsi pengelolaan data ditangani oleh class `StokController` yang menyimpan objek-objek bertipe `Bahan` di dalam `ArrayList<Bahan> listBahan`.

### 1. Create (`tambahBahan()`)

* **Fungsi:** Menambahkan data bahan baku baru (padat atau cair) ke dalam `ArrayList`.
* **Proses:** Pengguna memilih jenis bahan (Padat/Cair), lalu memasukkan ID, nama, stok awal, serta informasi kemasan khusus.

```java
public void tambahBahan(Bahan bahan) {
    listBahan.add(bahan);
    System.out.println(">> Bahan berhasil ditambahkan!");
}
```

📌 **[SISIPKAN GAMBAR 3: Screenshot Proses Tambah Data Bahan Baru]**

---

### 2. Read (`tampilkanSemuaBahan()`)

* **Fungsi:** Menampilkan seluruh data bahan baku yang tersimpan.
* **Proses:** Program mengecek apakah `ArrayList` kosong. Jika ada data, program mengiterasi list menggunakan *for-each* dan memanggil method `tampilkanInfo()` milik masing-masing objek.

```java
public void tampilkanSemuaBahan() {
    if (listBahan.isEmpty()) {
        System.out.println(">> Belum ada data bahan baku.");
        return;
    }
    System.out.println("\n=== DAFTAR STOK BAHAN BAKU ===");
    for (Bahan b : listBahan) {
        b.tampilkanInfo(); // Polymorphism Overriding
        System.out.println("---------------------------------");
    }
}
```

📌 **[SISIPKAN GAMBAR 4: Screenshot Proses Tampilkan Data Bahan]**

---

### 3. Update (`updateStok()`)

* **Fungsi:** Memperbarui jumlah stok bahan berdasarkan ID.
* **Proses:** Pengguna memasukkan ID bahan dan nilai stok baru. Program mencari bahan yang cocok di `ArrayList` dan memperbarui nilainya melalui setter `setStok()`.

```java
public boolean updateStok(String id, int stokBaru) {
    for (Bahan b : listBahan) {
        if (b.getIdBahan().equalsIgnoreCase(id)) {
            b.setStok(stokBaru);
            return true;
        }
    }
    return false;
}
```

📌 **[SISIPKAN GAMBAR 5: Screenshot Proses Update Stok Bahan]**

---

### 4. Delete (`hapusBahan()`)

* **Fungsi:** Menghapus data bahan baku dari `ArrayList` berdasarkan ID.
* **Proses:** Program mencari posisi elemen berdasar ID, lalu menghapusnya dengan method `remove()`.

```java
public boolean hapusBahan(String id) {
    for (int i = 0; i < listBahan.size(); i++) {
        if (listBahan.get(i).getIdBahan().equalsIgnoreCase(id)) {
            listBahan.remove(i);
            return true;
        }
    }
    return false;
}
```

📌 **[SISIPKAN GAMBAR 6: Screenshot Proses Hapus Data Bahan]**

---

### 5. Search (`cariBahan()` - Demo Overloading)

* **Fungsi:** Mencari bahan berdasarkan ID atau Nama menggunakan konsep *Method Overloading*.

```java
// Overloading 1: Cari berdasarkan ID
public Bahan cariBahan(String id) {
    for (Bahan b : listBahan) {
        if (b.getIdBahan().equalsIgnoreCase(id)) {
            return b;
        }
    }
    return null;
}

// Overloading 2: Cari berdasarkan Nama
public Bahan cariBahan(String nama, boolean byNama) {
    for (Bahan b : listBahan) {
        if (b.getNama().equalsIgnoreCase(nama)) {
            return b;
        }
    }
    return null;
}
```

📌 **[SISIPKAN GAMBAR 7: Screenshot Hasil Pencarian Bahan]**

---

## Validasi Input (Input Validation)

Untuk mencegah program mengalami *crash* saat pengguna memasukkan tipe data yang salah, diterapkan validasi input berupa penanganan eksepsi `InputMismatchException` pada method `inputAngka()` di class `Minpro2`:

```java
private static int inputAngka(Scanner scanner) {
    while (true) {
        try {
            int val = scanner.nextInt();
            scanner.nextLine(); // Bersihkan newline
            return val;
        } catch (InputMismatchException e) {
            System.out.print(">> Input harus berupa angka! Masukkan lagi: ");
            scanner.nextLine();
        }
    }
}
```

Selain itu, pada class `Bahan`, nilai stok yang diinputkan juga divalidasi agar tidak menerima angka negatif:

```java
public void setStok(int stok) {
    if (stok >= 0) {
        this.stok = stok;
    }
}
```

📌 **[SISIPKAN GAMBAR 8: Screenshot Saat Pengguna Memasukkan Input Salah / Invalid Input]**

---

## Konsep PBO yang Diterapkan

### 1. Encapsulation

Atribut-atribut pada class `Bahan` dibuat dengan modifier `private` atau `protected`. Pengaksesan dan pengubahan nilai atribut dilakukan secara aman melalui method *getter* dan *setter*. Atribut `idBahan` dibuat `final` sehingga nilainya tidak dapat diubah setelah objek diinstansiasi.

```java
private final String idBahan;
protected String nama;
protected int stok;

public String getIdBahan() { return idBahan; }
public String getNama() { return nama; }
public void setNama(String nama) { this.nama = nama; }
```

---

### 2. Inheritance

Superclass `Bahan` diturunkan ke dua subclass, yaitu `BahanCair` dan `BahanPadat`, menggunakan kata kunci `extends`. Subclass mewarisi atribut dan method milik superclass serta menggunakan `super()` untuk memanggil *constructor* induk.

```java
public class BahanCair extends Bahan {
    private String kemasan;

    public BahanCair(String idBahan, String nama, int stok, String kemasan) {
        super(idBahan, nama, stok);
        this.kemasan = kemasan;
    }
}
```

---

### 3. Polymorphism

#### A. Method Overriding

Method `tampilkanInfo()` di-override oleh kelas `BahanCair` dan `BahanPadat` untuk menampilkan detail spesifik jenis kemasan masing-masing.

```java
@Override
public void tampilkanInfo() {
    super.tampilkanInfo();
    System.out.println("Jenis       : Cair (" + kemasan + ")");
}
```

#### B. Method Overloading

Diterapkan pada method `tampilkanInfo()` di class `Bahan` dan method `cariBahan()` pada class `StokController` dengan menggunakan parameter yang berbeda.

```java
// Overloading pada class Bahan
public void tampilkanInfo() { ... }
public void tampilkanInfo(boolean ringkas) { ... }
```

📌 **[SISIPKAN GAMBAR 9: Screenshot Output Pemanggilan Polymorphism (Tampilan Bahan Padat vs Bahan Cair)]**

---

## Dummy Data

Agar daftar stok tidak kosong saat program pertama kali dijalankan, *constructor* `StokController` secara otomatis memuat dua data awal:

```java
public StokController() {
    listBahan.add(new BahanPadat("B001", "Biji Kopi Arabika", 50, "Pouch 1kg"));
    listBahan.add(new BahanCair("B002", "Susu UHT Fresh", 20, "Karton 1 Liter"));
}
```

📌 **[SISIPKAN GAMBAR 10: Screenshot Tampilan Dummy Data saat Pertama Kali Pilih Menu Tampilkan]**

---

## Kesimpulan dan Pengembangan dari Minpro 1

Mini Project 2 ini dikembangkan sebagai perbaikan dan peningkatan dari Mini Project 1. Beberapa poin pengembangan utamanya meliputi:

1. Penerapan arsitektur **MVC** yang memisahkan layer tampilan, logika bisnis, dan model data.
2. Penerapan konsep PBO lanjutan, seperti **Inheritance** (Superclass & Subclass) serta **Polymorphism** (*Overriding* & *Overloading*).
3. Peningkatan sistem **Validasi Input** untuk menangani kesalahan tipe data pengguna sehingga mencegah program dari *crash*.
4. Penambahan fitur pencarian data dan ketersediaan *dummy data* awal.
