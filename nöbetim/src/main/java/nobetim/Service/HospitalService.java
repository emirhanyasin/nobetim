package nobetim.Service;

import nobetim.core.Department;
import nobetim.core.Hospital;

import java.util.List;

/**
 * @author emrhan yasin cetin
 */
public interface HospitalService {

    List<Hospital> getHospitals();
    List<String> getHospitalNames();
    void setHospital(Hospital hospital);
    Hospital getHospitalByName(String hospitalName);
    void updateHospital(Hospital hospital);
    List<Department> getDepartments(String hospitalName);
}
