package object;

public class Piutang {
    private double piutang;
    private String piutangsiapa;

    public Piutang(double piutang, String piutangsiapa) {
        this.piutang = piutang;
        this.piutangsiapa = piutangsiapa;
    }

    public double getPiutang() {
        return piutang;
    }

    public void setPiutang(double piutang) {
        this.piutang = piutang;
    }

    public String getPiutangSiapa() {
        return piutangsiapa;
    }

    public void serPiutangSiapa(String piutangsiapa) {
        this.piutangsiapa = piutangsiapa;
    }

    public void display(){
        System.out.println(this.piutangsiapa + " punya hutang sebesar : " + this.piutang);
    }
}
