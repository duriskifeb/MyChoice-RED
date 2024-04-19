package Semester1.SoalAlgoritmaDilkom;

import java.util.Scanner;

public class persegian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("________________________________");
        System.out.println("| bangunan java dari algoritma |");
        System.out.println("________________________________");

        int panjang, lebar, a, b;
        
        

        System.out.print("Input panjang :");
        panjang = input.nextInt();

        System.out.print("input lebar :");
        lebar = input.nextInt();

        System.out.println();



        for (a = 1; a <= lebar; a++) {
            for (b = 1; b <= panjang; b++) {

                System.out.print(" * ");
            }
            System.out.println();
        }

        System.out.println();

        
        int luas = panjang * lebar;
        System.out.println("luas : " + luas);

        int keliling = 2 * (panjang + lebar);
        System.out.println("keliling : " + keliling);
        


        

       
       
        
    }
}
