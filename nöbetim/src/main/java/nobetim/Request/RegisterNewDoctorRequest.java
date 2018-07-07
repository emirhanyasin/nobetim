package nobetim.Request;

/**
 * @author emirhan yasin cetin
 */
public class RegisterNewDoctorRequest {

    private String id;
    private String firstName;
    private String lastName;
    private int level;
    private int age;
    private String hospital;
    private String department;
    private String eMail;
    private String gsmnumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getGsmnumber() {
        return gsmnumber;
    }

    public void setGsmnumber(String gsmnumber) {
        this.gsmnumber = gsmnumber;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return "RegisterNewDoctorRequest{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level=" + level +
                ", age=" + age +
                ", hospital='" + hospital + '\'' +
                ", department='" + department + '\'' +
                ", eMail='" + eMail + '\'' +
                ", gsmnumber='" + gsmnumber + '\'' +
                '}';
    }
}
