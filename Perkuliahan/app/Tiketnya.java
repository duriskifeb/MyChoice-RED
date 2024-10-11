package Perkuliahan.App;


import java.util.ArrayList;
import java.util.Scanner;

public class Tiketnya {
    public static void main(String[] args) {
        // Inisialisasi data tiket
        ArrayList<Tiket> daftarTiket = new ArrayList<>();
        daftarTiket.add(new Tiket("Reguler", 50000, 50));
        daftarTiket.add(new Tiket("VIP", 100000, 30));
        daftarTiket.add(new Tiket("VVIP", 150000, 20));

        // Input pilihan tiket
        Scanner input = new Scanner(System.in);
        System.out.println("Daftar Tiket:");
        for (int i = 0; i < daftarTiket.size(); i++) {
            Tiket tiket = daftarTiket.get(i);
            System.out.println((i + 1) + ". " + tiket.getJenis() + " - Rp " + tiket.getHarga() + " (Stok: "
                    + tiket.getJumlah() + ")");
        }

        System.out.print("Pilih jenis tiket (1-3): ");
        int pilihanTiket = input.nextInt();

        // Input jumlah tiket yang akan dibeli
        System.out.print("Masukkan jumlah tiket yang akan dibeli: ");
        int jumlahBeli = input.nextInt();

        // Validasi pilihan tiket
        if (pilihanTiket >= 1 && pilihanTiket <= daftarTiket.size()) {
            Tiket tiketPilihan = daftarTiket.get(pilihanTiket - 1);

            // Validasi jumlah tiket yang akan dibeli
            if (jumlahBeli > 0 && jumlahBeli <= tiketPilihan.getJumlah()) {
                // Hitung total harga
                int totalHarga = tiketPilihan.getHarga() * jumlahBeli;
                System.out.println("Total Harga: Rp " + totalHarga);

                // Input pembayaran
                System.out.print("Masukkan jumlah uang yang dibayarkan: Rp ");
                int jumlahBayar = input.nextInt();

                // Validasi pembayaran
                if (jumlahBayar >= totalHarga) {
                    // Proses transaksi
                    int kembalian = jumlahBayar - totalHarga;
                    tiketPilihan.kurangiJumlah(jumlahBeli);

                    System.out.println("Transaksi Berhasil!");
                    System.out.println("Terima kasih telah berbelanja.");
                    System.out.println("Kembalian: Rp " + kembalian);

                    // Tampilkan stok tiket setelah transaksi
                    System.out
                            .println("Stok Tiket " + tiketPilihan.getJenis() + " tersisa: " + tiketPilihan.getJumlah());
                } else {
                    System.out.println("Pembayaran tidak mencukupi.");
                }
            } else {
                System.out.println("Jumlah tiket yang dibeli tidak valid.");
            }
        } else {
            System.out.println("Pilihan tiket tidak valid.");
        }
    }
}

class Tiket {
    private String jenis;
    private int harga;
    private int jumlah;

    public Tiket(String jenis, int harga, int jumlah) {
        this.jenis = jenis;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public String getJenis() {
        return jenis;
    }

    public int getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void kurangiJumlah(int jumlah) {
        if (jumlah <= this.jumlah) {
            this.jumlah -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi.");
        }
    }
}