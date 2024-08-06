package Latiahan.Number;

public class Number {
    public static void main(String[] args) {
        //This is a pictrue a number one
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 5; j++) {
                if (j == 3 || (i == 1 && j >= 2 && j <= 4) || (i == 7 && j >= 2 && j <= 4)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(); // Move this outside of the inner loop to print a new line after each row
        }
        
        System.out.println(""); //space lines for after.
        
        //This is a pictrue a number two
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 5; j++) {
                if (i == 1 || i == 4 || i == 7 || (j == 5 && i <= 4) || (j == 1 && i >= 4)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println("");//space line for affter

        //This is a pictrue a number three 
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
        System.out.println("");
        //This is a pictrue a number four 
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 5; j++) {
                if ((j == 1 && i <= 4)|| (j == 5 && i >= 1) || (i == 4)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}


