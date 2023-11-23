package entitas;

import database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pengguna extends Database {
    private String id_pengguna;
    private String password;
    
    public Pengguna(String id_pengguna, String password) {
        this.id_pengguna = id_pengguna;
        this.password = password;
    }
    
    public final boolean readData() {
        boolean loginSuccessful = false;

        try {
            openConnection();

            String sql = "SELECT * FROM pengguna WHERE ID_Pengguna = ? AND Password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id_pengguna);
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
}
