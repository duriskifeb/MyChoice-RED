package Semester1.Bada_UtS;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("|==============================================|");
        System.out.print("|Masukkan bilangan untuk dihitung faktorialnya |:  ");
        int number = input.nextInt();
        int factorial = 1;
        System.out.println("|==============================================|");

        if (number < 0) {
            System.out.println("Faktorial tidak dapat dihitung untuk bilangan negatif.");
        } else {
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            System.out.println("Faktorial dari " + number + " adalah: " + factorial);
        }
    }
    
}
