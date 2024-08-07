package App;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Sambutan {

    public static void main(String[] args) {
        String filePath = "src\\Project1\\TugasBesar\\LebihBesar\\Sambutan.txt";

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