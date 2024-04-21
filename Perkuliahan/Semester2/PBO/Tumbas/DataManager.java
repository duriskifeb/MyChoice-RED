package PBO.Tumbas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManager {
    private static final String FILENAME = "RekayasaPusing\\src\\PBO\\Tumbas\\Database.txt";

    // AKSES_KE_DATABASE
    public void saveData(ArrayList<Kelompok> listKelompok) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Kelompok nilai : listKelompok) {
                writer.println(nilai.toDatabaseString());
            }
            System.out.println("\nData diperbarui");
        } catch (IOException e) {
            System.err.println("Error : saveData()");
            e.printStackTrace();
        }
    }

    public ArrayList<Kelompok> loadData() {
        ArrayList<Kelompok> listKelompok = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String nama = parts[0].trim();
                int n1 = Integer.parseInt(parts[3].trim());
                int n2 = Integer.parseInt(parts[4].trim());
                int n3 = Integer.parseInt(parts[5].trim());
                int n4 = 0;
                if (parts.length == 7) {
                    n4 = Integer.parseInt(parts[6].trim());
                }

                String jenis = parts[1].trim();

                Lomba lomba;
                switch (jenis) {
                    case "UIUX":
                        lomba = new UIUX(n1, n2, n3, n4);
                        listKelompok.add(new Kelompok(nama, lomba));
                        break;

                    case "Algo":
                        lomba = new Algo(n1, n2, n3);
                        listKelompok.add(new Kelompok(nama, lomba));
                        break;

                    case "Data":
                        lomba = new Data(n1, n2, n3);
                        listKelompok.add(new Kelompok(nama, lomba));
                        break;

                    case "Lomba":
                        lomba = new Lomba(n1, n2, n3, n4);
                        listKelompok.add(new Kelompok(nama, lomba));
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error : loadAllData()");
            e.printStackTrace();
        }
        return listKelompok;
    }

    // OPERASI_DATA_KELOMPOK
    public Kelompok getKelompok(ArrayList<Kelompok> listKelompok) {
        System.out.print("\nMasukkan nama kelompok : ");
        String nama = Util.inputLine().toLowerCase();
        for (Kelompok kelompok : listKelompok) {
            if (nama.equals(kelompok.getNama().toLowerCase())) {
                return kelompok;
            }
        }
        return null;
    }

    public void addData() {
        ArrayList<Kelompok> listKelompok = loadData();
        System.out.print("\nMasukkan nama kelompok : ");
        String nama = Util.inputLine();
        listKelompok.add(new Kelompok(nama, new Lomba(0, 0, 0, 0)));
        saveData(listKelompok);
    }

    public void deleteData() {
        ArrayList<Kelompok> listKelompok = loadData();
        Kelompok kelompok = getKelompok(listKelompok);
        if (kelompok != null) {
            listKelompok.remove(kelompok);
            YesOrNo(FILENAME);//pilihan untuk menghapus keliompok;
            saveData(listKelompok);
        } else {
            System.out.println("\nData tidak ditemukan");
        }
    }

    public void searchKelompok() {
        ArrayList<Kelompok> listKelompok = loadData();
        System.out.print("\nMasukkan nama kelompok : ");
        String nama = Util.inputLine().toLowerCase();
        for (Kelompok kelompok : listKelompok) {
            if (kelompok.getNama().toLowerCase().contains(nama)) {
                System.out.println(kelompok);
            }
        }
    }

    // OPERASI_DATA_LOMBA
    public ArrayList<Kelompok> getListLomba(Lomba lomba) {
        ArrayList<Kelompok> listKelompok = new ArrayList<>();
        for (Kelompok kelompok : loadData()) {
            String jenisLomba = kelompok.getLomba().getClass().getName();
            if (jenisLomba.equals(lomba.getClass().getName())) {
                listKelompok.add(kelompok);
            }
        }
        return listKelompok;
    }

    public void setLomba(Lomba lomba) {
        ArrayList<Kelompok> listKelompok = loadData();
        Kelompok selectedKelompok = getKelompok(listKelompok);
        if (selectedKelompok != null) {
            for (Kelompok kelompok : listKelompok) {
                if (kelompok.getNama() == selectedKelompok.getNama()) {
                    if (kelompok.getLomba().getClass().getSimpleName().equals("Lomba")) {
                        listKelompok.set(listKelompok.indexOf(kelompok),
                                new Kelompok(selectedKelompok.getNama(), lomba));
                        saveData(listKelompok);
                    } else {
                        System.out.println("\n\"" + selectedKelompok.getNama() + "\" sudah memiliki lomba");
                    }
                }
            }
        } else {
            System.out.println("\nData tidak ditemukan");
        }
    }

    public void addNilai(Lomba lomba) {
        ArrayList<Kelompok> listKelompok = loadData();
        Kelompok selectedKelompok = getKelompok(listKelompok);

        if (selectedKelompok != null) {
            for (Kelompok kelompok : listKelompok) {
                if (kelompok.getNama() == selectedKelompok.getNama()) {
                    if (!selectedKelompok.getLomba().getClass().getSimpleName().equals("Lomba")) {
                        if (kelompok.getLomba().getClass().getSimpleName().equals(lomba.getClass().getSimpleName())) {
                            lomba = setNilai(selectedKelompok, lomba);
                            listKelompok.set(listKelompok.indexOf(kelompok),
                                    new Kelompok(selectedKelompok.getNama(), lomba));
                            saveData(listKelompok);
                        } else {
                            System.out.println("\n\"" + selectedKelompok.getNama() + "\" sudah memiliki lomba");
                        }
                    } else {
                        System.out.println("\n\"" + selectedKelompok.getNama() + "\" belum memilih lomba");
                    }
                }
            }
        } else {
            System.out.println("\nData tidak ditemukan");
        }
    }

    public Lomba setNilai(Kelompok selectedKelompok, Lomba lomba) {
        System.out.println("\n\nMasukkan Nilai :");
        if (lomba.getClass().getSimpleName().equals("UIUX")) {
            System.out.print("1. Penjelasan latar belakang dan target produk : ");
            lomba.nilai1 = Util.inputInt();
            System.out.print("2. Skenario penggunaan : ");
            lomba.nilai1 = Util.inputInt();
            System.out.print("3. Desain : ");
            lomba.nilai1 = Util.inputInt();
            System.out.print("4. Konsistensi : ");
            lomba.nilai1 = Util.inputInt();
        }else if (lomba.getClass().getSimpleName().equals("Algo")) {
            System.out.print("1. Ketepatan hasil : ");
            lomba.nilai2 = Util.inputInt();
            System.out.print("2. Waktu Ekseskusi : ");
            lomba.nilai2 = Util.inputInt();
            System.out.print("3. Pemanfaatan resource : ");
            lomba.nilai2 = Util.inputInt();
        }else if (lomba.getClass().getSimpleName().equals("Data")) {
            System.out.print("1. ketepatan hasil : ");
            lomba.nilai3 = Util.inputInt();
            System.out.print("2. Waktu eksekusi : ");
            lomba.nilai3 = Util.inputInt();
            System.out.print("3. Pemanfaatan resource : ");
            lomba.nilai3 = Util.inputInt();
        }
        return lomba;
    }

    public static boolean YesOrNo(String message) {
        while (true) {
            try {
                System.out.println("\nApakah yakin menghapus.? \n");
                System.out.print(message + "| Pilih : (ya/tidak)");
                String input = Util.inputString().toLowerCase();
                if (input.equals("ya")) {
                    return true;
                } else if (input.equals("tidak")) {
                    return false;
                } else {
                    throw new IllegalArgumentException("Masukan harus 'ya' atau 'tidak'.");
                }
            } catch (Exception e) {
                System.out.println("\nError: " + e.getMessage());
            }
        }
    }

}
