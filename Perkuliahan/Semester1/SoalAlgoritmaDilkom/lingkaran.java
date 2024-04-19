package Semester1.SoalAlgoritmaDilkom;

import java.util.Scanner;

public class lingkaran {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println(" ---> semangat rekk masa depanmu ditentukan bagaimana harimu hari ini <--- ");
        System.out.println("==============================================");
        System.out.println("|  Program Java Menghitung Luas Lingkaran     ");
        System.out.println("==============================================");
        System.out.println();

        double r, luas;

        System.out.print("Input jari-jari lingkaran: ");
        r = input.nextDouble();

        System.out.println("Luas lingkaran: " + 3.14 * r * r);

    }
}
