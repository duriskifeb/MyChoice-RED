package Perkuliahan.NewEra;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TesProgrammer
 */
public class TesProgrammer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = inputPositiveInt(scanner, "Masukkan angka bebas untuk berpetualang: ");

        for (int i = 1; i <= n; i++) {
            int kekuatanSuper = inputInt(scanner, "Masukkan kekuatan berapa yang diinginkan: ");
            int hasilKekuatan = inputInt(scanner, "Total kekuatan dari petualang " + i + ": ");
            int hasilKetahanan = inputInt(scanner, "Total ketahanan petualang " + i + ": ");

            int totalPower = hitungTotalPower(kekuatanSuper, hasilKekuatan, hasilKetahanan);
            System.out.println("Total Power petualang " + i + ": " + totalPower);
        }
    }

    private static int inputPositiveInt(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                if (value > 0)
                    return value;
                System.out.println("Tolong masukkan angka positif.");
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid, tolong masukkan angka!");
                scanner.next(); // membersihkan input yang salah
            }
        }
    }

    private static int inputInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid, tolong masukkan angka!");
                scanner.next(); // membersihkan input yang salah
            }
        }
    }

    private static int hitungTotalPower(int kekuatanSuper, int hasilKekuatan, int hasilKetahanan) {
        return (2 * kekuatanSuper) + (3 * hasilKetahanan) - (int) (0.5 * hasilKekuatan);
    }
}
