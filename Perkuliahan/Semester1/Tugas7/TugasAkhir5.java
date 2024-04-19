package Semester1.Tugas7;

import java.util.Scanner;

public class TugasAkhir5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String next = "Nggeh";

        do {
            System.out.println("|==============================|");
            System.out.println("|\t MENGHITUNG FAKTORIAL  |");
            System.out.println("|==============================|");
            System.out.print("Masukkan angka : ");
            int angka = input.nextInt();
            input.nextLine();

            if (angka > 0) {
                int sum = 1;

                System.out.print(angka + "! = ");
                while(angka > 0){
                    sum *= angka;
                    System.out.print(angka);

                    if(angka != 1){
                        System.out.print(" x ");
                    }
                    angka--;
                }
                System.out.println(" = " + sum);

            } else {
                System.out.println("Input anda tidak valid");
            }

            System.out.println("\n    0o====> Terimaksih <====o0");
            System.out.print("\nLanjut?(Nggeh/Mboten) : ");
            next = input.nextLine();
        } while (next.equals("Nggeh"));
    }
}

// int hasil = 1;
// for(int i = in; i > 0; i--) {
// hasil *= i;
// }