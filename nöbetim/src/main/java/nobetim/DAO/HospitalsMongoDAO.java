package nobetim.DAO;

import nobetim.core.Department;
import nobetim.core.Hospital;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author emirhan yasin cetin
 */
public interface HospitalsMongoDAO {

    List<Hospital> getHospitals();
    List<String> getHospitalNames();
    Hospital getHospitalByName(String hospitalName);
    void setHospital(Hospital hospital);
    void updateHospital(Hospital hospital);
    List<Department> getDepartments(String hospitalName);

}
