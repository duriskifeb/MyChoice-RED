package Semester1.MenengahKeatas.Rabu221123;
import java.util.Scanner;

public class segitigaAngka {
    public static void main(String args[]){
        
        // Panggil scanner
        Scanner input = new Scanner(System.in);
        
        // Menu awal
        int a;
        System.out.println("\t   ----o0 H! 0o----");
        System.out.print("    ( Masukkan ukuran segitiga ) : ");
        a = input.nextInt();
        System.out.println("\t   ----o0 H! 0o----");
        
        System.out.println();
        
      
        // Fungsi segitiga 2
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println(" ");
        }
        System.out.println();
        
        System.out.println("    ----> Sekian Terimakasih :) <----");
        
        System.out.println();
        
        // Tutup scanner
        input.close();
       
    }
    
}


