package Perkuliahan.NewEra;

import java.util.Scanner;

class KelolaArrayInteger {
    int n = 10;
    int[] arrOfInt = new int[n];
    Scanner inp = new Scanner(System.in);

    public static void main(String[] args) {
        KelolaArrayInteger kai = new KelolaArrayInteger();
        kai.inputAndSort();
        kai.traversal();
    }

    void inputAndSort() {
        int val = 0;
        for (int a = 0; a < n; a++) {
            System.out.print("Val : ");
            val = inp.nextInt();
            int b = a;
            // Mengubah urutan dari besar ke kecil (descending) menjadi kecil ke besar
            while (b > 0 && val < arrOfInt[b - 1]) { // Modifikasi perbandingan untuk ascending
                arrOfInt[b] = arrOfInt[b - 1];
                b--;
            }
            arrOfInt[b] = val;
        }
    }

    void traversal() {
        for (int a = 0; a < n; a++) {
            System.out.print(arrOfInt[a] + " ");
        }
    }
}
