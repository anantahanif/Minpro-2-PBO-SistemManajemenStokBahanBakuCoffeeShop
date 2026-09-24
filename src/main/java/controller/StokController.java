package controller;

import model.Bahan;
import model.BahanCair;
import model.BahanPadat;
import java.util.ArrayList;

public class StokController {
    private ArrayList<Bahan> listBahan = new ArrayList<>();

    public StokController() {
        listBahan.add(new BahanPadat("B001", "Biji Kopi Arabika", 50, "Pouch 1kg"));
        listBahan.add(new BahanCair("B002", "Susu UHT Fresh", 20, "Karton 1 Liter"));
    }

    public void tambahBahan(Bahan bahan) {
        listBahan.add(bahan);
        System.out.println(">> Bahan berhasil ditambahkan!");
    }

    public void tampilkanSemuaBahan() {
        if (listBahan.isEmpty()) {
            System.out.println(">> Belum ada data bahan baku.");
            return;
        }
        System.out.println("\n=== DAFTAR STOK BAHAN BAKU ===");
        for (Bahan b : listBahan) {
            b.tampilkanInfo();
            System.out.println("---------------------------------");
        }
    }

    public boolean updateStok(String id, int stokBaru) {
        for (Bahan b : listBahan) {
            if (b.getIdBahan().equalsIgnoreCase(id)) {
                b.setStok(stokBaru);
                return true;
            }
        }
        return false;
    }

    public boolean hapusBahan(String id) {
        for (int i = 0; i < listBahan.size(); i++) {
            if (listBahan.get(i).getIdBahan().equalsIgnoreCase(id)) {
                listBahan.remove(i);
                return true;
            }
        }
        return false;
    }

    public Bahan cariBahan(String id) {
        for (Bahan b : listBahan) {
            if (b.getIdBahan().equalsIgnoreCase(id)) {
                return b;
            }
        }
        return null;
    }

    public Bahan cariBahan(String nama, boolean byNama) {
        for (Bahan b : listBahan) {
            if (b.getNama().equalsIgnoreCase(nama)) {
                return b;
            }
        }
        return null;
    }
}