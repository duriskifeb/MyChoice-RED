package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FileDriver {

    public static void main(String[] args) {
        // Membuat instance DatabaseConnection
        DatabaseConnection databaseConnection = new DatabaseConnection();

        // Membuka koneksi ke database
        databaseConnection.openConnection();

        // Contoh penggunaan: mendapatkan data dari database
        String queryGetData = "SELECT * FROM testTable";
        ResultSet resultSet = null;
        try {
            // Mendapatkan data menggunakan DatabaseConnection
            resultSet = databaseConnection.getData(queryGetData);

            // Proses data dari resultSet jika diperlukan
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int jumlah = resultSet.getInt("jumlah");
                String tanggal = resultSet.getString("tanggalTransaksi");
                System.out.println(id + " " + name + " " + jumlah + " " + tanggal);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            // Menutup result set setelah penggunaan selesai
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        // Contoh penggunaan: menjalankan pernyataan SQL
        String queryExecute = "UPDATE your_table SET column1 = value1 WHERE condition";
        int resultCount = databaseConnection.executeStatement(queryExecute);
        System.out.println("Jumlah baris yang terpengaruh: " + resultCount);

        // Contoh penggunaan: memasukkan data baru ke database
        databaseConnection.insertData();

        // Menutup koneksi setelah selesai digunakan
        databaseConnection.closeConnection();
    }
}
