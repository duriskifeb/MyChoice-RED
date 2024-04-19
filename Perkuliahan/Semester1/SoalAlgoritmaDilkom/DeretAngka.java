package Semester1.SoalAlgoritmaDilkom;

import java.util.Scanner;

public class DeretAngka {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int jumlah_deret, i;


        System.out.println("====================================");
        System.out.print("Jumlah deret yang diinginkan berapa : ");
        


        jumlah_deret = input.nextInt();
        System.out.println();

        for (i = 1; i <= jumlah_deret; i++) {
            System.out.print(i*3+ " ");
        }

        System.out.println();
    }
}
