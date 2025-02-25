package AsprakPBO;

public class PraktikumWeek2ALL {

    public static void main(String[] args) {

        // 1.
        int inputAngka = 64;
        boolean Perhitungan = (inputAngka % 2 == 0);
        boolean Kelipatan3 = (inputAngka % 3 == 0);
        boolean Kelipatan2dan7 = (inputAngka % 2 == 0) && (inputAngka % 7 == 0);
        boolean Kelipatan2atau7 = (inputAngka % 2 == 0) || (inputAngka % 7 == 0);

        System.out.println("Apakah itu bilangan genap? : " + (Perhitungan ? "benar" : "salah"));
        System.out.println("Apakah itu kelipatan 3?  : " + (Kelipatan3 ? "benar" : "salah"));
        System.out.println("Apakah itu kelipatan 2 dan kelipatan 7? : " + (Kelipatan2dan7 ? "benar" : "salah"));
        System.out.println("Apakah itu kelipatan 2 dan kelipatan 7? : " + (Kelipatan2atau7 ? "benar" : "salah"));

        // 2.
        System.out.println("\nInci\tSentimeter");
        for (int inci = 1; inci <= 10; inci++) {
            double cm = inci * 2.54;
            System.out.println(inci + "\t" + cm);
        }

        // 3.
        System.out.println("\nCelcius Farenheit   |  Farenheit Celciius");
        for (int celsius = 0, fahrenheit = 20; celsius <= 100; celsius += 2, fahrenheit += 5) {
            double fahrenheitConverted = (celsius * 9 / 5) + 32;
            double celsiusConverted = (fahrenheit - 32) * 5 / 9; 
            System.out.printf("%7d %10.1f  | %10d %8.3f\n", celsius, fahrenheitConverted, fahrenheit, celsiusConverted);

        } 

        // 4. 
        int[] angka =  { 10, 12, 52, 20, 53, 11, 22, 21, 98 };
        int penampung = 0; 
        System.out.println("\nBilangan ganjil dalam array : ");
        for (int i = 0; i < angka.length; i++) {
            if (angka[i] % 2 != 0) {
                System.out.print(angka[i] + " ");
                penampung += angka[i];
            }
        }
        System.out.println("Jumlah bilangan ganjilnya adalah : " + penampung + "\n");
    }
}



