package Semester3.Utilitas;

import java.io.IOException;

public class Utilitas {
    public static void CLS(String[] args) {
            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                }
            } catch (IOException | InterruptedException ex) {
                System.out.println("Error membersihkan layar.");
            }
        }
    }


// // Method untuk membersihkan layar menggunakan perintah sistem