    package object;

    import java.util.ArrayList;
    import java.util.List;

    public class User {
        private int id;
        private String name;
        private String email;
        private String password;
        private List<Pendapatan> daftarPendapatan;
        private List<Pengeluaran> daftarPengeluaran;
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

        public void tambahHutang(Hutang hutang) {
            this.daftarHutang.add(hutang);
        }

        public void tambahPiutang(Piutang piutang) {
            this.daftarPiutang.add(piutang);
        }

        public int getId(){
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
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

        public List<Pendapatan> getDaftarPendapatan() {
            return this.daftarPendapatan;
        }

        public List<Pengeluaran> getDaftarPengeluaran() {
            return this.daftarPengeluaran;
        }

        public List<Hutang> getDaftarHutang() {
            return this.daftarHutang;
        }

        public List<Piutang> getDaftarPiutang() {
            return this.daftarPiutang;
        }

        public void display(){
            System.out.println("name : " + this.name + " Email : " + this.email + " Password : " + this.password);
        }
    }
