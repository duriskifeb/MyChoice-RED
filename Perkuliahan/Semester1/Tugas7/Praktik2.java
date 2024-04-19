
package Semester1.Tugas7;

import java.util.Scanner;


public class Praktik2 {
    
    Scanner inp = new Scanner(System.in);
    int batas;
    
    public static void main(String[] args) {
        Praktik2 cp = new Praktik2();
        cp.runThis();
    }

    void runThis() {
        System.out.println("Deret Prima");
        System.out.print("Masukkan bilangan : ");
        batas = inp.nextInt();

        // if(cekBilanganPrima(batas)){
        //     System.out.println(batas + " adalah bilangan prima");
        // } else {
        //     System.out.println(batas + " bukan bilangan prima");
        // }

        showPrima();

    }

    void showPrima(){
        System.out.print("Deret prima : ");
        boolean hasil;
        int cek = 2;
        while(cek <= batas){
            hasil = cekBilanganPrima(cek);
            if (hasil) {
                System.out.print(cek + ", ");
            }
            cek++;
        }
    }

    boolean cekBilanganPrima(int batas) {
        int counter = 2;
        int Praktik2 = 0;
        while (counter <= batas) {
            if ((batas % counter) == 0) {
                Praktik2++;
            }
            counter++;
        }
        if (Praktik2 > 1) {
            return false;
        } else {
            return true;
        }
    }
}

// akan terjadi "ArithmeticException" dimana pada bagian if(batas % counter), 
// (batas % counter) akan menghasilkan error
