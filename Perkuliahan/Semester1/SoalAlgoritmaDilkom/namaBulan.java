package Semester1.SoalAlgoritmaDilkom;

import java.util.Scanner;

public class namaBulan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("--o0  Program Java Menentukan Nama Bulan 0o--");
        System.out.println("=========================================");
        System.out.println();

        int n;

        System.out.print("Input angka bulan (1-12): ");
        n = input.nextInt();

        if (n == 1) {
            System.out.println("Januari");
        } else if (n == 2) {
            System.out.println("Februari");
        } else if (n == 3) {
            System.out.println("Maret");
        } else if (n == 4) {
            System.out.println("April");
        } else if (n == 5) {
            System.out.println("Mei");
        } else if (n == 6) {
            System.out.println("Juni");
        } else if (n == 7) {
            System.out.println("Juli");
        } else if (n == 8) {
            System.out.println("Agustus");
        } else if (n == 9) {
            System.out.println("September");
        } else if (n == 10) {
            System.out.println("Oktober");
        } else if (n == 11) {
            System.out.println("November");
        } else if (n == 12) {
            System.out.println("Desember");
        } else {
            System.out.println("Pilihan tidak tersedia");
        }

    }
}
