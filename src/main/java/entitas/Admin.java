package entitas;

import database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin extends Database {
    private String email;
    private String password;
    
    public Admin (String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public final boolean readData() {
        boolean loginSuccessful = false;

        try {
            openConnection();

            String sql = "SELECT * FROM admin WHERE Email = ? AND Password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            loginSuccessful = resultSet.next();
        } catch (SQLException e) {
            Logger.getLogger(Pengguna.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }

        return loginSuccessful;
    }
    
    public String findData(String suratID) {
        String nim = null;
        try {
            String sql = "SELECT Mahasiswa_NIM1 FROM pengajuan WHERE ID_Pengajuan = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, suratID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                nim = resultSet.getString("Mahasiswa_NIM1");
            }
        } catch (SQLException e) {
        }
        return nim;
    }
}