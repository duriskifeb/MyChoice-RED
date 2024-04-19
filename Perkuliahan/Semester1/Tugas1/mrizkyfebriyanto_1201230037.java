package Semester1.Tugas1;
import java.util.Scanner;

public class mrizkyfebriyanto_1201230037 {
    
    public static void main(String[] args ){
        
        Scanner input = new Scanner(System.in);        
        int angka;

        System.out.println("==============================");
        System.out.print("Masukksn input: ");
        angka = input.nextInt();
        System.out.println("==============================");

        if(angka % 2 == 0){
            System.out.printf("%d adalah bilangan genap",angka);
        }
        else{
            System.out.printf("%d adalah bilangan ganjil",angka);
        }
        System.out.println("\n==============================");

        input.close();
    }
}
