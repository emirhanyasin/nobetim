package nobetim.Request;

/**
 * @author emirhan yasin cetin
 */
public class GetDepartmentsRequest {

    private String hospitalName;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @Override
    public String toString() {
        return "GetDepartmentsRequest{" +
                "hospitalName='" + hospitalName + '\'' +
                '}';
    }
}
