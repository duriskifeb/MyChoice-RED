package Semester1.Tugas_uts;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

       
        System.out.println("Masukkan lima angka tiga digit:");
        

        for (int i = 1; i <= 5; i++) {
            System.out.print("Angka ke-" + i + ": ");
            int angka = input.nextInt();

            if (keValidan(angka)) {
                System.out.println(angka + " Valid");
            } else {
                System.out.println(angka + " Tidak valid");
            }
        }

        input.close();
    }

    
    public static boolean keValidan(int number) {
        return number >= 500 && number <= 999;
        
    }
}

