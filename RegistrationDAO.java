package BackendProject.BackendProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO {

    // Create
    public void createUser(String name, String email, String dob, String phone, String address) {
        String query = "INSERT INTO Registration (Name, Email, DateOfBirth, PhoneNumber, Address) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setDate(3, Date.valueOf(dob));
            stmt.setString(4, phone);
            stmt.setString(5, address);
            stmt.executeUpdate();
            System.out.println("User created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public List<String> readUsers() {
        String query = "SELECT * FROM Registration";
        List<String> users = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String user = "ID: " + rs.getInt("ID") +
                              ", Name: " + rs.getString("Name") +
                              ", Email: " + rs.getString("Email") +
                              ", DOB: " + rs.getDate("DateOfBirth") +
                              ", Phone: " + rs.getString("PhoneNumber") +
                              ", Address: " + rs.getString("Address");
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Update
    public void updateUser(int id, String name, String email) {
        String query = "UPDATE Registration SET Name = ?, Email = ? WHERE ID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully!");
            } else {
                System.out.println("No user found with the given ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteUser(int id) {
        String query = "DELETE FROM Registration WHERE ID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully!");
            } else {
                System.out.println("No user found with the given ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

