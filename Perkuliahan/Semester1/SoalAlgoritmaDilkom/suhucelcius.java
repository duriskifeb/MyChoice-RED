package Semester1.SoalAlgoritmaDilkom;

import java.util.Scanner;

public class suhucelcius {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=====---> Konfrensi Suhu <---=====");
        System.out.println();

        double celc, fahr, kelv, ream;

        System.out.print("Input Suhu celcius : ");
        celc = input.nextDouble();

        fahr = (9.0/5.0 * celc) + 32;
        kelv = celc + 273.15;
        ream = celc * (4.0/5.0);

        System.out.println(celc + "derajat Celcius + " + fahr + " derajat farenheint");
        System.out.println(celc + "derajat Celcius + " + kelv + " derajat farenheint");
        System.out.println(celc + "derajat Celcius + " + ream + " derajat farenheint");

    }
}
