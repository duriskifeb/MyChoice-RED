package Semester1.Tugas4;

import java.io.BufferedReader;
import java.io.InputStreamReader;



class Barang {
    String kode;
    String nama;
    int stock;
    int hargaJual;
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public void inputData() {
        try {
            String temp = "";
            System.out.println("Menu Input Data Barang");
            System.out.print("Kode: ");
            kode = input.readLine();
            System.out.print("Nama: ");
            nama = input.readLine();
            System.out.print("Stock Awal: ");
            temp = input.readLine();
            stock = Integer.parseInt(temp);
            System.out.print("Harga Jual: ");
            temp = input.readLine();
            hargaJual = Integer.parseInt(temp);
            pressEnter();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void viewData() {
        System.out.println("Menampilkan detil barang");
        System.out.println("Nama: " + nama);
        System.out.println("Kode: " + kode);
        System.out.println("Jumlah Stok: " + stock);
        System.out.println("Harga Jual: " + hargaJual);
        pressEnter();
    }

    public void jualStock(int ubah) {
        System.out.println("Menu Penjualan Barang");
        System.out.println("Stok awal: " + stock);
        this.stock = this.stock - ubah;
        System.out.println("Pengurangan: " + ubah);
        System.out.println("Stok akhir: " + stock);
        System.out.println("Data telah diubah");
        pressEnter();
    }
    
    void pressEnter() {
        try {
            System.out.println("Tekan enter untuk melanjutkan");
            input.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public static void main(String[] args) {
        Barang brg1 = new Barang();
        Barang brg2 = new Barang();
        brg1.inputData();
        brg2.inputData();

        brg1.jualStock(33);
        brg2.jualStock(45);

        brg1.viewData();
        brg2.viewData();
    }    
}

       


