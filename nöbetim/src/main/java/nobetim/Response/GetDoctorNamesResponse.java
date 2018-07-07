package nobetim.Response;

import java.util.List;

/**
 * @author emirhan yasin cetin
 */
public class GetDoctorNamesResponse {

    private List<String> doctorNames;

    public List<String> getDoctorNames() {
        return doctorNames;
    }

    public void setDoctorNames(List<String> doctorNames) {
        this.doctorNames = doctorNames;
    }

    @Override
    public String toString() {
        return "GetDoctorNamesResponse{" +
                "doctorNames=" + doctorNames +
                '}';
    }
}
