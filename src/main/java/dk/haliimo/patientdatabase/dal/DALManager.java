package dk.haliimo.patientdatabase.dal;


import dk.haliimo.patientdatabase.be.Patient;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DALManager{

    ConnectionManager cm;

    public DALManager(){
        cm = new ConnectionManager();
    }


    public void deletePatient(Patient p)  {
        try(Connection con = cm.getConnection())
        {
            String sql = "DELETE FROM Patients WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, p.getId());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList();
        try (Connection con = cm.getConnection()) {
            String sqlcommandSelect = "SELECT * FROM Patients";
            PreparedStatement pstmtSelect = con.prepareStatement(sqlcommandSelect);
            ResultSet rs = pstmtSelect.executeQuery();
            while(rs.next())
            {
                patients.add(new Patient(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("diagnosis"))
                );
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return patients;
    }
}
