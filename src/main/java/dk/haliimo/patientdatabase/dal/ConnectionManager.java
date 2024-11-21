package dk.haliimo.patientdatabase.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;


public class ConnectionManager {
    private final SQLServerDataSource ds;

    public ConnectionManager()
    {


        ds = new SQLServerDataSource();
        ds.setServerName("EASV-DB4");
        ds.setDatabaseName("halaad01_PatientDatabase");
        ds.setPortNumber(1433);
        ds.setUser("CSe2024b_e_9");
        ds.setPassword("CSe2024bE9!24");
        ds.setTrustServerCertificate(true);
    }

    public Connection getConnection() throws SQLServerException
    {
        return ds.getConnection();
    }

}

