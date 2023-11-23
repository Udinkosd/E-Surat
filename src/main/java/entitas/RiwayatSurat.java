package entitas;

import controller.DataUpdate;
import database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RiwayatSurat extends Database {
    private String nim;
    private String alamat;
    private String tempatLahir;
    private String angkatan;
    private String ipk;
    private String program;
    private String jenjang;
    private String kontak;

    public boolean insertData(String jenisSurat, String posisiSurat, String action, String idPengajuan) {
        boolean insertSuccessful = false;
        
        try {
            openConnection();

            String sql = "INSERT INTO riwayat_surat (Jenis_Surat, Status, Posisi_Surat, Action, Pengajuan_ID_Pengajuan) VALUES (?, 'Pending', ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, jenisSurat);
            preparedStatement.setString(2, posisiSurat);
            preparedStatement.setString(3, action);
            preparedStatement.setString(4, idPengajuan);

            int rowsInserted = preparedStatement.executeUpdate();

            insertSuccessful = rowsInserted > 0;
        } catch (SQLException e) {
            Logger.getLogger(RiwayatSurat.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }

        return insertSuccessful;
    }
    
    public List<String[]> readData() {
        List<String[]> data = new ArrayList<>();

        try {
            openConnection();

            String sql = "SELECT * FROM riwayat_surat"; 
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idSurat = resultSet.getString("ID_Surat");
                String jenisSurat = resultSet.getString("Jenis_Surat");
                String status = resultSet.getString("Status");
                String posisiSurat = resultSet.getString("Posisi_Surat");
                String action = resultSet.getString("Action");
                String pengajuanID = resultSet.getString("Pengajuan_ID_Pengajuan");

                String[] row = {idSurat, jenisSurat, status, posisiSurat, action, pengajuanID};
                data.add(row);
            }
        } catch (SQLException e) {
            Logger.getLogger(RiwayatSurat.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            openConnection();
        }
        return data;
    }
    
    public final boolean updateData(DataUpdate dataUpdate) {
      boolean updateSuccessful = false;

      try {
          openConnection();

          String sql = "UPDATE riwayat_surat SET Status = ? WHERE ID_Surat = ?";
          PreparedStatement preparedStatement = connection.prepareStatement(sql);
          preparedStatement.setString(1, dataUpdate.getStatus()); 
          preparedStatement.setString(2, dataUpdate.getNim());

          int rowsUpdated = preparedStatement.executeUpdate();

          if (rowsUpdated > 0) {
              updateSuccessful = true;
          }
      } catch (SQLException e) {
          e.printStackTrace();
      } finally {
          closeConnection();
      }

      return updateSuccessful;
  }
}


