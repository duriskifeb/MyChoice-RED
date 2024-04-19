package Semester1.Tugas4;



// 1.3 PRAKTIK - RITEL MAKANAN
// FIX

import java.util.Scanner;

class Ritel { 
    public static void main(String[] args) {
        Barang brg = new Barang();
        brg.inputData();
        brg.viewData();
    }

}

class Barang {

    String kodeBarang;
    String namaBarang;
    String produsen;
    int beratBersih;
    double hargaBeli;
    double hargaJual;

    Scanner input = new Scanner(System.in);

    public void inputData() {
        try {
            System.out.println("===== Inputan Data Barang =====");
            System.out.print("Kode barang : ");
            kodeBarang = input.nextLine();
            System.out.print("Nama barang : ");
            namaBarang = input.nextLine();
            System.out.print("Produsen : ");
            produsen = input.nextLine();
            System.out.print("Berat bersih : ");
            beratBersih = input.nextInt();
            System.out.print("Harga beli : ");
            hargaBeli = input.nextDouble();
            System.out.print("Harga jual : ");
            hargaJual = input.nextDouble();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewData() {
        System.out.println("===== Menampilkan Detail Barang =====");
        System.out.println("Nama barang : " + namaBarang);
        System.out.println("Kode barang : " + kodeBarang);
        System.out.println("Produsen : " + produsen);
        System.out.println("Berat bersih : " + beratBersih);
        System.out.println("Harga beli : " + hargaBeli);
        System.out.println("Harga jual : " + hargaJual);
    }

}