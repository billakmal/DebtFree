import object.User;
import object.Pendapatan;
import object.Pengeluaran;
import java.util.Scanner;

public class DebtFreeApp {

    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser;

    public static void main(String[] args) {

        loginUser();

        boolean berjalan = true;
        while (berjalan) {
            tampilkanMenuUtama();
            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    tambahPendapatan();
                    break;
                case 2:
                    tambahPengeluaran();
                    break;
                case 3:
                    lihatAnggaran();
                    break;
                case 4:
                    lihatHutang();
                    break;
                case 5:
                    lihatPiutang();
                    break;
                case 6:
                    keluarAplikasi();
                    berjalan = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void loginUser() {
        System.out.print("Masukkan nama pengguna: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan email pengguna: ");
        String email = scanner.nextLine();
        System.out.print("Masukan password pengguna: ");
        String pword = scanner.nextLine();
        currentUser = new User(nama, email, pword);
        System.out.println("Login berhasil sebagai " + currentUser.getName());
    }

    private static void tampilkanMenuUtama() {
        System.out.println("===== Menu Utama =====");
        System.out.println("1. Tambah Pendapatan");
        System.out.println("2. Tambah Pengeluaran");
        System.out.println("3. Lihat Anggaran");
        System.out.println("4. Lihat Hutang");
        System.out.println("5. Lihat Piutang");
        System.out.println("6. Keluar");
        System.out.print("Pilihan Anda: ");
    }

    private static void tambahPendapatan() {
        System.out.print("Masukkan jumlah pendapatan: ");
        double jumlah = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Masukkan sumber pendapatan: ");
        String sumber = scanner.nextLine();
        currentUser.tambahPendapatan(new Pendapatan(jumlah, sumber));
        System.out.println("Pendapatan berhasil ditambahkan.");
    }

    private static void tambahPengeluaran() {
        System.out.print("Masukkan jumlah pengeluaran: ");
        double jumlah = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Masukkan keterangan pengeluaran: ");
        String keterangan = scanner.nextLine();
        currentUser.tambahPengeluaran(new Pengeluaran(jumlah, keterangan));
        System.out.println("Pengeluaran berhasil ditambahkan.");
    }

    private static void lihatAnggaran() {
        System.out.println("===== Anggaran =====");
        currentUser.tampilkanAnggaran();
    }

    private static void lihatHutang() {
        System.out.println("===== Hutang =====");
        currentUser.tampilkanDaftarHutang();
    }

    private static void lihatPiutang() {
        System.out.println("===== Piutang =====");
        currentUser.tampilkanDaftarPiutang();
    }

    private static void keluarAplikasi() {
        System.out.println("Terima kasih telah menggunakan aplikasi keuangan kami.");
    }
}


