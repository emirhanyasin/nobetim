package nobetim.Response;

import nobetim.core.Doctor;
import nobetim.core.Hospital;

import java.util.List;

/**
 * @author emirhan yasin cetin
 */
public class GetHospitalsResponse {

    private List<Hospital> hospitals;

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    @Override
    public String toString() {
        return "GetHospitalsResponse{" +
                "hospitals=" + hospitals +
                '}';
    }
}
