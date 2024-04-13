package object;

import java.util.List;

public class Pendapatan {
    private double jumlah;
    private String sumber;
    private List<Pendapatan> daftarPendapatan;

    public Pendapatan(double jumlah, String sumber) {
        this.jumlah = jumlah;
        this.sumber = sumber;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getSumber() {
        return sumber;
    }

    public void setSumber(String sumber) {
        this.sumber = sumber;
    }
    
    public void display(){
        System.out.println("pendapatan sebesar : " + this.jumlah + " dari " + this.sumber);
    }

    public void tambahPendapatan(Pendapatan pendapatan) {
        this.daftarPendapatan.add(pendapatan);
    }
}
