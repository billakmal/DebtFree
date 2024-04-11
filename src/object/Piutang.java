package object;

public class Piutang {
    private double jumlah;
    private String penerima;

    public Piutang(double jumlah, String penerima) {
        this.jumlah = jumlah;
        this.penerima = penerima;
    }


    public double getPiutang() {
        return jumlah;
    }

    public void setPiutang(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getPiutangSiapa() {
        return penerima;
    }

    public void serPiutangSiapa(String penerima) {
        this.penerima = penerima;
    }

    public void display(){
        System.out.println(this.penerima + " punya hutang sebesar : " + this.jumlah);
    }
}
