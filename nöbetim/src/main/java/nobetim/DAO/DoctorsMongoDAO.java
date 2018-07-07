package nobetim.DAO;

import nobetim.core.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author emirhan yasin cetin
 */
public interface DoctorsMongoDAO {

    List<Doctor> getDoctors();
    List<String> getDoctorNames();
    Doctor getDoctorById(String id);
    void setDoctor(Doctor doctor);
    void deleteDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
}
