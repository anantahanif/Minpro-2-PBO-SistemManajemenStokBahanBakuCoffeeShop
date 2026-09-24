package model;

public class BahanPadat extends Bahan {
    private String jenisKemasan;

    public BahanPadat(String idBahan, String nama, int stok, String jenisKemasan) {
        super(idBahan, nama, stok);
        this.jenisKemasan = jenisKemasan;
    }

    public String getJenisKemasan() {
        return jenisKemasan;
    }

    public void setJenisKemasan(String jenisKemasan) {
        this.jenisKemasan = jenisKemasan;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis       : Padat (" + jenisKemasan + ")");
    }
}