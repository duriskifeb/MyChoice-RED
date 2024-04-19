package Semester1.Tugas7;


import java.util.Scanner;

public class TugasAkhir3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String next = "y";

        
        do {
            System.out.println("|==============================|");
            System.out.println("|\t MENGHITUNG KUADRAT    |");
            System.out.println("|==============================|");
            System.out.print("Masukkan angka : ");
            int angka = input.nextInt();
            input.nextLine();

            if (angka > 0) {
                int sum = 0;
                int ctr = 1;

                while (ctr <= angka) {
                    sum += ctr * ctr;
                    System.out.print(ctr * ctr);

                    for (int i = ctr; i != angka; i = angka)
                        System.out.print(" + ");
                    ctr++;
                }
                System.out.print(" = " + sum);
            } else {
                System.out.println("Input anda tidak valid");
            }
            
            System.out.println();
            System.out.println("\n     ====> Terimakasih <====");
            System.out.print("\nLanjut?(Nggeh/Mboten) : ");
            next = input.nextLine();
        } while (next.equals("Nggeh"));
    }
}