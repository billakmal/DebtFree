package object;

public class Anggaran {
    private double jumlah;

    public Anggaran(double jumlah) {
        this.jumlah = jumlah;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public void display(){
        System.out.println("Anggaran bulan ini adalah : " + this.jumlah);
    }

    public void tampilkanAnggaran() {
        System.out.println("Anggaran Anda adalah: " + this.jumlah);
    }
}
