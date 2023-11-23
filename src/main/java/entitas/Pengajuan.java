package entitas;

import database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pengajuan extends Database {
    private String peruntukanValue;
    private String mahasiswaNIM;
    private String roleChecker;

    public Pengajuan(String peruntukanValue, String mahasiswaNIM, String roleChecker) {
        this.peruntukanValue = peruntukanValue;
        this.mahasiswaNIM = mahasiswaNIM;
        this.roleChecker = roleChecker;
    }

    public String insertData() {
        String generatedId = null;

        try {
            openConnection();

            String sql = "INSERT INTO pengajuan (Peruntukan, Lampiran, Mahasiswa_NIM1, Aktivitas_ID_Aktivitas) VALUES (?, 'Null', ?, 'null')";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, peruntukanValue);
            preparedStatement.setString(2, roleChecker);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getString(1);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Pengajuan.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }

        return generatedId;
    }
    
    public String readData(String nimToCheck) {
        String peruntukan = null;
        try {
            openConnection();

            String sql = "SELECT Peruntukan FROM pengajuan WHERE Mahasiswa_NIM1 = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nimToCheck);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                peruntukan = resultSet.getString("Peruntukan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pengajuan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return peruntukan;
    }
}