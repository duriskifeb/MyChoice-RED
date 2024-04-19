package Semester1.MenengahKeatas.Rabu221123;

import java.util.Scanner;

public class Diagonal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("----o0 H! 0o----");
        System.out.print("Masukkan ukuran : ");
        int tinggi = input.nextInt();
        System.out.println("----o0 H! 0o----");
        input.close();
        System.out.println();

        // Looping diagonal R
        System.out.println("Looping diagonal R");
        diagR(tinggi);
        System.out.println();

        // Looping diagonal L
        System.out.println("Looping diagonal L");
        diagL(tinggi);
        System.out.println();

        // Looping Segitiga
        System.out.println("Looping Segitiga");
        segitiga(tinggi);
        System.out.println();

    }

    static void diagL(int tinggi) {
        int ctr = 1;
        while (ctr <= tinggi) {
            int angka = tinggi;
            while (angka >= ctr) {
                System.out.print(" ");
                angka--;
            }
            System.out.print("*");
            System.out.println();
            ctr++;
        }
    }

    static void diagR(int tinggi) {
        int ctr = 1;
        while (ctr <= tinggi) {
            int angka = 1;
            while (angka <= ctr) {
                System.out.print(" ");
                angka++;
            }
            System.out.print("*");
            System.out.println();
            ctr++;
        }
    }

    static void segitiga(int tinggi) {
        int ctr = 1;
        while (ctr <= tinggi) {
            int angka = 1;
            while (angka <= ctr) {
                System.out.print(" " + angka);
                angka++;
            }
            System.out.println();
            ctr++;
        }
    }
}
