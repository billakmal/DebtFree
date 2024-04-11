package object;

public class Hutang {
    private double jumlah;
    private String pemberi;

    public Hutang(double jumlah, String pemberi) {
        this.jumlah = jumlah;
        this.pemberi = pemberi;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumgetJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getPemberi() {
        return pemberi;
    }

    public void setHutangDengan(String pemberi) {
        this.pemberi = pemberi;
    }

    public void display(){
        System.out.println("kamu punya hutang, dengan jumlah : " + this.jumlah + " kepada " + this.pemberi);
    }
}
