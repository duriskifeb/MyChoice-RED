package AsprakPBO;

public class Praktikum2 {
    public static void main(String[] args) {
        // Program mengecek sifat angka 64
        int angka = 64;
        boolean isEven = (angka % 2 == 0);
        boolean isMultipleOf3 = (angka % 3 == 0);
        boolean isMultipleOf2And7 = (angka % 2 == 0) && (angka % 7 == 0);
        boolean isMultipleOf2Or7 = (angka % 2 == 0) || (angka % 7 == 0);
        
        System.out.println("Apakah itu bilangan genap? : " + (isEven ? "benar" : "salah"));
        System.out.println("Apakah kelipatan 3? : " + (isMultipleOf3 ? "benar" : "salah"));
        System.out.println("Apakah kelipatan 2 dan kelipatan 7? : " + (isMultipleOf2And7 ? "benar" : "salah"));
        System.out.println("Apakah kelipatan 2 atau kelipatan 7? : " + (isMultipleOf2Or7 ? "benar" : "salah"));
        
        // Program konversi inci ke sentimeter
        System.out.println("\nInci\tSentimeter");
        for (int inci = 1; inci <= 10; inci++) {
            double cm = inci * 2.54;
            System.out.println(inci + "\t" + cm);
        }
    }
}

