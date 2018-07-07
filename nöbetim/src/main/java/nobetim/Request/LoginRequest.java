package nobetim.Request;

/**
 * @author emirhan yasin cetin
 */
public class LoginRequest {

    private String hospitalName;
    private String departmentName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    @Override
    public String toString() {
        return "LoginRequest{" +
                "hospitalName='" + hospitalName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
