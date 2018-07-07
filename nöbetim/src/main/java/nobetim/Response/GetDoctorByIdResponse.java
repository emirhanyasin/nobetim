package nobetim.Response;

import nobetim.core.Doctor;

/**
 * @author emirhan yasin cetin
 */
public class GetDoctorByIdResponse {

    private Doctor doctor;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "GetDoctorByIdResponse{" +
                "doctor=" + doctor +
                '}';
    }
}
