package Semester1.Bada_UtS;

import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

         //menu
        System.out.println("|--------------------------|");
        System.out.println("|MENGECEK BILANGAN PRIMA   |");
        System.out.println("|--------------------------|");
        System.out.println();

        //user input
        System.out.print("Masukkan input : ");
        int in = input.nextInt();

        
        //membuat variabel pengecekan
        int sisa = 1;
        int[] cekPrima = new int[in];
        for(int i = 0; i < (in-2); i++) {
            cekPrima[i] = i + 2;

            //melakukan pengecekan
            while(sisa > 0){
                sisa = in % cekPrima[i];
                break;
            }
        }

        //print ke layar
        if(sisa == 0){
            System.out.println(in + " bukan bilangan prima");
        } else {
            System.out.println(in + " adalah bilangan prima");
        }

        System.out.println();
        System.out.println("----> terimakasih yaa <----");
    }
}
