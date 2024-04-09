package object;

public class Hutang {
    private double hutang;
    private String hutangdengan;

    public Hutang(double hutang, String hutangdengan) {
        this.hutang = hutang;
        this.hutangdengan = hutangdengan;
    }

    public double getHutang() {
        return hutang;
    }

    public void setHutang(double hutang) {
        this.hutang = hutang;
    }

    public String getHutangDengan() {
        return hutangdengan;
    }

    public void setHutangDengan(String hutangdengan) {
        this.hutangdengan = hutangdengan;
    }

    public void display(){
        System.out.println("kamu punya hutang, dengan jumlah : " + this.hutang + " kepada " + this.hutangdengan);
    }
}
