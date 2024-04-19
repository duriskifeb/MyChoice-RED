package Semester1.Tugas6;
import java.util.Scanner;

public class bismillah {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        String kodebarang;
        String namaproduk;
        int jumlahbeli;
        double hargainput = 0.0;
        double perdiskon = 0.0;

        System.out.println("~~~~~PT.JAYA JAVA~~~~~");
        System.out.println("kode barang : ");
        kodebarang = input.nextLine();
        System.out.println("nama produk : ");
        namaproduk = input.nextLine();
        System.out.println("jumlah beli = ");
        jumlahbeli = input.nextInt();

        switch ((kodebarang)) {
            case "A":
                hargainput = 250000;
                perdiskon = 3.0;
                namaproduk = "computerdesk";
                break;

            case "B":
                hargainput = 200000;
                perdiskon = 3.0;
                namaproduk = "computerdesk";
                break;

            case "C":
                hargainput = 150000;
                perdiskon = 2.0;
                namaproduk = "Studydesk";
                break;

            default:
                break;
        }

        double totalHarga = hargainput * jumlahbeli;
        double totaldiskon = (perdiskon / 100) * totalHarga;
        double totalBayar = totalHarga - totaldiskon;

        System.out.println("kode produk     : " + kodebarang);
        System.out.println("nama produk     : " + namaproduk);
        System.out.println("harga per-unit     : " + hargainput);
        System.out.println("total harga     : " + totalHarga);
        System.out.println("besar diskon     : " + perdiskon);
        System.out.println("total diskon     : " + totaldiskon);
        System.out.println("total bayar     : " + totalBayar);

    }

}
