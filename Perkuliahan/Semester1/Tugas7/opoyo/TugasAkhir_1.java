package Semester1.Tugas7.opoyo;

import java.io.BufferedReader;
import java.io.InputStreamReader;



class Apk {
    public static void main(String[] args) {
        TugasAkhir_1 cek = new TugasAkhir_1();
        cek.Home();
    }
}

public class TugasAkhir_1 {
    String nama, noKTP, noTELPOn, noREK, KK;
    String noREKX = "1201230037";
    int pinX, pin, saldo = 0, nomin;
    byte ch;

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    byte Next(){
        try{
            System.out.print("\nTEKAN ENTER UNTUK LANJUT");
            String temp = input.readLine();
            Cls();
            Home();

        } catch(Exception e){
            System.out.println("Terjadi kesalahan: " + e);
        }

        return this.ch;
    }

    void Cls(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan: " + e);
        }
    }

    void Close(){
        System.out.println("MESSGE: Menutup aplikasi :");
        Cls();
        System.exit(ch);
    }


    public void Home(){
        Cls();
        System.out.println("----------------------------------------");
        System.out.println("WELCOME TO BANG-QU");
        
        try {
            
            System.out.println("----------------------------------------");
            System.out.println("TAKE YOUR PICK");
            System.out.println("1.TAMBAH REKENING BARU :");
            System.out.println("2. LIHAT INFORMASI REKENING :");
            System.out.println("3. TAMBAH SALDO :");
            System.out.println("4. TARIK SALDO :");
            System.out.println("5.LIHAT SALDO :");
            System.out.println("0.TUTUP APLIKASI:");
            System.out.println("----------------------------------------");

            System.out.print("MASUKAN PILIHAN (ANGKA): ");
            String temp = input.readLine();
            if(temp.equals("")) {
                System.out.println("\nMESSEAGE: MASUKKAN ANGKA");
                Next();
            }else{
                this.ch = Byte.parseByte(temp);
            }

            switch (this.ch) {
                case 1 :
                    TambahkanAkun();
                    break;
                case 2 : 
                    InfoAkun();
                    break; 
                case 3 : 
                    TambahSaldo();
                    break;
                case 4 : 
                    TARIKSaldo();
                    break;
                case 5 :
                    LihatSaldo();
                    break;
                case 0 :
                    break;
                default:
                    System.err.println("\nMESSGE: Pilihan tidak ada");
                    Next();
                    Home();
                    break;
            }
        } catch (Exception e) {
            System.err.println("");
        }
        
        
        
    }

    void TambahkanAkun(){
        try {
            Cls();

            String temp = "";

            System.out.println("---------------------------------------");
            System.out.println("INI TAMBAH AKUN");
            System.out.println("---------------------------------------");

            System.out.print("NAMA LENGKAP\t: ");
            nama = input.readLine();
            System.out.print("NO KTP\t\t :");
            noKTP = input.readLine();
            System.out.print("NO KK\t\t :");
            KK = input.readLine();
            System.out.print("NO. TELPON\t :");
            noTELPOn = input.readLine();
            System.out.print("PIN BARU\t :");
            temp = input.readLine();
            pinX = Integer.parseInt(temp);

            System.out.println("\n--------------------------------------");

        } catch (Exception e) {
            System.err.println("Terjadi Kesalahan: "+ e);
        } finally{
            Next();
            Home();
        }
    }

    void InfoAkun(){
            try {
            Cls();

            String temp = "";

            System.out.println("---------------------------------------");
            System.out.println("INfo akun");
            System.out.println("---------------------------------------");

            System.out.println("NOMOR REKENING\t: "+noREKX);
            System.out.println("PIN ANDA\t :"+pinX);


            System.out.println("\n--------------------------------------");

        } catch (Exception e) {
            System.err.println("Terjadi Kesalahan: + e");
        }finally{
            Next();
            Home();
            
        }
    }

    void TambahSaldo(){
            try {
            Cls();

            String temp = "";

            System.out.println("---------------------------------------");
            System.out.println("INI TAMBAH SALDO");
            System.out.println("---------------------------------------");

            System.out.print("MASUKKAN NOMOR REKENING\t: ");
            noREK = input.readLine();
            System.out.print("MASUKKAN NOMINAL\t :");
            temp = input.readLine();
            nomin = Integer.parseInt(temp);
            System.out.print("MASUKKAN PIN ANDA\t :");
            temp = input.readLine();
            pin = Integer.parseInt(temp);

            if(noREK.equals(noREK) && pin==pinX){
                saldo = saldo + nomin;
                System.out.println("\nMESSEAGE: SALDO YANG ANDA TAMBAHKAN BERHASIL");
            }else{
                System.out.println("\nNO REKENIG ATAU PIN YANG ANDA MASUKKAN SALAH");
            }
            
            System.out.println("\n--------------------------------------");

        } catch (Exception e) {
            System.err.println("Terjadi Kesalahan: "+ e);
        }finally{
            Next();
        }
    }
    
    void TARIKSaldo(){
        try {
            Cls();

            String temp = "";

            System.out.println("---------------------------------------");
            System.out.println("INI TArik saldo");
            System.out.println("---------------------------------------");

            System.out.print("MASUKKAN NOMOR REKENING\t: ");
            noREK = input.readLine();
            System.out.print("MASUKKAN NOMINAL\t :");
            temp = input.readLine();
            nomin = Integer.parseInt(temp);
            System.out.print("MASUKKAN PIN ANDA\t :");
            temp = input.readLine();
            pin = Integer.parseInt(temp);

            if(noREK.equals(noREK) && pin==pinX){
                saldo = saldo - nomin;
                System.out.println("\nMESSEAGE: SALDO BERHASIL DITARIK");
            }else{
                System.out.println("\nNO REKENIG ATAU PIN YANG ANDA MASUKKAN SALAH");
            }
            
            System.out.println("\n--------------------------------------");

        } catch (Exception e) {
            System.err.println("Terjadi Kesalahan: + e");
        }finally{
            Next();
        }
    }

    void LihatSaldo(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            System.out.println("---------------------------------------");
            System.out.println("INI LIHAT SALDO");
            System.out.println("---------------------------------------");

            System.out.printf("NO. REKENING\t: %s\n", noREKX);
            System.out.printf("SALDO ANDA \t: %s\n", saldo);

            System.out.println("\n----------------------------------------");

        } catch (Exception e) {
            System.err.println("Terjadi Kesalahan: + e");
        }finally{
            Next();
        }
    }
}            

