package nobetim.Service;

import nobetim.DAO.DoctorsMongoDAO;
import nobetim.core.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author emirhan yasin cetin
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorsMongoDAO doctorsMongoDAO;

    @Override
    public List<Doctor> getDoctors() {
        return doctorsMongoDAO.getDoctors();
    }

    @Override
    public List<String> getDoctorNames() {
        return doctorsMongoDAO.getDoctorNames();
    }

    @Override
    public Doctor getDoctorById(String id){
        return doctorsMongoDAO.getDoctorById(id);
    }

    @Override
    public void setDoctor(Doctor doctor) {
        doctorsMongoDAO.setDoctor(doctor);
    }

    @Override
    public void deleteDoctor(Doctor doctor) {
        doctorsMongoDAO.deleteDoctor(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor){
        doctorsMongoDAO.updateDoctor(doctor);
    }
}
