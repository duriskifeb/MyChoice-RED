package AsprakPBO;

public class Praktikum4 {
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

        // Program konversi suhu berdampingan
        System.out.println("\nCelsius  Fahrenheit  |  Fahrenheit  Celsius");
        for (int celsius = 0, fahrenheit = 20; celsius <= 100; celsius += 2, fahrenheit += 5) {
            double fahrenheitConverted = (celsius * 9.0 / 5) + 32;
            double celsiusConverted = (fahrenheit - 32) * 5.0 / 9;
            System.out.printf("%7d %10.1f  |  %10d %8.3f\n", celsius, fahrenheitConverted, fahrenheit,
                    celsiusConverted);
        }

        
        // Program menampilkan bilangan ganjil dari array
        int[] numbers = { 10, 21, 33, 42, 51, 64, 79, 80 };
        int sumOdd = 0;
        System.out.println("\nBilangan ganjil dalam array:");
        for (int num : numbers) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
                sumOdd += num;
            }
        }
        System.out.println("\nJumlah bilangan ganjil adalah " + sumOdd);
    }
}
