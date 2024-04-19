package Semester1.Tugas_uts;

import java.util.Scanner;

public class SoalNo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("Masukkan nomor identifikasi: ");
                String inputID = input.nextLine();
                String result = validasiNomorID(inputID) ? "valid" : "tidak valid";
                System.out.println(inputID + " " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean validasiNomorID(String id) {
        if (id.length() != 3) {
            return false;
        }

        char digit1 = id.charAt(0);
        char digit2 = id.charAt(1);
        char digit3 = id.charAt(2);

        return (digit1 < digit2 && digit2 < digit3 && (digit3 - '0') % 2 != 0);
    }
}
