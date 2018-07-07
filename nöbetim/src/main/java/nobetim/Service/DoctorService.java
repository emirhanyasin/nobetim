package nobetim.Service;

import nobetim.core.Doctor;

import java.util.List;

/**
 * @author emirhan yasin cetin
 */
public interface DoctorService {

    List<Doctor> getDoctors();
    List<String> getDoctorNames();
    Doctor getDoctorById(String id);
    void setDoctor(Doctor doctor);
    void deleteDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);

}
