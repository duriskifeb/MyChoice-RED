package PBO.BangunRuang;

import java.util.ArrayList;
import java.util.Scanner;

class Driver {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Membuat ArrayList untuk menyimpan objek SegiEmpat, Balok, dan Kubus
        ArrayList<SegiEmpat> bentukBangunan = new ArrayList<>();

        boolean exit = false;

        while (!exit) {
            // Memasukkan opsi menu
            System.out.println("-------------------------------");
            System.out.println(" CALCULATION OF BUILDING SPACE ");
            System.out.println("-------------------------------");

            System.out.println("Pilih bentuk bangunan yang ingin dihitung:");
            System.out.println("1. Segi Empat (Luas)");
            System.out.println("2. Balok (Volume)");
            System.out.println("3. Kubus (Luas)");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    // Membersihkan layar
                    cls();
                    // Membuat objek SegiEmpat dengan nama kotak dan menambahkannya ke ArrayList
                    SegiEmpat kotak = new SegiEmpat();
                    System.out.print("Masukkan panjang segi empat: ");
                    double panjangSegiEmpat = scanner.nextDouble();
                    kotak.setPanjang(panjangSegiEmpat);
                    System.out.print("Masukkan lebar segi empat: ");
                    double lebarSegiEmpat = scanner.nextDouble();
                    kotak.setLebar(lebarSegiEmpat);
                    bentukBangunan.add(kotak);
                    System.out.println("Luas Segi Empat = " + kotak.luas());
                    break;
                case 2:
                    // Membersihkan layar
                    cls();
                    // Membuat objek Balok dengan nama kayu dan menambahkannya ke ArrayList
                    Balok kayu = new Balok();
                    System.out.print("Masukkan panjang balok: ");
                    double panjangBalok = scanner.nextDouble();
                    kayu.setPanjang(panjangBalok);
                    System.out.print("Masukkan lebar balok: ");
                    double lebarBalok = scanner.nextDouble();
                    kayu.setLebar(lebarBalok);
                    System.out.print("Masukkan tinggi balok: ");
                    double tinggiBalok = scanner.nextDouble();
                    kayu.setTinggi(tinggiBalok);
                    bentukBangunan.add(kayu);
                    System.out.println("Volume Balok = " + kayu.volume());
                    break;
                case 3:
                    // Membersihkan layar
                    cls();
                    // Membuat objek Kubus dengan nama balokKecil dan menambahkannya ke ArrayList
                    System.out.print("Masukkan sisi kubus: ");
                    double sisiKubus = scanner.nextDouble();
                    Kubus balokKecil = new Kubus(sisiKubus);
                    bentukBangunan.add(balokKecil);
                    System.out.println("Luas Kubus = " + balokKecil.luas());
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

            // Meminta konfirmasi untuk melanjutkan atau tidak dengan loop hingga jawaban
            // benar
            if (!exit) {
                boolean jawabanBenar = false;
                while (!jawabanBenar) {
                    System.out.print("\n"+"Lanjutkan? (ya/tidak) ");
                    String jawaban = scanner.next();
                    if (jawaban.equalsIgnoreCase("ya")) {
                        cls();
                        jawabanBenar = true;
                    } else if (jawaban.equalsIgnoreCase("tidak")) {
                        exit = true;
                        jawabanBenar = true;
                    } else {
                        System.out.println("Masukkan jawaban yang valid (ya/tidak).");
                    }
                }
            }
        }

        // Membersihkan layar sebelum keluar dari program
        cls();
        System.out.println("Terima kasih...");
        scanner.close();
    }

    // Fungsi untuk membersihkan layar
    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (Exception ex) {
            System.out.println("Error saat membersihkan layar: " + ex.getMessage());
        }
    }
}
