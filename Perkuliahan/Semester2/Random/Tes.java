package Random;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tes {
    private static final String FILENAME = "";

    public static void main(String[] args) {
        ArrayList<String> data = loadDataFromFile();

        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah data");
            System.out.println("2. Tampilkan semua data");
            System.out.println("3. Pilih data");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda: ");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    addData(data, scanner);
                    break;
                case "2":
                    displayAllData(data);
                    break;
                case "3":
                    selectData(data, scanner);
                    break;
                case "4":
                    System.out.println("Program ditutup. Data telah disimpan.");
                    saveDataToFile(data);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }
        } while (!input.equals("4"));
    }

    private static ArrayList<String> loadDataFromFile() {
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            // File tidak ditemukan atau kesalahan lain saat membaca, tidak perlu dilakukan
            // apa-apa
        }
        return data;
    }

    private static void saveDataToFile(ArrayList<String> data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (String line : data) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error: Gagal menyimpan data ke file.");
            e.printStackTrace();
        }
    }

    private static void addData(ArrayList<String> data, Scanner scanner) {
        System.out.print("Masukkan data baru: ");
        String newData = scanner.nextLine();
        data.add(newData);
        System.out.println("Data berhasil ditambahkan.");
    }

    private static void displayAllData(ArrayList<String> data) {
        if (data.isEmpty()) {
            System.out.println("Tidak ada data.");
        } else {
            System.out.println("Data yang tersimpan:");
            for (int i = 0; i < data.size(); i++) {
                System.out.println((i + 1) + ". " + data.get(i));
            }
        }
    }

    private static void selectData(ArrayList<String> data, Scanner scanner) {
        if (data.isEmpty()) {
            System.out.println("Tidak ada data.");
        } else {
            displayAllData(data);
            System.out.print("Pilih nomor data: ");
            int selection = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline
            if (selection >= 1 && selection <= data.size()) {
                System.out.println("Data yang dipilih: " + data.get(selection - 1));
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
