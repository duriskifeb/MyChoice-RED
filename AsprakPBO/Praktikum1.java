package AsprakPBO;

public class Praktikum1 {
    public static void main(String[] args) {
        
        int angka = 64;
                
                // Mengecek apakah angka adalah bilangan genap
                boolean isEven = (angka % 2 == 0);
                
                // Mengecek apakah angka adalah kelipatan 3
                boolean isMultipleOf3 = (angka % 3 == 0);
                
                // Mengecek apakah angka adalah kelipatan 2 dan kelipatan 7
                boolean isMultipleOf2And7 = (angka % 2 == 0) && (angka % 7 == 0);
                
                // Mengecek apakah angka adalah kelipatan 2 atau kelipatan 7
                boolean isMultipleOf2Or7 = (angka % 2 == 0) || (angka % 7 == 0);
                
                // Menampilkan hasil
                System.out.println("Apakah itu bilangan genap? : " + (isEven ? "benar" : "salah"));
                System.out.println("Apakah kelipatan 3? : " + (isMultipleOf3 ? "benar" : "salah"));
                System.out.println("Apakah kelipatan 2 dan kelipatan 7? : " + (isMultipleOf2And7 ? "benar" : "salah"));
                System.out.println("Apakah kelipatan 2 atau kelipatan 7? : " + (isMultipleOf2Or7 ? "benar" : "salah"));
        }
    }