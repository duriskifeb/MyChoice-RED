package Latiahan;

// Enum dengan field dan constructor
public enum Day {
    SUNDAY(false),
    MONDAY(true),
    TUESDAY(true),
    WEDNESDAY(true),
    THURSDAY(true),
    FRIDAY(true),
    SATURDAY(false);

    // Field untuk menyimpan apakah hari ini adalah hari kerja atau tidak
    private final boolean isWorkDay;

    // Constructor enum, digunakan untuk mengatur nilai field isWorkDay
    Day(boolean isWorkDay) {
        this.isWorkDay = isWorkDay;
    }

    // Method untuk mendapatkan status apakah hari kerja
    public boolean isWorkDay() {
        return isWorkDay;
    }
}
