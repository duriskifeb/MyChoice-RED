package Semester1.Tugas2;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.Scanner;

class barang {
    // Atribut
    String kode;
    String barang;
    String produsen;
    int beratBersih;
    double hargaBeli;
    double hargaJual;

    // InputStreamReader isr = new InputStreamReader(System.in);
    // BufferedReader input2 = new BufferedReader(isr);

    Scanner input = new Scanner(System.in);

    public void inputData() {
        try {
            System.out.println("Inputan Data Barang ");
            System.out.print("Kode : ");
            kode = input.nextLine();
            System.out.print("Nama : ");
            kode = input.nextLine();
            System.out.print("Produsen : ");
            produsen = input.nextLine();

            System.out.print("Berat Bersih : ");
            beratBersih = input.nextInt();

            System.out.print("Harga Beli : ");
            hargaBeli = input.nextDouble();

            System.out.print("Harga Jual : ");
            hargaJual = input.nextDouble();
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewData() {

        System.out.println("Menampilkan detil barang");
        System.out.println("Nama : " + barang);
        System.out.println("Kode : " + kode);
        System.out.println("Produsen : " + produsen);
        System.out.println("Berat Bersih : " + beratBersih);
        System.out.println("Harga Beli : " + hargaBeli);
        System.out.println("Harga Jual : " + hargaJual);
    }
}