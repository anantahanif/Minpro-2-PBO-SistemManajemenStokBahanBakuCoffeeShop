package com.mycompany.minpro2;

import controller.StokController;
import model.Bahan;
import model.BahanCair;
import model.BahanPadat;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Minpro2 {

    private static int inputAngka(Scanner scanner) {
        while (true) {
            try {
                int val = scanner.nextInt();
                scanner.nextLine(); 
                return val;
            } catch (InputMismatchException e) {
                System.out.print(">> Input harus berupa angka! Masukkan lagi: ");
                scanner.nextLine(); 
            }
        }
    }

    public static void main(String[] args) {
        StokController controller = new StokController();
        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        while (berjalan) {
            System.out.println("\n=================================");
            System.out.println(" SISTEM STOK BAHAN BAKU COFFEE SHOP ");
            System.out.println("=================================");
            System.out.println("1. Tampilkan Semua Bahan (Read Data)");
            System.out.println("2. Tambah Bahan Baru (Create)");
            System.out.println("3. Update Stok Bahan (Update)");
            System.out.println("4. Hapus Bahan (Delete)");
            System.out.println("5. Cari Bahan (Demo Overloading)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = inputAngka(scanner);

            switch (pilihan) {
                case 1:
                    controller.tampilkanSemuaBahan();
                    break;

                case 2:
                    System.out.println("\nPilih Jenis Bahan:");
                    System.out.println("1. Bahan Padat");
                    System.out.println("2. Bahan Cair");
                    System.out.print("Pilih (1/2): ");
                    int jenis = inputAngka(scanner);

                    System.out.print("ID Bahan     : ");
                    String id = scanner.nextLine();
                    System.out.print("Nama Bahan   : ");
                    String nama = scanner.nextLine();
                    System.out.print("Stok Awal    : ");
                    int stok = inputAngka(scanner);

                    if (jenis == 1) {
                        System.out.print("Jenis Kemasan: ");
                        String kemasan = scanner.nextLine();
                        controller.tambahBahan(new BahanPadat(id, nama, stok, kemasan));
                    } else if (jenis == 2) {
                        System.out.print("Kemasan Cair : ");
                        String kemasan = scanner.nextLine();
                        controller.tambahBahan(new BahanCair(id, nama, stok, kemasan));
                    } else {
                        System.out.println(">> Jenis tidak valid!");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan ID Bahan yang ingin di-update: ");
                    String idUpdate = scanner.nextLine();
                    System.out.print("Masukkan Stok Baru: ");
                    int stokBaru = inputAngka(scanner);

                    if (controller.updateStok(idUpdate, stokBaru)) {
                        System.out.println(">> Stok berhasil diperbarui!");
                    } else {
                        System.out.println(">> ID bahan tidak ditemukan!");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ID Bahan yang ingin dihapus: ");
                    String idHapus = scanner.nextLine();
                    if (controller.hapusBahan(idHapus)) {
                        System.out.println(">> Bahan berhasil dihapus!");
                    } else {
                        System.out.println(">> ID bahan tidak ditemukan!");
                    }
                    break;

                case 5:
                    System.out.println("\nPilih Mode Pencarian:");
                    System.out.println("1. Cari Berdasarkan ID");
                    System.out.println("2. Cari Berdasarkan Nama");
                    System.out.print("Pilih (1/2): ");
                    int mode = inputAngka(scanner);

                    if (mode == 1) {
                        System.out.print("Masukkan ID Bahan: ");
                        String idCari = scanner.nextLine();
                        Bahan b = controller.cariBahan(idCari);
                        if (b != null) {
                            System.out.println("\n--- Hasil Pencarian (ID) ---");
                            b.tampilkanInfo();
                        } else {
                            System.out.println(">> Bahan tidak ditemukan!");
                        }
                    } else if (mode == 2) {
                        System.out.print("Masukkan Nama Bahan: ");
                        String namaCari = scanner.nextLine();
                        Bahan b = controller.cariBahan(namaCari, true);
                        if (b != null) {
                            System.out.println("\n--- Hasil Pencarian (Nama) ---");
                            b.tampilkanInfo();
                        } else {
                            System.out.println(">> Bahan tidak ditemukan!");
                        }
                    } else {
                        System.out.println(">> Pilihan mode tidak valid!");
                    }
                    break;

                case 0:
                    berjalan = false;
                    System.out.println(">> Terima kasih, program selesai.");
                    break;

                default:
                    System.out.println(">> Pilihan menu tidak tersedia!");
            }
        }
    }
}