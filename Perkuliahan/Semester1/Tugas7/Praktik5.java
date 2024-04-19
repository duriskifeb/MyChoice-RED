package Semester1.Tugas7;
import java.util.Random;
import java.util.Scanner;

public class Praktik5 {
    Scanner inp = new Scanner(System.in);
    int nilai;
    int tebakan;
    int max;
    int min;
    int counter;

    public static void main(String[] args) {
        Praktik5 db = new Praktik5();
        db.runthis();
    }

    void runthis() {
        int tebak;
        Random gen = new Random();
        nilai = gen.nextInt(100);
        max = 100;
        min = 0;
        counter = 0;
        do {
            System.out.print("Tebak angka antara " + min + " - " + max + " : ");
            tebak = inp.nextInt();
            if ((tebak >= min) && (tebak <= max)) {
                if (tebak == nilai)
                    System.out.println("\n[ tebakan anda benar ]\n");
                else if (tebak > nilai) {
                    System.out.println("tebakan anda lebih besar\n");
                    max = tebak;
                } else {
                    System.out.println("tebakan anda lebih kecil\n");
                    min = tebak;
                    System.out.println();
                }
            } else {
                System.out.println("Tebakan diluar rentang\n");
                System.out.println("Tebak antara " + min + " dan " + max);
            }
            counter = counter + 1;
        } while (tebak != nilai);
        System.out.println("Nilai yang dicari adalah : " + nilai);
        System.out.println("Selamat anda berhasil menebak dalam " + counter + " kali");
    }
}