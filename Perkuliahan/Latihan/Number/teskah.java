package Latihan.Number;

public class teskah {
    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 5; j++) {
                if (i == 1 || i == 4 || i == 7 || j == 5 || (j == 0 && (i == 2 || i == 6))) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
