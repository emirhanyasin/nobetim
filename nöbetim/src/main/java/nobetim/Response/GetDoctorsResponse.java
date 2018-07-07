package nobetim.Response;

import nobetim.core.Doctor;

import java.util.List;

/**
 * @author emirhan yasin cetin
 */
public class GetDoctorsResponse {

    private List<Doctor> doctors;

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctor) {
        this.doctors = doctor;
    }

    @Override
    public String toString() {
        return "GetDoctorsResponse{" +
                "doctor=" + doctors +
                '}';
    }
}
