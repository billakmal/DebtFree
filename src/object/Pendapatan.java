package object;

public class Pendapatan {
    private double pendapatan;
    private String pendapatandari;

    public Pendapatan(double pendapatan, String pendapatandari) {
        this.pendapatan = pendapatan;
        this.pendapatandari = pendapatandari;
    }

    public double getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(double pendapatan) {
        this.pendapatan = pendapatan;
    }

    public String getPendapatanDari() {
        return pendapatandari;
    }

    public void setPendapatanDari(String pendapatandari) {
        this.pendapatandari = pendapatandari;
    }
    
    public void display(){
        System.out.println("pendapatan sebesar : " + this.pendapatan + " dari " + this.pendapatandari);
    }
}
