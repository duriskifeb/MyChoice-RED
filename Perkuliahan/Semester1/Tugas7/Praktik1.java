package Semester1.Tugas7;

import java.util.Scanner;

public class Praktik1 {
    Scanner inp = new Scanner(System.in);
     int batas;

    
    public static void main(String[] args) {
        Praktik1 db = new Praktik1();
        db.runThis();
    }

    void runThis() {
        System.out.println();
        System.out.println("Deret nilai");
        System.out.print("Masukkan batas : ");
        batas = inp.nextInt();
        daftarGenap(batas);
    }


    void daftarGenap(int batas) {
        int counter = 1;
        System.out.print("Daftar Nilai Genap : ");

        while (counter <= batas) {
            if ((counter % 2) == 0) {
                System.out.print(counter + " ");
            }
            counter++;
        }
    }
}
