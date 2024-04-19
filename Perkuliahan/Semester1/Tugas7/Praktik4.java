package Semester1.Tugas7;

import java.util.Scanner;

public class Praktik4 {
    
    static Scanner inp = new Scanner(System.in);
    static int batas;
    
    public static void main(String[] args) {
        runThis();
    }

    static void runThis() {
        System.out.println("Penjumlahan bilangan genap");
        System.out.print("Masukkan batas : ");
        batas = inp.nextInt();
        inp.nextLine(); // Membersihkan newline yang mungkin tertinggal di buffer input
        daftarGenap(batas);
    }

    static void daftarGenap(int batas) {
        int sum = 0;
        for (int counter = 1; counter <= batas; counter++) {
            if ((counter % 2) == 0) {
                sum += counter;
                System.out.print(counter);

                if (counter != batas) {
                    System.out.print(" + ");
                }
            }
        }
        System.out.println(" = " + sum);
    }
}
