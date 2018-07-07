package nobetim.Service;

import nobetim.DAO.HospitalsMongoDAO;
import nobetim.core.Department;
import nobetim.core.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author emirhan yasin cetin
 */
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalsMongoDAO hospitalsMongoDAO;

    @Override
    public List<Hospital> getHospitals() {
        return hospitalsMongoDAO.getHospitals();
    }

    @Override
    public List<String> getHospitalNames() {
        return hospitalsMongoDAO.getHospitalNames();
    }

    @Override
    public Hospital getHospitalByName(String hospitalName){
        return hospitalsMongoDAO.getHospitalByName(hospitalName);
    }

    @Override
    public void setHospital(Hospital hospital) {
        hospitalsMongoDAO.setHospital(hospital);
    }

    @Override
    public void updateHospital(Hospital hospital){hospitalsMongoDAO.updateHospital(hospital);}

    @Override
    public List<Department> getDepartments(String hospitalName) {

        return hospitalsMongoDAO.getDepartments(hospitalName);
    }

}
