    package object;

    import java.util.ArrayList;
    import java.util.List;

    public class User {
        private String name;
        private String email;
        private String password;
        private List<Pendapatan> daftarPendapatan;
        private List<Pengeluaran> daftarPengeluaran;
        private Anggaran anggaran;
        private List<Hutang> daftarHutang;
        private List<Piutang> daftarPiutang;

        public User(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.daftarPendapatan = new ArrayList<>();
            this.daftarPengeluaran = new ArrayList<>();
            this.daftarHutang = new ArrayList<>();
            this.daftarPiutang = new ArrayList<>();
        }

        public void tambahPendapatan(Pendapatan pendapatan) {
            this.daftarPendapatan.add(pendapatan);
        }

        public void tambahPengeluaran(Pengeluaran pengeluaran) {
            this.daftarPengeluaran.add(pengeluaran);
        }

        public void tampilkanAnggaran() {
            System.out.println("Anggaran Anda adalah: " + anggaran.getJumlah());
        }

        public void tampilkanDaftarHutang() {
            System.out.println("===== Daftar Hutang =====");
            for (Hutang hutang : daftarHutang) {
                System.out.println("Hutang kepada " + hutang.getPemberi() + ": " + hutang.getJumlah());
            }
        }
        
        public void tampilkanDaftarPiutang() {
            System.out.println("===== Daftar Piutang =====");
            for (Piutang piutang : daftarPiutang) {
                System.out.println("Piutang dari " + piutang.getPenerima() + ": " + piutang.getJumlah());
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassWord() {
            return password;
        }

        public void setPassWord(String password) {
            this.password = password;
        }

        public void display(){
            System.out.println("name : " + this.name + " Email : " + this.email + " Password : " + this.password);
        }
    }
