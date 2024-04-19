package Semester1.MenengahKeatas.AsahOtakpakdhe;

import java.util.Scanner;

public class sektalah {
    private int nilai;

    // Konstruktor untuk menginisialisasi nilai awal
    public sektalah(int nilaiAwal) {
        this.nilai = nilaiAwal;
    }

    // Metode untuk menambah nilai
    public void tambahNilai(int jumlah) {
        this.nilai += jumlah;
    }

    // Metode untuk merubah nilai
    public void ubahNilai(int nilaiBakooru) {
        this.nilai = nilaiBakooru;
    }

    // Metode untuk mengurangi nilai
    public void kurangiNilai(int jumlah) {
        this.nilai -= jumlah;
    }

    // Metode untuk mendapatkan nilai saat ini
    public int dapatkanNilai() {
        return this.nilai;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        System.out.print("Masukkan nilai awal: ");
        int nilaiAwal = scanner.nextInt();

        sektalah operasi = new sektalah(nilaiAwal);

        System.out.println("Nilai awal: " + operasi.dapatkanNilai());

        System.out.print("Masukkan jumlah untuk ditambah : ");
        int tambah = scanner.nextInt();
        operasi.tambahNilai(tambah);
        System.out.println("Setelah ditambah " + tambah + " hasilnya adalah : " + operasi.dapatkanNilai());

        System.out.print("Masukkan nilai baru: ");
        int nilaiBaru = scanner.nextInt();
        operasi.ubahNilai(nilaiBaru);
        System.out.println("Setelah diubah menjadi " + nilaiBaru + ": " + operasi.dapatkanNilai());

        System.out.print("Masukkan jumlah untuk dikurangi : ");
        int kurangi = scanner.nextInt();
        operasi.kurangiNilai(kurangi);
        System.out.println("Setelah dikurangi " + kurangi + " hasilnya adalah : " + operasi.dapatkanNilai());

        scanner.close();
    }
}
