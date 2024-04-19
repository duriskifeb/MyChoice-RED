package Semester1.Tugas_uts;

import java.util.Scanner;

public class SoalNo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("| --> PERJUANGAN MAHASISWA <--- | ");
        System.out.print("  |Sekarang semester berapa (1-4) |: ");
        int masaStudi = scanner.nextInt();

        System.out.print("Berapa nilai IPK : ");
        double ipk = scanner.nextDouble();

        System.out.print("Berapa nilai EPRT: ");
        int nilaiEPRT = scanner.nextInt();

        System.out.print("Adakah SK Industri (Ada/Tidak Ada): ");
        String suratKeteranganIndustri = scanner.next();

        String statusKelulusan = "Mohon maaf, anda tidak lulus....!!!";

        if (ipk >= 2.76 && ipk <= 3.0) {
            statusKelulusan = "Memuaskan";
        } else if (ipk <= 3.5 && masaStudi <= 6 && nilaiEPRT >= 450
                && suratKeteranganIndustri.equalsIgnoreCase("Ada")) {
            statusKelulusan = "Cumlaude";
        } else if (ipk <= 3.5) {
            statusKelulusan = "Sangat Memuaskan";
        }

        System.out.println("Status Kelulusan: " + statusKelulusan);

        scanner.close();
    }
}



