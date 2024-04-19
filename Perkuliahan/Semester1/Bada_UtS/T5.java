package Semester1.Bada_UtS;
import java.text.DecimalFormat;
import java.util.Scanner;

public class T5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println();
        
        System.out.println("\t----> jangan ada jarak di antara kita <----");
        System.out.println();

        System.out.print("Kecepatan mobil Civic Turbo Budi (km/jam): ");
        double kBudi = input.nextDouble();
        System.out.print("Kecepatan mobil Lamborgini Ani (km/jam): ");
        double kAni = input.nextDouble();
        System.out.print("Jarak antara Budi dan Ani(km): ");
        double jarak = input.nextDouble();

        double jarak2 = jarak * 1000;

        DecimalFormat f1 = new DecimalFormat(" #0.0");

        if (kBudi <= 0 || kAni <= 0 || jarak < 0) {
            System.out.println("Nilai yang dimasukkan tidak valid.");
        } else {
            double jBudi = 0;
            double jAni = jarak2;
            int jam = 0;
            int menit = 0;
            int detik = 0;

            while (jBudi < jAni) {
                double temu = 1;
                detik += temu;

                double kBudi2 = kBudi / 3.6;
                double kAni2 = kAni / 3.6;

                if (detik >= 60) {
                    menit += detik / 60;
                    detik = menit % 60;
                }

                if (menit >= 60) {
                    jam += menit / 60;
                    menit = jam % 60;
                }

                jBudi += kBudi2;
                jAni -= kAni2;

                System.out.println("Waktu: " + jam + " jam " + menit + " menit " + detik + " detik" + "- Jarak Budi: " + f1.format(jBudi) + " m, Jarak Ani: " + f1.format(jAni) + " m");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println("Waktu yang dibutuhkan bagi Budi dan Ani untuk saling bertemu adalah: " + jam + " jam " + menit + " menit " + detik + " detik");
            System.out.println();

            System.out.println("\t----> Rindu itu berat biar aku saja <----");
            System.out.println(100);
        }
        input.close();
    }
}
