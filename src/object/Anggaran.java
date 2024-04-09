package object;

public class Anggaran {
    private double anggaran;

    public Anggaran(double anggaran) {
        this.anggaran = anggaran;
    }

    public double getAnggaran() {
        return anggaran;
    }

    public void setAnggaran(double anggaran) {
        this.anggaran = anggaran;
    }

    public void display(){
        System.out.println("anggaran bulan ini adalah : " + this.anggaran);
    }
}
