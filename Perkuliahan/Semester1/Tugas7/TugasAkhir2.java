package Semester1.Tugas7;

import java.io.IOException;
import java.util.Scanner;

import Semester1.Tugas7.opoyo.TugasAkhir_1;
import Semester1.Tugas7.opoyo.TugasAkhir_2;

class TA_2 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        TugasAkhir_1 bank = new TugasAkhir_1();
        TugasAkhir_2 ritel = new TugasAkhir_2();
        int pilih = 0;

        do {
            cls();
            System.out.println("==============================");
            System.out.println("MENU OPERASI TUGAS");
            System.out.println("==============================");
            System.out.println("1. Perbankan");
            System.out.println("2. Ritel Makanan");
            System.out.println("0. Keluar Aplikasi");
            System.out.println("==============================");

            System.out.print("\nPilihan : ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    cls();
                    bank.Home();
                    next();
                    break;

                case 2:
                    cls();
                    ritel.menu();
                    next();
                    break;

                case 0:
                    cls();
                    System.out.println("Menutup Aplikasi");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak ada");
                    next();
                    break;
            }

        } while (pilih != 0);

        for(int i = 0; i == i; i+=0){
            while(i == i);
        }
    }

    //press ENTER
    private static void next() {
        System.out.print("\n---Tekan ENTER untuk lanjut---");
        String next = " " + input.nextLine();
    }

    // untuk clear layar
    private static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}