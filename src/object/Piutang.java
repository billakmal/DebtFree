package object;

import java.util.List;

public class Piutang {
    private double jumlah;
    private String penerima;
    private List<Piutang> daftarPiutang;

    public Piutang(double jumlah, String penerima) {
        this.jumlah = jumlah;
        this.penerima = penerima;
    }


    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getPenerima() {
        return penerima;
    }

    public void setPenerima(String penerima) {
        this.penerima = penerima;
    }

    public void display(){
        System.out.println(this.penerima + " punya hutang sebesar : " + this.jumlah);
    }

    public void tampilkanDaftarPiutang() {
        System.out.println("===== Daftar Piutang =====");
        for (Piutang piutang : daftarPiutang) {
            System.out.println("Piutang dari " + piutang.getPenerima() + ": " + piutang.getJumlah());
        }
    }
}
