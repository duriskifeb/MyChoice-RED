package Semester1.SoalAlgoritmaDilkom;

import java.util.Scanner;

public class menuBerulang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int pilihan, ulang;

        do {
            System.out.println("================================");
            System.out.println("--o0  Daftar Menu Teh riski 0o--");
            System.out.println("================================");
            System.out.println("1. Teh Susu");
            System.out.println("2. Teh Thai Tea");
            System.out.println("3. Teh Red Velvet");
            System.out.println("4. Teh Avocado");
            System.out.println("5. Teh Tarik");
            System.out.println();

            System.out.print("Pilihan anda: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("Anda memilih Teh Susu");
                    break;
                case 2:
                    System.out.println("Anda memilih Teh Thai Tea");
                    break;
                case 3:
                    System.out.println("Anda memilih Teh Red Velvet");
                    break;
                case 4:
                    System.out.println("Anda memilih Teh Avocado");
                    break;
                case 5:
                    System.out.println("Anda memilih Teh Tarik");
                    break;
                default:
                    System.out.println("Menu tidak tersedia");
            }

            System.out.println();

            System.out.print("Ingin memilih menu lain (y/t)? ");
            ulang = input.next().charAt(0);

            System.out.println();
        } while (ulang != 't');

        System.out.println("Terimakasih...");
    }
}
