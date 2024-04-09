import object.User;
import object.Anggaran;
import object.Pendapatan;
import object.Pengeluaran;
import object.Hutang;
import object.Piutang;

public class Main {

    public static void main(String[] args) throws Exception {

        User user1 =  new User("bilal", "email", "pword");
        user1.display();
        
        Anggaran anggaran1 = new Anggaran(12000);
        anggaran1.display();
        
        Pendapatan pendapatan1 = new Pendapatan(100000, "gaji");
        pendapatan1.display();

        
        Pengeluaran pengeluaran1 = new Pengeluaran(8000, "makan");
        pengeluaran1.display();
        
        Hutang hutang1 = new Hutang(12000,"abi");
        hutang1.display();

        Piutang piutang1 = new Piutang(15000, "bilal");
        piutang1.display();

        double nilaiPiutang = piutang1.getPiutang();
        System.out.println("nilai piutang : " + nilaiPiutang);

    }
}
