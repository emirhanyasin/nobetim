package nobetim.Request;

/**
 * @author emirhan yasin cetin
 */
public class RegisterNewHospitalRequest {

    private String hospitalName;
    private String departmentName;
    private String password;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterNewHospitalRequest{" +
                "hospitalName='" + hospitalName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
