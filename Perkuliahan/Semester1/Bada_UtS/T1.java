package Semester1.Bada_UtS;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

            
        //menu
        System.out.println("|==============================|");
        System.out.println("|KONVERSI BILANGAN KE BINER    |");
        System.out.println("|==============================|");

        //user input
        System.out.print("Ubah biner : ");
        int in = input.nextInt();
        input.close();

        //cek panjang biner
        int index = 0;
        int cekIn = in;
        while(cekIn > 1){
            cekIn /= 2;
            index++;
        }
        
        //mengkonversi ke biner
        int[] biner = new int[index + 1];
        for(int i = index; i >= 0; i--){
            biner[i] = in % 2;
            in /= 2;
        }

        //print ke layar
        System.out.print("Biner : ");
        for(int i = 0; i <= index; i++) System.out.print(biner[i]); 

        System.out.println("\n");

    }
}
