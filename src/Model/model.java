package Model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class model implements Imodel {
    @Override
    public void CreateDB() {
        //String url = "jdbc:sqlite:C:/sqlite/db/MyDB";
        String url = "jdbc:sqlite:MyDB";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                String userTable = "CREATE TABLE IF NOT EXISTS Users(\n"
                        + "	username text PRIMARY KEY,\n"
                        + "	password text NOT NULL,\n"
                        + "	dateOfBirth text NOT NULL,\n"
                        + "	firstName text NOT NULL,\n"
                        + "	lastName text NOT NULL,\n"
                        + "	city text NOT NULL);";
                createNewTable(url, userTable);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createNewTable(String url, String sql) {

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:MyDB";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    @Override
    public void CreateNewUser(String username,String password,String dateOfBirth,String firstName,String lastName,String city) {
        String sql = "INSERT INTO Users(username,password,dateOfBirth,firstName,lastName,city) VALUES(?,?,?,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
                    pstmt.setString(3, dateOfBirth);
                    pstmt.setString(4, firstName);
                    pstmt.setString(5, lastName);
                    pstmt.setString(6, city);
                    pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String[] ReadUser(String usr) {
        String sql = "SELECT username, password, dateOfBirth, firstName, lastName, city FROM Users WHERE username = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setString(1,usr);
            ResultSet rs  = pstmt.executeQuery();
            String[] res = new String[6];
            res[0] = rs.getString(1);
            res[1] = rs.getString(2);
            res[2] = rs.getString(3);
            res[3] = rs.getString(4);
            res[4] = rs.getString(5);
            res[5] = rs.getString(6);
            return res;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public void UpdateUser() {

    }

    @Override
    public void DeleteUser() {

    }
}
