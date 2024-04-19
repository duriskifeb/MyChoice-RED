package Semester1.Bada_UtS;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan nilai n untuk permutasi (nilaiPermutasi): ");
        int n = input.nextInt();
        System.out.print("Masukkan nilai r untuk permutasi (nilaiPermutasi): ");
        int r = input.nextInt();

        int nilaiPermutasi = 1;

        if (n < 0 || r < 0 || r > n) {
            System.out.println("Masukkan tidak valid untuk permutasi (nilaiPermutasi). Pastikan n >= 0 dan r >= 0 serta r <= n.");
        } else {
            for (int i = n; i > n - r; i--) {
                nilaiPermutasi *= i;
            }
            System.out.println("Permutasi dari " + n + "P" + r + " adalah: " + nilaiPermutasi);
        }
    }
}
