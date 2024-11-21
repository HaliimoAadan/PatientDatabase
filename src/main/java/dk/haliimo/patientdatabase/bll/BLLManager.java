package dk.haliimo.patientdatabase.bll;

import dk.haliimo.patientdatabase.be.Patient;
import dk.haliimo.patientdatabase.dal.DALManager;

import java.util.List;

public class BLLManager
{
    private DALManager dalManager = new DALManager();
    private static BLLManager instance;

    public static BLLManager getInstance()
    {
        if (instance == null)
        {
            instance = new BLLManager();
        }

        return instance;
    }
    private BLLManager()
    {
    }

    public List<Patient> getAllPatients()
    {
        return dalManager.getAllPatients();
    }

    public void deletePatient(Patient p){
        dalManager.deletePatient(p);
    }
}
