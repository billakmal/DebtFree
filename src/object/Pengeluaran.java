package object;

public class Pengeluaran {
    private double jumlah;
    private String keterangan;

    public Pengeluaran(double jumlah, String keterangan) {
        this.jumlah = jumlah;
        this.keterangan = keterangan;
    }

    public double getPengeluaran() {
        return jumlah;
    }

    public void setPengeluaran(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getPengeluaranUntuk() {
        return keterangan;
    }

    public void setPengeluaranUntuk(String keterangan) {
        this.keterangan = keterangan;
    }

    public void display(){
        System.out.println("melakukan pengeluaran sebesar : " + this.jumlah + " untuk " + this.keterangan);
    }
}