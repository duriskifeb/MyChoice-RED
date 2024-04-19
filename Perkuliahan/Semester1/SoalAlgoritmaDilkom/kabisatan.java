package Semester1.SoalAlgoritmaDilkom;

import java.util.Scanner;

public class kabisatan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("  ======================================");
        System.out.println("--o0  Program Java Cek Tahun Kabisat  0o--");
        System.out.println("  ======================================");
        System.out.println();

        int year;

        System.out.print("Input tahun: ");
        year = input.nextInt();

        if (year % 400 == 0) {
            System.out.println(year + " adalah tahun kabisat");
        } else if (year % 100 == 0) {
            System.out.println(year + " bukan tahun kabisat");
        } else if (year % 4 == 0) {
            System.out.println(year + " adalah tahun kabisat");
        } else {
            System.out.println(year + " bukan tahun kabisat");
        }

    }
}
