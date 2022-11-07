
public class Citizen {
    private String name;
    private String ic;
    private String state;
    private int age;
    private String typeofvaccine;
    private String stat1stDose;
    private String stat2ndDose;
    private String certificate;


    public Citizen() {
        this.name = null;
        this.ic = null;
        this.state = null;
        this.age = 0;
        this.typeofvaccine = null;
    }

    public Citizen(String name, String ic, String state, int age, String typeofvaccine, String stat1stDose, String stat2ndDose, String certificate) {
        this.name = name;
        this.ic = ic;
        this.state = state;
        this.age = age;
        this.typeofvaccine = typeofvaccine;
        this.stat1stDose = stat1stDose;
        this.stat2ndDose = stat2ndDose;
        this.certificate = certificate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTypeofvaccine(String typeofvaccine) {
        this.typeofvaccine = typeofvaccine;
    }

    public void setStat1stDose(String status) {
        this.stat1stDose = status;
    }

    public void setStat2ndDose(String status) {
        this.stat2ndDose = status;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getName() {
        return(this.name);
    }

    public String getIc() {
        return(this.ic);
    }

    public String getState() {
        return(this.state);
    }

    public int getAge() {
        return(this.age);
    }

    public String getTypeofvaccine() {
        return(this.typeofvaccine);
    }

    public String getStat1stDose() {
        return(this.stat1stDose);
    }

    public String getStat2ndDose() {
        return(this.stat2ndDose);
    }

    public String getCertificate() {
        return(this.certificate);
    }

    public String toString() {
        return "Name: " + this.name + "\nIc: " + this.ic + "\nState: " + this.state + "\nAge: " + this.age + "\nType Of Vaccine: " + this.typeofvaccine + "\n1st Dose: " + this.stat1stDose + "\n2nd Dose: " + this.stat2ndDose + "\nCertificate: " + this.certificate;
    }
}