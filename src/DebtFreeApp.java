    import object.User;
    import object.Pendapatan;
    import object.Pengeluaran;
    import object.Hutang;
    import object.Piutang;
    import java.util.Scanner;
    import java.util.List;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.ResultSet;
    import java.sql.PreparedStatement;

    public class DebtFreeApp {

        private static Scanner scanner = new Scanner(System.in);
        private static User currentUser;
        private static Connection conn;
        private static PreparedStatement preparedStatement;

        public static void main(String[] args) {

            try {
                String url = "jdbc:mysql://localhost:3306/DebtFree";
                String user = "root";
                String password = "ribihu";
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi ke database berhasil.");

                
                
                boolean berjalan = true;
            while (berjalan) {
                System.out.println("===== Selamat Datang di DebtFreeApp =====");
                System.out.println("1. Login");
                System.out.println("2. Sign Up");
                System.out.println("3. Keluar");
                System.out.print("Pilihan Anda: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // Baca newline

                switch (pilihan) {
                    case 1:
                        loginUser();
                        break;
                    case 2:
                        signUpUser();
                        break;
                    case 3:
                        berjalan = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static void loginUser() {
        System.out.println("===== Login =====");
        System.out.println("Masukkan nama pengguna atau email: ");
        String userInput = scanner.nextLine();
        System.out.println("Masukkan kata sandi: ");
        String kataSandi = scanner.nextLine();

        try {
            String sql = "SELECT * FROM user WHERE (name = ? OR email = ?) AND password = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userInput);
            preparedStatement.setString(2, userInput);
            preparedStatement.setString(3, kataSandi);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String namaPengguna = resultSet.getString("name");
                System.out.println("Login berhasil sebagai " + namaPengguna);
                tampilkanMenuUtama();
            } else {
                System.out.println("Nama pengguna, email, atau kata sandi salah.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void signUpUser() {
        System.out.println("===== Sign Up =====");
        System.out.print("Masukkan nama pengguna: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan email: ");
        String email = scanner.nextLine();
        System.out.print("Masukkan kata sandi: ");
        String kataSandi = scanner.nextLine();

        try {
            String sql = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, kataSandi);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                tampilkanMenuUtama();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


private static void tampilkanMenuUtama() {
    boolean berjalan = true;
    while (berjalan) {
        System.out.println("===== Menu Utama =====");
        System.out.println("1. Menu Pendapatan");
        System.out.println("2. Menu Pengeluaran");
        System.out.println("3. Lihat Anggaran");
        System.out.println("4. Menu Hutang");
        System.out.println("5. Menu Piutang");
        System.out.println("6. Keluar");
        System.out.print("Pilihan Anda: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Baca newline

        switch (pilihan) {
            case 1:
                menuPendapatan();
                break;
            case 2:
                menuPengeluaran();
                break;
            case 3:
                lihatAnggaran();
                break;
            case 4:
                menuHutang();
                break;
            case 5:
                menuPiutang();
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

        private static void menuPendapatan() {
            boolean menuPendapatanBerjalan = true;
            while (menuPendapatanBerjalan) {
                tampilkanMenuPendapatan();
                int pilihanPendapatan = scanner.nextInt();
                switch (pilihanPendapatan) {
                    case 1:
                        tambahPendapatan();
                        break;
                    case 2:
                        lihatPendapatan();
                        break;
                    case 3:
                        menuPendapatanBerjalan = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
        }

        private static void menuPengeluaran() {
            boolean menuPengeluaranBerjalan = true;
            while (menuPengeluaranBerjalan) {
                tampilkanMenuPengeluaran();
                int pilihanPengeluaran = scanner.nextInt();
                switch (pilihanPengeluaran) {
                    case 1:
                        tambahPengeluaran();
                        break;
                    case 2:
                        lihatPengeluaran();
                        break;
                    case 3:
                        menuPengeluaranBerjalan = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
        }

        private static void menuHutang() {
            boolean menuHutangBerjalan = true;
            while (menuHutangBerjalan) {
                tampilkanMenuHutang();
                int pilihanHutang = scanner.nextInt();
                switch (pilihanHutang) {
                    case 1:
                        tambahHutang();
                        break;
                    case 2:
                        lihatHutang();
                        break;
                    case 3:
                        menuHutangBerjalan = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
        }

        private static void menuPiutang() {
            boolean menuPiutangBerjalan = true;
            while (menuPiutangBerjalan) {
                tampilkanMenuPiutang();
                int pilihanPiutang = scanner.nextInt();
                switch (pilihanPiutang) {
                    case 1:
                        tambahPiutang();
                        break;
                    case 2:
                        lihatPiutang();
                        break;
                    case 3:
                        menuPiutangBerjalan = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
        }

        private static void tampilkanMenuPendapatan() {
            System.out.println("===== Menu Pendapatan =====");
            System.out.println("1. Tambah Pendapatan");
            System.out.println("2. Lihat Pendapatan");
            System.out.println("3. Kembali");
            System.out.print("Pilihan Anda: ");
        }

        private static void tampilkanMenuPengeluaran() {
            System.out.println("===== Menu Pengeluaran =====");
            System.out.println("1. Tambah Pengeluaran");
            System.out.println("2. Lihat Pengeluaran");
            System.out.println("3. Kembali");
            System.out.print("Pilihan Anda: ");
        }

        private static void tampilkanMenuHutang() {
            System.out.println("===== Menu Hutang =====");
            System.out.println("1. Tambah Hutang");
            System.out.println("2. Lihat Hutang");
            System.out.println("3. Kembali");
            System.out.print("Pilihan Anda: ");
        }

        private static void tampilkanMenuPiutang() {
            System.out.println("===== Menu Piutang =====");
            System.out.println("1. Tambah Piutang");
            System.out.println("2. Lihat Piutang");
            System.out.println("3. Kembali");
            System.out.print("Pilihan Anda: ");
        }

        private static void tambahPendapatan() {
            System.out.print("Masukkan jumlah pendapatan: ");
            double jumlah = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Masukkan sumber pendapatan: ");
            String sumber = scanner.nextLine();
            Pendapatan pendapatanBaru = new Pendapatan(jumlah, sumber);
            currentUser.tambahPendapatan(pendapatanBaru);
            System.out.println("Pendapatan berhasil ditambahkan.");
        }

        private static void lihatPendapatan() {
            System.out.println("===== Daftar Pendapatan =====");
            List<Pendapatan> daftarPendapatan = currentUser.getDaftarPendapatan();
            if (daftarPendapatan.isEmpty()) {
                System.out.println("Tidak ada pendapatan yang tersedia.");
            } else {
                for (int i = 0; i < daftarPendapatan.size(); i++) {
                    Pendapatan pendapatan = daftarPendapatan.get(i);
                    System.out.println("Pendapatan ke-" + (i + 1) + ":");
                    System.out.println("Jumlah: " + pendapatan.getJumlah());
                    System.out.println("Sumber: " + pendapatan.getSumber());
                    System.out.println();
                }
            }
        }

        private static void tambahPengeluaran() {
            System.out.print("Masukkan jumlah pengeluaran: ");
            double jumlah = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Masukkan keterangan pengeluaran: ");
            String keterangan = scanner.nextLine();
            Pengeluaran pengeluaranBaru = new Pengeluaran(jumlah, keterangan);
            currentUser.tambahPengeluaran(pengeluaranBaru);
            System.out.println("Pengeluaran berhasil ditambahkan.");
        }

        private static void lihatPengeluaran() {
            System.out.println("===== Daftar Pengeluaran =====");
            List<Pengeluaran> daftarPengeluaran = currentUser.getDaftarPengeluaran();
            if (daftarPengeluaran.isEmpty()) {
                System.out.println("Tidak ada pengeluaran yang tersedia.");
            } else {
                for (int i = 0; i < daftarPengeluaran.size(); i++) {
                    Pengeluaran pengeluaran = daftarPengeluaran.get(i);
                    System.out.println("Pengeluaran ke-" + (i + 1) + ":");
                    System.out.println("Jumlah: " + pengeluaran.getJumlah());
                    System.out.println("Keterangan: " + pengeluaran.getKeterangan());
                    System.out.println();
                }
            }
        }

        private static void tambahHutang() {
            System.out.print("Masukkan jumlah hutang: ");
            double jumlah = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Siapa pemberi hutang: ");
            String pemberi = scanner.nextLine();
            Hutang hutangBaru = new Hutang(jumlah, pemberi);
            currentUser.tambahHutang(hutangBaru);
            System.out.println("hutang berhasil ditambahkan.");
        }

        private static void lihatHutang() {
            System.out.println("===== Daftar Hutang =====");
            List<Hutang> daftarHutang = currentUser.getDaftarHutang();
            if (daftarHutang.isEmpty()) {
                System.out.println("Tidak ada Hutang yang tersedia.");
            } else {
                for (int i = 0; i < daftarHutang.size(); i++) {
                    Hutang Hutang = daftarHutang.get(i);
                    System.out.println("Hutang ke-" + (i + 1) + ":");
                    System.out.println("Jumlah: " + Hutang.getJumlah());
                    System.out.println("Pemberi: " + Hutang.getPemberi());
                    System.out.println();
                }
            }
        }

        private static void tambahPiutang() {
            System.out.print("Masukkan jumlah piutang: ");
            double jumlah = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Siapa penerima piutang: ");
            String penerima = scanner.nextLine();
            Piutang piutangBaru = new Piutang(jumlah, penerima);
            currentUser.tambahPiutang(piutangBaru);
            System.out.println("piutang berhasil ditambahkan.");
        }

        private static void lihatPiutang() {
            System.out.println("===== Daftar Piutang =====");
            List<Piutang> daftarPiutang = currentUser.getDaftarPiutang();
            if (daftarPiutang.isEmpty()) {
                System.out.println("Tidak ada Piutang yang tersedia.");
            } else {
                for (int i = 0; i < daftarPiutang.size(); i++) {
                    Piutang Piutang = daftarPiutang.get(i);
                    System.out.println("Piutang ke-" + (i + 1) + ":");
                    System.out.println("Jumlah: " + Piutang.getJumlah());
                    System.out.println("Pemberi: " + Piutang.getPenerima());
                    System.out.println();
                }
            }
        }

        private static void lihatAnggaran() {
            // Tambahkan logika untuk melihat anggaran
            System.out.println("Lihat anggaran");
        }

        private static void keluarAplikasi() {
            System.out.println("Terima kasih telah menggunakan aplikasi keuangan kami.");
        }
    }