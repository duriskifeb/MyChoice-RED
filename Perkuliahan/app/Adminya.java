package Perkuliahan.app;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Concert {
    private int availableTickets;

    public Concert(int jumlah) {
        this.availableTickets = jumlah;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void increaseTickets(int amount) {
        if (amount > 0) {
            availableTickets += amount;
            System.out.println(amount + " tiket ditambahkan. Total tiket adalah: " + availableTickets);
        } else {
            System.out.println("Input tidak valid.");
        }
    }

    public void decreaseTickets(int amount) {
        if (amount > 0 && amount <= availableTickets) {
            availableTickets -= amount;
            System.out.println(amount + " tiket dihapus. Total tiket yang tersedia: " + availableTickets);
        } else {
            System.out.println("Jumlah tiket yang akan dihapus tidak valid atau tiket yang tersedia tidak mencukupi.");
        }
    }
}

public class Adminya {

    ArrayList<Konser> dataKonser = new ArrayList<>();

    // ini buat user yaa...
    public void showMenuAdmin(ArrayList<Konser> daftarKonser) {
        dataKonser = daftarKonser;
        Run.displayAdminMenu();
        System.out.println("\n--o0 Selamat datang di Ademin 0o--\n");

        Concert concert = new Concert(50); // Jumlah Tiket Awal
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("1. Tambahkan Tiket");
            System.out.println("2. Kurangi Tiket");
            System.out.println("3. Cek Tiket Yang Tersedia");
            System.out.println("4. Logout");
            System.out.println("0. Keluar dari aplikasi\n");
            System.out.print("Pilih Salah Satu Menu: ");
            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    Run run = new Run();
                    run.viewKonser(dataKonser);
                    tambahTiket();
                    break;

                case 2:
                    // System.out.print("Masukkan Nomor Untuk Mengurangi Jumlah Tiket: ");
                    // int removeTickets = scanner.nextInt();
                    // concert.decreaseTickets(removeTickets);
                    Run ing = new Run();
                    ing.viewKonser(dataKonser);
                    kurangTiket();
                    // Jumlah Tiket Awal

                    break;

                case 3:
                    Run cuy = new Run();
                    cuy.viewKonser(dataKonser);
                    break;

                case 4:
                    loop = false;
                    // ");
                    break;

                case 5:
                    break;
                case 6:
                    tambahKonser();
                    break;
                case 0:
                    System.out.println("0. Menutup Apliksai\n");
                    System.out.print("sedang menutup aplikasi ");
                    loadingMessage();
                    CloseAPK();
                    System.exit(0);

                default:
                    System.out.println("Pilihan Invalid, Silahkan Pilih Option Yang Ada.");
                    scanner.close();
            }
        }
    }

    public void tambahKonser() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nama Konser");
        String namaKonser = scanner.nextLine();
    }

    public ArrayList<Konser> updateArray() {
        return dataKonser;
    }

    // ini untuk menambahkan tiket customer
    public void tambahTiket() {
        Run run = new Run();
        run.viewKonser(dataKonser);

        Scanner input = new Scanner(System.in);

        System.out.print("Pilih konser (0-" + (dataKonser.size() - 1) + "): ");
        int pilihanKonser = input.nextInt();

        if (pilihanKonser == 0) {
            System.out.println("Terima kasih. Selamat tinggal!");
            return;
        }

        if (pilihanKonser >= 1 && pilihanKonser <= dataKonser.size()) {
            Konser konserPilihan = dataKonser.get(pilihanKonser - 1);
            ArrayList<Tiket> daftarTiket = konserPilihan.getDaftarTiket();

            if (daftarTiket.isEmpty()) {
                System.out.println("Tidak ada jenis tiket yang tersedia.");
                return;
            }

            System.out.println("\nDaftar Jenis Tiket untuk " + konserPilihan.getNamaKonser() + ":\n");

            for (int i = 0; i < daftarTiket.size(); i++) {
                Tiket tiket = daftarTiket.get(i);
                System.out.println(i + 1 + ". " + tiket.getJenis() + " - Stok: " + tiket.getJumlah());
            }

            System.out.print("Pilih jenis tiket yang akan ditambahkan (1-" + daftarTiket.size() + "): ");
            int pilihanTiket = input.nextInt();

            if (pilihanTiket >= 1 && pilihanTiket <= daftarTiket.size()) {
                Tiket tiketPilihan = daftarTiket.get(pilihanTiket - 1);

                System.out.print("\nMasukkan jumlah tiket yang akan ditambahkan: ");
                int jumlahTambah = input.nextInt();

                tiketPilihan.tambahJumlah(jumlahTambah);

                System.out.println(jumlahTambah + " tiket " + tiketPilihan.getJenis() + " ditambahkan.\n");
            } else {
                System.out.println("Pilihan jenis tiket tidak valid.");
            }
        } else {
            System.out.println("Pilihan konser tidak valid.");
        }
    }

    // ini untuk mengurangi tiket customer
    public void kurangTiket() {
        Run ing = new Run();
        ArrayList<Konser> daftarKonser = dataKonser;

        Scanner input = new Scanner(System.in);

        // Ambil pilihan konser dari pengguna
        System.out.print("Pilih konser (0-" + (daftarKonser.size() - 1) + "): ");
        int pilihanKonser = input.nextInt();

        if (pilihanKonser == 0) {
            System.out.println("Terima kasih. Selamat tinggal!");
            return; // Keluar dari metode jika pilihan 0
        }

        if (pilihanKonser >= 1 && pilihanKonser <= daftarKonser.size()) {
            Konser konserPilihan = daftarKonser.get(pilihanKonser - 1);
            ArrayList<Tiket> riwayatTiket = konserPilihan.getDaftarTiket();

            if (riwayatTiket.isEmpty()) {
                System.out.println("Tidak ada jenis tiket yang tersedia.");
                return;
            }

            System.out.println("\nDaftar Tiket untuk => " + konserPilihan.getNamaKonser() + " :\n");

            // Menampilkan dan memperbarui stok tiket
            for (int i = 0; i < riwayatTiket.size(); i++) {
                Tiket tiket = riwayatTiket.get(i);
                System.out
                        .println(tiket.getJenis() + " - Rp " + tiket.getHarga() + " (Stok: " + tiket.getJumlah() + ")");
            }

            // Pilih jenis tiket
            System.out.println("0. Tidak beli tiket");

            int pilihanTiket;
            do {
                System.out
                        .print("Pilih jenis tiket (1-" + riwayatTiket.size() + ") atau 9 untuk selesai mengurangi : ");
                pilihanTiket = input.nextInt();
                System.out.println();

                if (pilihanTiket == 0) {
                    System.out.println("Anda memilih untuk tidak membeli tiket. Terima kasih!");
                    return; // Keluar dari metode jika pilihan 0
                }

                if (pilihanTiket == 9) {
                    System.out.println("Keluar dari pengurangan tiket dan kembali ke Menu Admin.");
                    return;
                }

                if (pilihanTiket >= 1 && pilihanTiket <= riwayatTiket.size()) {
                    Tiket tiketPilihan = riwayatTiket.get(pilihanTiket - 1);

                    System.out.print("\nMasukkan jumlah tiket yang akan dikurangi: ");
                    int jumlahKurang = input.nextInt();

                    tiketPilihan.kurangJumlah(jumlahKurang);

                    System.out.println(jumlahKurang + " tiket " + tiketPilihan.getJenis() + " dikurangi.\n");
                } else {
                    System.out.println("Pilihan jenis tiket tidak valid.");
                }
            } while (pilihanTiket != 0 && pilihanTiket != 9);
        } else {
            System.out.println("Pilihan konser tidak valid.");
        }
    }

    // untuk menutup Aplikasi
    public static void CloseAPK() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        } catch (Exception e) {
            System.err.println("Terjadi kesalahan: " + e);
        }
    }

    // implementasi loading ketika aplikasi keluar
    public static void loadingMessage() {
        try {
            // Simulate loading by printing dots with a delay
            for (int i = 0; i < 3; i++) {
                System.out.print(".");
                Thread.sleep(500); // Sleep for 1 second
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}