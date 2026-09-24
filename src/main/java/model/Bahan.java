package model;

public class Bahan {
    private final String idBahan;
    protected String nama;
    protected int stok;

    public Bahan(String idBahan, String nama, int stok) {
        this.idBahan = idBahan;
        setNama(nama);
        setStok(stok);
    }

    public String getIdBahan() {
        return idBahan;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        }
    }

    public void tampilkanInfo() {
        System.out.println("ID Bahan    : " + idBahan);
        System.out.println("Nama Bahan  : " + nama);
        System.out.println("Stok        : " + stok);
    }

    public void tampilkanInfo(boolean ringkas) {
        if (ringkas) {
            System.out.println(nama + " [" + idBahan + "] - Stok: " + stok);
        } else {
            tampilkanInfo();
        }
    }
}