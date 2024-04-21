package PBO.Gojekin;

import PBO.Tumbas.Util;

public class Menu {
    private Gojek gojek;

    public Menu() {
        gojek = new Gojek();
    }

    public static void main(String[] args) {
        Menu main = new Menu();
        main.displayMenu();
    }

    public void displayMenu() {
        boolean loop = true;
        while (loop) {
            Utilitas.cls();
            System.out.println("\n Menu Gojek-in");
            System.out.println("----------------");
            System.out.println("1. Manajemen Member");
            System.out.println("2. Transaksi");
            System.out.println("3. Member dengan Saldo Terbanyak");
            System.out.println("4. Driver dengan Saldo Terbanyak");
            System.out.println("0. Keluar");

            System.out.print("\nPilih : ");
            int key = Util.inputInt();

            switch (key) {
                case 1:
                    displayMemberMenu();
                    break;
                case 2:
                    doTransaction();
                    break;
                case 3:
                    showTopMembers("Customer", 5);
                    break;
                case 4:
                    showTopMembers("Driver", 5);
                    break;
                case 0:
                    loop = false;
                    Utilitas.cls();
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void displayMemberMenu() {
        boolean ulang = true;
        while (ulang) {
            Utilitas.cls();
            System.out.println("\n----o0 MANAJEMEN MEMBER 0o----");
            System.out.println("\n1. Tambah Driver");
            System.out.println("2. Tambah Customer");
            System.out.println("3. Top Up Saldo");
            System.out.println("4. Lihat Data Driver");
            System.out.println("5. Lihat Data Customer");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("\nPilih  : ");
            int ab = Util.inputInt();
            switch (ab) {
                case 1:
                    addDriver();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    topUpSaldo();
                    break;
                case 4:
                    viewDriver();
                    break;
                case 5:
                    viewCustomer();
                    break;
                case 0:
                    ulang = false;
                    Util.cls();
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void addDriver() {
        Utilitas.cls();
        System.out.println("\n-----o0 TAMBAH DRIVER 0o-----");
        // Lakukan input data driver sesuai kebutuhan
        System.out.print("ID: ");
        String id = Util.inputLine();
        System.out.print("Nama: ");
        String nama = Util.inputLine();
        System.out.print("Telepon: ");
        String telepon = Util.inputLine();
        System.out.print("Plat Nomor: ");
        String platNo = Util.inputLine();
        System.out.print("Jenis Kendaraan: ");
        String jenisKendaraan = Util.inputLine();
        System.out.print("Saldo Awal: ");
        double saldo = Util.inputInt();
        // Tambahkan driver ke Gojek
        gojek.addDriver(id, nama, telepon, platNo, jenisKendaraan, saldo);
        Utilitas.pressEnter();
        Utilitas.cls();
    }

    private void addCustomer() {
        Utilitas.cls();
        System.out.println("\n-----o0 TAMBAH CUSTOMER 0o-----");
        // Lakukan input data customer sesuai kebutuhan
        System.out.print("ID: ");
        String id = Util.inputLine();
        System.out.print("Nama: ");
        String nama = Util.inputLine();
        System.out.print("Telepon: ");
        String telepon = Util.inputLine();
        System.out.print("Saldo Awal: ");
        double saldo = Util.inputInt();
        // Tambahkan customer ke Gojek
        gojek.addCustomer(id, nama, telepon, saldo);
        Utilitas.pressEnter();
        Utilitas.cls();
    }

    private void topUpSaldo() {
        Utilitas.cls();
        System.out.println("\n------o0 TOP UP SALDO 0o------");
        System.out.print("\nMasukkan ID member: ");
        String id = Util.inputLine();
        System.out.print("Masukkan jumlah saldo yang ingin ditambahkan: ");
        double amount = Util.inputInt();
        // Lakukan top up saldo
        gojek.topUpSaldo(id, amount);
        Utilitas.pressEnter();
        Utilitas.cls();
    }

    private void viewDriver() {
        Utilitas.cls();
        System.out.println("\n-----o0 LIHAT DATA DRIVER 0o-----");
        System.out.print("\nMasukkan ID driver: ");
        String id = Util.inputLine();
        // Tampilkan data driver
        gojek.viewDriver(id);
        Utilitas.pressEnter();
        Utilitas.cls();
    }

    private void viewCustomer() {
        Utilitas.cls();
        System.out.println("\n-----o0 LIHAT DATA CUSTOMER 0o-----");
        System.out.print("\nMasukkan ID customer: ");
        String id = Util.inputLine();
        // Tampilkan data customer
        gojek.viewCustomer(id);
        Utilitas.pressEnter();
        Util.cls();
    }

    private void doTransaction() {
        Utilitas.cls();
        System.out.println("\n------o0 TRANSAKSI 0o------");
        System.out.print("\nMasukkan ID driver: ");
        String driverId = Util.inputLine();
        System.out.print("Masukkan ID customer: ");
        String customerId = Util.inputLine();
        System.out.print("Masukkan jumlah transaksi: ");
        double amount = Util.inputInt();
       
        gojek.transaksi(driverId, customerId, amount);
        Utilitas.pressEnter();
        Util.cls();
    }

    private void showTopMembers(String type, int limit) {
        Utilitas.cls();
        System.out.println("\n-----o0 " + (type.equals("Customer") ? "MEMBER" : "DRIVER") + " TERBANYAK 0o-----"); // memakai type ternary.!
        gojek.showTopMembers(type, limit, true);
        Utilitas.pressEnter();
        Utilitas.cls();
    }

}
