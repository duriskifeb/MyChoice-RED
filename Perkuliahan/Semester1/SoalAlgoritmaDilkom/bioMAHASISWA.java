package Semester1.SoalAlgoritmaDilkom;

import java.util.Scanner;

public class bioMAHASISWA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("--o0  Program Java Biodata Mahasiswa 0o--");
        System.out.println("========================================");
        System.out.println();

        String nama, nim, fakultas, jurusan, kota_asal, alamat;

        System.out.print("Nama mahasiswa: ");
        nama = input.nextLine();

        System.out.print("NIM: ");
        nim = input.nextLine();

        System.out.print("Fakultas: ");
        fakultas = input.nextLine();

        System.out.print("Jurusan: ");
        jurusan = input.nextLine();

        System.out.print("Kota Asal: ");
        kota_asal = input.nextLine();

        System.out.print("Alamat: ");
        alamat = input.nextLine();

        System.out.println();

        System.out.println("======================");
        System.out.println("--> Data Mahasiswa <--");
        System.out.println("======================");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Fakultas: " + fakultas);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("Kota Asal: " + kota_asal);
        System.out.println("Alamat: " + alamat);
    }
}
