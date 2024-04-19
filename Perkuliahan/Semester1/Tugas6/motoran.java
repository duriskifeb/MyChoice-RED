package Semester1.Tugas6;

import java.util.Scanner;




public class motoran {
    Scanner inp = new Scanner(System.in);
    int pilihan;
    double km, tp, p, pt, ts, pp, hp;

    public static void main(String[] xyz) {
        motoran bnk = new motoran();
        bnk.Menu();
    }

    void Menu() {
        System.out.println("===========*****=============");
        System.out.println("Aplikasi Bayar Pajak Kendaraan");
        System.out.println("Pilih kendaraan anda :");
        System.out.println("1. MOTOR");
        System.out.println("2. MOBIL");
        System.out.printf("Masukkan pilihan anda [1-2] : ");
        pilihan = inp.nextInt();
        System.out.println("===========*****=============");
        switch (pilihan) {
            case 1:
                System.out.println("Kapasitas Mesin =");
                km = inp.nextDouble();
                System.out.println("Tahun Produksi =");
                tp = inp.nextDouble();
                System.out.println("Tahun Sekarang =");
                ts = inp.nextDouble();

                if(km < 100){
                    p = 200000;
                    pt = (ts - tp) * 0.01;
                    pp = p * pt;
                    hp = p + pp;
                } else if(km < 250){
                    p = 1000000;
                    pt = (ts - tp) * 0.03;
                    pp = p * pt;
                    hp = p + pp;
                } else if(km >= 250){
                    p = 4000000;
                    pt = (ts - tp) * 0.05;
                    pp = p * pt;
                    hp = p + pp;
                } 
                 System.out.println("MOTOR");
                 System.out.println("Kapasitas Mesin =" + km);
                 System.out.println("Tahun Produksi =" + tp);
                 System.out.println("Tahun Sekarang =" + ts);
                 System.out.println("Pokok Pajak Motor = " + p);
                 System.out.println("Penambahan Pajak Pokok = " + pp);
                 System.out.println("Total Pajak = " + hp);
                break;
            case 2:
                System.out.println("Kapasitas Mesin = ");
                km = inp.nextDouble();
                System.out.println("Tahun Produksi =");
                tp = inp.nextDouble();
                System.out.println("Tahun Sekarang =");
                ts = inp.nextDouble();

                if(km < 1000){
                    p = 2000000;
                    pt = (ts - tp) * 0.01;
                    pp = p * pt;
                    hp = p + pp;
                } else if(km < 1500){
                    p = 3000000;
                    pt = (ts - tp) * 0.02;
                    pp = p * pt;
                    hp = p + pp;
                } else if(km < 2500){
                    p = 6000000;
                    pt = (ts - tp) * 0.04;
                    pp = p * pt;
                    hp = p + pp;
                } else if(km >= 2500){
                    p = 12000000;
                    pt = (ts - tp) * 0.08;
                    pp = p * pt;
                    hp = p + pp;
                }
                System.out.println("MOBIL");
                System.out.println("Kapasitas Mesin =" + km);
                 System.out.println("Tahun Produksi =" + tp);
                 System.out.println("Tahun Sekarang =" + ts);
                 System.out.println("Pokok Pajak Motor = " + p);
                 System.out.println("Penambahan Pajak Pokok = " + pp);
                 System.out.println("Total Pajak = " + hp);
                break;
            default:
            System.out.println("MAAF PILIHAN ADA DILUAR NALAR");
            break;
        }
    }
}
    