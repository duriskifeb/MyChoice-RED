package Semester1.Tugas2;

import java.util.Scanner;

public class Laundry {

    public static void main(String[] args) {
        pelanggan plg = new pelanggan();
        plg.daftar();
        plg.showProfil();

        transaksi trs = new transaksi();
        trs.catatTransaksi();
        trs.printStruk();

    
    }



}
    class pelanggan {
        String Nama_Lengkap;
        String No_Telpon; 
        String Alamat;
        String Email;
        String JenisKelamin;

        void daftar(){
            System.out.println("-----------------------------");
            System.out.println("MASUKAN DATA DIRI ANDA");
            System.out.println("-----------------------------");
        
            Scanner input = new Scanner(System.in);

            try{
                System.out.print("Nama_Lengkap\t: ");
                Nama_Lengkap = input.nextLine();
                System.out.print("No_Telpon\t: ");
                No_Telpon = input.nextLine();
                System.out.print("Alamat\t\t: ");
                Alamat = input.nextLine();
                System.out.print("Email\t\t: ");
                Email = input.nextLine();
                System.out.print("JenisKelamin\t: ");
                JenisKelamin = input.nextLine();
            } catch(Exception e) {
                System.err.print("Terjadi Error\t: " + e);
            }
            
           
        }

    void showProfil(){
        System.out.println("--------------------------");
        System.out.println("PROFIL ANDA");
        System.out.println("--------------------------");

        System.out.printf("Nama Lengkap\t: %s\n", Nama_Lengkap);
        System.out.printf("NO Telpon\t: %s\n", No_Telpon);
        System.out.printf("Alamat\t\t: %s\n", Alamat);
        System.out.printf("Email\t\t: %s\n", Email);
        System.out.printf("Jenis kelamin\t: %s\n", JenisKelamin);
        System.out.printf("--------------------------");
    } 
        }

    

    
    class  transaksi { 
        String BobotLoundry;
        String TotalHarga;
        String Tanggal;
        String Jam;
        String TanggalAmbilBaju;

        void catatTransaksi(){
            Scanner input = new Scanner(System.in);
            System.out.println("\n---------------------------");
            System.out.println("CATETAN BUKTI TRASAKSI");
            System.out.println("-----------------------------");

            try{
                System.out.print("BobotLoudry\t: ");
                BobotLoundry = input.nextLine();
                System.out.print("TotalHarga\t: ");
                TotalHarga = input.nextLine();
                System.out.print("Tanggal\t\t: ");
                Tanggal = input.nextLine();
                System.out.print("Jam\t\t: ");
                Jam = input.nextLine();
                System.out.print("TanggalAmbil\t: ");
                TanggalAmbilBaju = input.nextLine();

            }catch(Exception e){
                System.err.print("Terjadi Error:\t" + e);
            }
           
        }

        void printStruk(){
            System.out.println("\n-------------------------------");
            System.out.println("BUKTI STRUK LAUNDRY");
            System.out.println("----------------------------------");

            System.out.printf("Berat Laundry\t: %s\n", BobotLoundry);
            System.out.printf("Total Harga\t: %s\n", TotalHarga);
            System.out.printf( "Tanggal\t\t: %s\n", Tanggal);
            System.out.printf( "Jam\t\t: %s\n", Jam);
            System.out.printf("Tanggal Ambil\t: %s\n", TanggalAmbilBaju);
        }
        
    }




