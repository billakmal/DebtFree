    import object.User;
    import java.util.Scanner;
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
                scanner.nextLine();

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
            String sql = "SELECT * FROM users WHERE (username = ? OR email = ?) AND password = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userInput);
            preparedStatement.setString(2, userInput);
            preparedStatement.setString(3, kataSandi);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String namaPengguna = resultSet.getString("username");
                System.out.println("Login berhasil sebagai " + namaPengguna);
                currentUser = new User(namaPengguna, sql, namaPengguna);
                currentUser.setId(resultSet.getInt("user_id")); 
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
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
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
        double totalPendapatan = getTotalPendapatan();
        double totalPengeluaran = getTotalPengeluaran();
        double danaSaatIni = totalPendapatan - totalPengeluaran;
        System.out.println("Saldo Saat Ini : " + danaSaatIni);
        System.out.println("1. Menu Pendapatan");
        System.out.println("2. Menu Pengeluaran");
        System.out.println("3. Menu Hutang");
        System.out.println("4. Menu Piutang");
        System.out.println("5. Keluar");
        System.out.print("Pilihan Anda: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); 

        switch (pilihan) {
            case 1:
                menuPendapatan();
                break;
            case 2:
                menuPengeluaran();
                break;
            case 3:
                menuHutang();
                break;
            case 4:
                menuPiutang();
                break;
            case 5:
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
            try {
                System.out.print("Masukkan jumlah pendapatan: ");
                double jumlah = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Masukkan sumber pendapatan: ");
                String sumber = scanner.nextLine();
        
                String sql = "INSERT INTO pendapatan (user_id, jumlah_pendapatan, sumber_pendapatan) VALUES (?, ?, ?)";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, currentUser.getId());
                preparedStatement.setDouble(2, jumlah);
                preparedStatement.setString(3, sumber);
        
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Pendapatan berhasil ditambahkan.");
                } else {
                    System.out.println("Gagal menambahkan pendapatan.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private static void lihatPendapatan() {
            System.out.println("===== Daftar Pendapatan =====");
            try {
                String sql = "SELECT * FROM pendapatan WHERE user_id = ?";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, currentUser.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
        
                int count = 0;
                while (resultSet.next()) {
                    count++;
                    double jumlah = resultSet.getDouble("jumlah_pendapatan");
                    String sumber = resultSet.getString("sumber_pendapatan");
                    System.out.println("Pendapatan ke-" + count + ":");
                    System.out.println("Jumlah: " + jumlah);
                    System.out.println("Sumber: " + sumber);
                    System.out.println();
                }
        
                if (count == 0) {
                    System.out.println("Tidak ada pendapatan yang tersedia.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private static void tambahPengeluaran() {
            try {
                System.out.print("Masukkan jumlah pengeluaran: ");
                double jumlah = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Masukkan keterangan pengeluaran: ");
                String keterangan = scanner.nextLine();
        
                String sql = "INSERT INTO pengeluaran (user_id, jumlah_pengeluaran, keterangan_pengeluaran) VALUES (?, ?, ?)";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, currentUser.getId());
                preparedStatement.setDouble(2, jumlah);
                preparedStatement.setString(3, keterangan);
        
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Pengeluaran berhasil ditambahkan.");
                } else {
                    System.out.println("Gagal menambahkan pengeluaran.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        private static void lihatPengeluaran() {
            System.out.println("===== Daftar Pengeluaran =====");
            try {
                String sql = "SELECT * FROM pengeluaran WHERE user_id = ?";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, currentUser.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
        
                int count = 0;
                while (resultSet.next()) {
                    count++;
                    double jumlah = resultSet.getDouble("jumlah_pengeluaran");
                    String keterangan = resultSet.getString("keterangan_pengeluaran");
                    System.out.println("Pengeluaran ke-" + count + ":");
                    System.out.println("Jumlah: " + jumlah);
                    System.out.println("Keterangan: " + keterangan);
                    System.out.println();
                }
        
                if (count == 0) {
                    System.out.println("Tidak ada pengeluaran yang tersedia.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private static void tambahHutang() {
            try {
                System.out.print("Masukkan jumlah hutang: ");
                double jumlah = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Masukkan pemberi hutang: ");
                String pemberi = scanner.nextLine();
        
                String sql = "INSERT INTO hutang (user_id, jumlah_hutang, pemberi_hutang) VALUES (?, ?, ?)";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, currentUser.getId());
                preparedStatement.setDouble(2, jumlah);
                preparedStatement.setString(3, pemberi);
        
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Hutang berhasil ditambahkan.");
                } else {
                    System.out.println("Gagal menambahkan hutang.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        private static void lihatHutang() {
            System.out.println("===== Daftar Hutang =====");
            try {
                String sql = "SELECT * FROM hutang WHERE user_id = ?";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, currentUser.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
        
                int count = 0;
                while (resultSet.next()) {
                    count++;
                    double jumlah = resultSet.getDouble("jumlah_hutang");
                    String pemberi = resultSet.getString("pemberi_hutang");
                    System.out.println("Hutang ke-" + count + ":");
                    System.out.println("Jumlah: " + jumlah);
                    System.out.println("Pemberi: " + pemberi);
                    System.out.println();
                }
        
                if (count == 0) {
                    System.out.println("Tidak ada hutang yang tersedia.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        private static void tambahPiutang() {
            try {
                System.out.print("Masukkan jumlah piutang: ");
                double jumlah = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Masukkan penerima piutang: ");
                String penerima = scanner.nextLine();
        
                String sql = "INSERT INTO piutang (user_id, jumlah_piutang, penerima_piutang) VALUES (?, ?, ?)";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, currentUser.getId());
                preparedStatement.setDouble(2, jumlah);
                preparedStatement.setString(3, penerima);
        
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Piutang berhasil ditambahkan.");
                } else {
                    System.out.println("Gagal menambahkan piutang.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        private static void lihatPiutang() {
            System.out.println("===== Daftar Piutang =====");
            try {
                String sql = "SELECT * FROM piutang WHERE user_id = ?";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, currentUser.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
        
                int count = 0;
                while (resultSet.next()) {
                    count++;
                    double jumlah = resultSet.getDouble("jumlah_piutang");
                    String penerima = resultSet.getString("penerima_piutang");
                    System.out.println("Piutang ke-" + count + ":");
                    System.out.println("Jumlah: " + jumlah);
                    System.out.println("Penerima: " + penerima);
                    System.out.println();
                }
        
                if (count == 0) {
                    System.out.println("Tidak ada piutang yang tersedia.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private static double getTotalPendapatan() {
            double totalPendapatan = 0;
            try {
                String sql = "SELECT SUM(jumlah_pendapatan) AS total FROM pendapatan WHERE user_id = ?";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, currentUser.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    totalPendapatan = resultSet.getDouble("total");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return totalPendapatan;
        }

        private static double getTotalPengeluaran() {
            double totalPengeluaran = 0;
            try {
                String sql = "SELECT SUM(jumlah_pengeluaran) AS total FROM pengeluaran WHERE user_id = ?";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, currentUser.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    totalPengeluaran = resultSet.getDouble("total");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return totalPengeluaran;
        }

        private static void keluarAplikasi() {
            System.out.println("Terima kasih telah menggunakan aplikasi keuangan kami.");
        }
    }