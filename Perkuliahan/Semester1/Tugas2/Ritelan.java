package Semester1.Tugas2;

import java.util.ArrayList;
import java.util.Scanner;

class Ritelan {
    public static void main(String[] args) {

        ArrayList<Barang> dftrBarang = new ArrayList<>();

        System.out.println("===> Program manajemen Barang <===");
        System.out.println("1. Tambah barang");
        System.out.println("2. Tampilkan semua barang");
        System.out.println("0. Keluar");

        Scanner scanner = new Scanner(System.in);

        try {
            boolean exit = false;
            while (!exit) {
                System.out.print("Pilih menu (1/2/0): ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        Barang barang = new Barang();
                        barang.inputData(scanner);
                        dftrBarang.add(barang);
                        break;
                    case "2":
                        if (dftrBarang.isEmpty()) {
                            System.out.println("Maaf, belum ada daftar barang yang dimasukkan.");
                        } else {
                            System.out.println("\nData Semua Barang:");
                            for (Barang brg : dftrBarang) {
                                brg.viewData();
                                System.out.println();
                            }
                        }
                        break;
                    case "0":
                        exit = true;
                        System.out.println("Terima kasih!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            scanner.close();
        }

    }
}

class Barang {
    String kode;
    String nama;
    String produsen;
    int berat;
    int hargaBeli;
    int hargaJual;

    public void inputData(Scanner scanner) {
        try {
            String temp = "";
            System.out.println("\nInput Data Barang:");
            System.out.print("Kode : ");
            kode = scanner.nextLine();
            System.out.print("Nama : ");
            nama = scanner.nextLine();
            System.out.print("Produsen : ");
            produsen = scanner.nextLine();

            System.out.print("Berat Bersih : ");
            temp = scanner.nextLine();
            berat = Integer.parseInt(temp);
            System.out.print("Harga Beli : ");
            temp = scanner.nextLine();
            hargaBeli = Integer.parseInt(temp);
            System.out.print("Harga Jual : ");
            temp = scanner.nextLine();
            hargaJual = Integer.parseInt(temp);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewData() {
        System.out.println("Menampilkan detil barang");
        System.out.println("Nama : " + nama);
        System.out.println("Kode : " + kode);
        System.out.println("Produsen : " + produsen);
        System.out.println("Berat Bersih : " + berat);
        System.out.println("Harga Beli : " + hargaBeli);
        System.out.println("Harga Jual : " + hargaJual);
    }
}
