package object;

import java.util.List;

public class Hutang {
    private double jumlah;
    private String pemberi;
    private List<Hutang> daftarHutang;

    public Hutang(double jumlah, String pemberi) {
        this.jumlah = jumlah;
        this.pemberi = pemberi;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getPemberi() {
        return pemberi;
    }

    public void setPemberi(String pemberi) {
        this.pemberi = pemberi;
    }

    public void display(){
        System.out.println("kamu punya hutang, dengan jumlah : " + this.jumlah + " kepada " + this.pemberi);
    }

    public void tampilkanDaftarHutang() {
        System.out.println("===== Daftar Hutang =====");
        for (Hutang hutang : daftarHutang) {
            System.out.println("Hutang kepada " + hutang.getPemberi() + ": " + hutang.getJumlah());
        }
    }
}
