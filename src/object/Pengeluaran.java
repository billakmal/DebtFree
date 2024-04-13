package object;

import java.util.List;

public class Pengeluaran {
    private double jumlah;
    private String keterangan;
    private List<Pengeluaran> daftarPengeluaran;

    public Pengeluaran(double jumlah, String keterangan) {
        this.jumlah = jumlah;
        this.keterangan = keterangan;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void display(){
        System.out.println("melakukan pengeluaran sebesar : " + this.jumlah + " untuk " + this.keterangan);
    }

    public void tambahPengeluaran(Pengeluaran pengeluaran) {
        this.daftarPengeluaran.add(pengeluaran);
    }
}