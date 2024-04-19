package Semester1.SoalAlgoritmaDilkom;

import java.util.Scanner;

// import semester1.Belajar.casting;

public class GajiKaryawan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("  ----o0 H! 0o----");
        System.out.println("Hitung gaji Karyawan  ");
        System.out.println("  ----o0 H! 0o----");

        System.out.println();
        String nama;
        char golongan;
        int jam_kerja = 0, upah_per_jam = 0, total_upah;

        System.out.print("Nama Karyawan: ");
        nama = input.nextLine();

        System.out.print("Golongan: ");
        golongan = input.next().charAt(0);

        System.out.print("Jumlah jam kerja: ");
        jam_kerja = input.nextInt();

        System.out.println();

        // tentukan jumlah upah per jam berdasarkan golongan
        switch (golongan) {
            case 'A':
                upah_per_jam = 5000;
                break;
            case 'B':
                upah_per_jam = 7000;
                break;
            case 'C':
                upah_per_jam = 8000;
                break;
            case 'D':
                upah_per_jam = 10000;
                break;
        }

        total_upah = jam_kerja * upah_per_jam;

        // cek apakah jam kerja lebih dari 48 jam
        if ((jam_kerja - 48) > 0) {
            total_upah = total_upah + ((jam_kerja - 48) * 4000);
        }

        // proses output
        System.out.println(nama + " menerima upah Rp." + total_upah
                + " per minggu");
    }
    
}
