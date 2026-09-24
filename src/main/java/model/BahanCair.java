package model;

public class BahanCair extends Bahan {
    private String kemasan;

    public BahanCair(String idBahan, String nama, int stok, String kemasan) {
        super(idBahan, nama, stok);
        this.kemasan = kemasan;
    }

    public String getKemasan() {
        return kemasan;
    }

    public void setKemasan(String kemasan) {
        this.kemasan = kemasan;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis       : Cair (" + kemasan + ")");
    }
}