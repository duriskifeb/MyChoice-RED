package PBO.Tumbas;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Util {

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.err.println("Error : cls()");
            e.printStackTrace();
        }
    }

    public static void pressEnter() {
        System.out.println("\n|------------------------|");
        System.out.print("|Tekan ENTER untuk lanjut|");
        System.out.println("\n|------------------------|");
        inputLine();
    }

    public static String inputLine() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            String a = input.readLine();
            return a;
        } catch (Exception e) {
            System.err.println("Error : readLine()");
            e.printStackTrace();
            return null;
        }
    }

    public static int inputInt() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            int a = Integer.parseInt(input.readLine());
            return a;
        } catch (Exception e) {
            System.err.println("\nError : Input salah");
            return 9;
        }
    }

    // Metode untuk mengambil input string
    public static String inputString() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            return input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    // Metode YesOrNo untuk memeriksa input "ya" atau "tidak"
    public static boolean YesOrNo(String input) {
        input = input.toLowerCase();
        return input.equals("ya");
    }
}