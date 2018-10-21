package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Users {

    public void CreateNewUser(String username,String password,String dateOfBirth,String firstName,String lastName,String city) {
        String sql = "INSERT INTO Users(username,password,dateOfBirth,firstName,lastName,city) VALUES(?,?,?,?,?,?)";
        try (Connection conn = model.connect();
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


    public String[] ReadUser(String usr) {
        String sql = "SELECT username, password, dateOfBirth, firstName, lastName, city FROM Users WHERE username = ?";
        try (Connection conn = model.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setString(1,usr);
            ResultSet rs  = pstmt.executeQuery();
            if(rs.isClosed()) {
                String[] res = new String[1];
                res[0] = "The given username is not exist";
                return res;
            }
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

    public void UpdateUser(String username,String password,String dateOfBirth,String firstName,String lastName,String city) {
        String sql = "UPDATE Users SET password = ? , "
                + "dateOfBirth = ?, "
                + "firstName = ?, "
                + "lastName = ?, "
                + "city = ? "
                + "WHERE username = ?";

        try (Connection conn = model.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, password);
            pstmt.setString(2, dateOfBirth);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, city);
            pstmt.setString(6, username);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void DeleteUser(String userName) {
        String sql = "DELETE FROM Users WHERE userName = ?";

        try (Connection conn = model.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, userName);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}