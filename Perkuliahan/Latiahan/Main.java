package Latiahan;


public class Main {
    public static void main(String[] args) {
        // Mendapatkan nilai enum saat ini
        Day today = Day.WEDNESDAY; // Set nilai enum hari ini

        // Mengecek apakah hari ini adalah hari kerja atau bukan
        if (today.isWorkDay()) {
            System.out.println(today + " is a workday.");
        } else {
            System.out.println(today + " is not a workday.");
        }

        // Menampilkan status hari kerja untuk semua hari dalam seminggu
        System.out.println("\n--- Workday status for all days ---");
        for (Day day : Day.values()) {
            System.out.println(day + ": " + (day.isWorkDay() ? "Workday" : "Weekend"));
        }
    }
}
