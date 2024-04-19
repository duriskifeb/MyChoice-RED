package Semester1.MenengahKeatas.AsahOtakpakdhe;

import java.util.Scanner;

public class tiketOK {
    private int hargaTiket = 50; // Harga per tiket

    // Metode untuk menghitung total harga berdasarkan jumlah tiket yang akan dibeli
    public int hitungTotalHarga(int jumlahTiket) {
        return hargaTiket * jumlahTiket;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tiketOK aplikasi = new tiketOK();

        System.out.println("Selamat datang di Aplikasi Pembelian Tiket");

        System.out.print("Masukkan jumlah tiket yang akan dibeli: ");
        int jumlahTiket = scanner.nextInt();

        // Validasi jumlah tiket harus lebih dari 0
        if (jumlahTiket <= 0) {
            System.out.println("Jumlah tiket harus lebih dari 0. Program berhenti.");
            System.exit(0);
        }

        // Hitung total harga
        int totalHarga = aplikasi.hitungTotalHarga(jumlahTiket);

        // Menampilkan struk pembelian
        System.out.println("\n===== Struk Pembelian =====");
        System.out.println("Jumlah Tiket: " + jumlahTiket);
        System.out.println("Harga per Tiket: $" + aplikasi.hargaTiket);
        System.out.println("Total Harga: $" + totalHarga);
        System.out.println("===========================");

        scanner.close();
    }
}

