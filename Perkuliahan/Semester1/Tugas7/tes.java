package Semester1.Tugas7;
import java.util.Scanner;

public class tes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nilaiX = (int) (Math.random() * 100); // Menghasilkan nilai acak antara 0-100
        int tebakan = -1;
        int batasBawah = 0;
        int batasAtas = 100;

        int jumlahTebakan = 0;

        while (tebakan != nilaiX) {
            System.out.print("Tebak nilai (Antara " + batasBawah + " - " + batasAtas + "): ");
            tebakan = input.nextInt();
            jumlahTebakan++;

            if (tebakan < nilaiX) {
                System.out.println("Nilai yang anda masukkan lebih kecil");
                batasBawah = tebakan; // Mengganti batas bawah
            } else if (tebakan > nilaiX) {
                System.out.println("Nilai yang anda masukkan lebih besar");
                batasAtas = tebakan; // Mengganti batas atas
            } else {
                System.out.println("Tebakan yang bagus, anda berhasil menebaknya dalam " + jumlahTebakan + " kali tebakan");
            }
        }
    }
}