package object;

public class Pengeluaran {
    private double pengeluaran;
    private String pengeluaranuntuk;
    
    public Pengeluaran (double pengeluaran, String pengeluaranuntuk) {
        this.pengeluaran = pengeluaran;
        this.pengeluaranuntuk = pengeluaranuntuk;
    }

    public double getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(double pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    public String getPengeluaranUntuk() {
        return pengeluaranuntuk;
    }

    public void setPengeluaranUntuk(String pengeluaranuntuk) {
        this.pengeluaranuntuk = pengeluaranuntuk;
    }

    public void display(){
        System.out.println("melakukan pengeluaran sebesar : " + this.pengeluaran + " untuk " + this.pengeluaranuntuk);
    }
}