package Perkuliahan.NewEra;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgrammerLegend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("==>Masukkan jumlah Petualan<== : ");
        int n; 
        while (true) {
            try {
                n = scanner.nextInt();
                if (n <= 0) {
                    System.out.print("Tolong, masukkan dengan input angka  : ");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Tolong, masukkan dengan input angka : ");
                scanner.next();
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print("Massukkan kekuatan dari si petualang " + i + ": ");
            int logicalPower;
            while (true) {
                try {
                    logicalPower = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Maaf input salah! : ");
                    scanner.next();
                }
            }

            System.out.print("Masukkan kelemahan si petualang " + i + ": ");
            int bugTracingPower;
            while (true) {
                try {
                    bugTracingPower = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Invalid input. Please enter an integer: ");
                    scanner.next();
                }
            }

            System.out.print("Masukkan ketahanan si petualang " + i + ": ");
            int endurancePower;
            while (true) {
                try {
                    endurancePower = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Invalid input. Please enter an integer: ");
                    scanner.next();
                }
            }

            int totalPower = calculateTotalPower(logicalPower, bugTracingPower, endurancePower);
            System.out.println("Total Keseluruhan Progammer " + i + ": " + totalPower);
            System.out.println();
        }
    }

    public static int calculateTotalPower(int logicalPower, int bugTracingPower, int endurancePower) {
        return (2 * logicalPower) + (3 * bugTracingPower) - (int) (0.5 * endurancePower);
    }
}