package App;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Pembuka {
    public static void main(String[] args) {
        // Untuk memanggil file Muqodimah.txt
        String filePath = "src\\Project1\\SuksesDeh\\Muqodimah.txt";

        // Panggil metode untuk membaca dan menampilkan kontennya
        try {
            tampilkanIsiFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void tampilkanIsiFile(String filePath) throws IOException {
        // Gunakan Paths.get() untuk membuat objek Path dari path file
        Path path = Paths.get(filePath);

        // Gunakan Files.readAllLines() untuk membaca semua baris dari file ke dalam
        // List
        List<String> baris = Files.readAllLines(path);

        // Tampilkan setiap baris di konsol
        for (String line : baris) {
            System.out.println(line);
        }
    }
}

// penjelasan dari kode di atas.?

// ketika di Main berjalan.?

// Path path = Paths.get(filePath);: Membuat objek Path dari alamat file yang
// diberikan (filePath).
// List<String> baris = Files.readAllLines(path);: Membaca semua baris dari file
// ke dalam objek List<String>.
// for (String line : baris) { System.out.println(line); }: Menampilkan setiap
// baris dari objek List<String> ke konsol.

// package Project1.ParengSambat;: Mendefinisikan package tempat kelas (Pembuka)
// berada.
// import java.io.BufferedReader;: Mengimpor kelas BufferedReader dari paket
// java.io, yang digunakan untuk membaca teks dari suatu input stream.
// import java.io.FileReader;: Mengimpor kelas FileReader dari paket java.io,
// yang digunakan untuk membaca karakter dari suatu file.
// import java.io.IOException;: Mengimpor kelas IOException dari paket java.io,
// yang merupakan exception yang dilempar saat terjadi kesalahan input/output.
// import java.nio.file.Files;: Mengimpor kelas Files dari paket java.nio.file,
// yang menyediakan metode untuk operasi pada file dan direktori.
// import java.nio.file.Path;: Mengimpor kelas Path dari paket java.nio.file,
// yang digunakan untuk merepresentasikan path (alamat) dalam sistem berkas.
// import java.nio.file.Paths;: Mengimpor kelas Paths dari paket java.nio.file,
// yang menyediakan metode-fabrik untuk objek Path.
// import java.util.List;: Mengimpor kelas List dari paket java.util, yang
// merupakan antarmuka untuk daftar (list) yang diimplementasikan oleh kelas
// ArrayList, LinkedList, dll.

// disaat ketika di jalankan :

// public class Pembuka { ... }: Mendefinisikan kelas Pembuka.
// public static void main(String[] args) { ... }: Metode main, yang merupakan
// titik masuk untuk eksekusi program.
// Saat program dijalankan, metode ini akan dijalankan terlebih dahulu.

// public static void tampilkanIsiFile(String filePath) throws IOException { ...
// }: Metode tampilkanIsiFile yang digunakan untuk membaca dan menampilkan isi
// file.
// Metode ini mendeklarasikan bahwa ia dapat melempar exception IOException.

// isi dari method tampilkanIsiFile :

// Path path = Paths.get(filePath);: Membuat objek Path dari alamat file yang
// diberikan (filePath).
// List<String> baris = Files.readAllLines(path);: Membaca semua baris dari file
// ke dalam objek List<String>.
// for (String line : baris) { System.out.println(line); }: Menampilkan setiap
// baris dari objek List<String> ke konsol.