/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FA506
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection conn;
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_NAME = "guiperpus";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/" + DB_NAME;
    private static final String DB_UNAME = "root";
    private static final String DB_PASS = "";

    public static Connection bukaKoneksi() {
        if (conn == null) {
            try {
                Class.forName(DB_DRIVER);
                conn = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASS);
                System.out.println("Koneksi berhasil!");
            } catch (ClassNotFoundException e) {
                System.err.println("Driver tidak ditemukan: " + e.getMessage());
            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
