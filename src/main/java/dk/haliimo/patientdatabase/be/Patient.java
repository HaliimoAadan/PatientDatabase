package dk.haliimo.patientdatabase.be;

public class Patient
{
    private int id;
    private String name;
    private String email;
    private String diagnosis;

    public Patient(int id, String name, String email, String diagnosis)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis()
    {
        return diagnosis;
    }

    public String getEmail()
    {
        return email;
    }

    public String getName()
    {
        return name;
    }


    public int getId()
    {
        return id;
    }

}