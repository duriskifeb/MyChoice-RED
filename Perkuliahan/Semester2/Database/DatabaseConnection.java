package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private Connection connection = null;

    public void openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classicmodels",
                    "pbo",
                    "pbokeren123");
            System.out.println("Koneksi sukses!");
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        }
    }

    public ResultSet getData(String query) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return resultSet;
    }

    public int executeStatement(String query) {
        int resultCount = 0;
        try {
            Statement statement = connection.createStatement();
            resultCount = statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultCount;
    }

    public void insertData() {
        try {
            System.out.println("Inserting new record...");
            String query = "INSERT INTO testTable VALUES (null, 'Bejo', 10, '2023-06-23')";
            executeStatement(query);
            System.out.println("Data successfully inserted.");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
