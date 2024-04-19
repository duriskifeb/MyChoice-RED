package Semester1.SoalAlgoritmaDilkom;

import java.util.Scanner;

class BelahKetupat{
    public static void main(String args[]){
        
        Scanner input = new Scanner(System.in);

        int a;

        System.out.println("MEMBUAT POLA BELAH KETUPAT");
        System.out.println("==============================");
        
        System.out.print("Masukkan ukuran: ");
        a = input.nextInt();

        System.out.println("==============================");
        
        for(int i = 1; i <= a; i++){
            for(int k = a; k >= i; k--){
                System.out.print(" ");
            }

            for(int j = 1; j <= i; j++){
                System.out.print(" +");
            }
            System.out.println();
        }

        for(int i = 1; i <= a; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(" ");
            }

            for(int k = a - 1; k >= i; k--){
                System.out.print(" +");
            }
            System.out.println();
        }
        input.close();
    }
}
