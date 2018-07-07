package nobetim.Controller;

import nobetim.DAO.DoctorsMongoDAO;
import nobetim.Request.RegisterNewDoctorRequest;
import nobetim.core.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author emirhan yasin cetin
 */
@Controller
public class RegisterNewDoctorController extends HttpServlet {

    @Autowired
    private DoctorsMongoDAO doctorsMongoDAO;

    @RequestMapping(value = "/newDoctor", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> registerDoctor(HttpServletRequest request, @RequestBody RegisterNewDoctorRequest registerNewDoctorRequest){
        Map<String, Object> responseBody = new HashMap<>();

        Doctor doctor = new Doctor();

        doctor.setId(registerNewDoctorRequest.getId());
        doctor.setFirstName(registerNewDoctorRequest.getFirstName());
        doctor.setLastName(registerNewDoctorRequest.getLastName());
        doctor.setLevel(registerNewDoctorRequest.getLevel());
        doctor.setAge(registerNewDoctorRequest.getAge());
        doctor.setHospital(registerNewDoctorRequest.getHospital());
        doctor.setDepartment(registerNewDoctorRequest.getDepartment());
        doctor.seteMail(registerNewDoctorRequest.geteMail());
        doctor.setGsmnumber(registerNewDoctorRequest.getGsmnumber());

        doctorsMongoDAO.setDoctor(doctor);

        responseBody.put("id", doctor.getId());
        responseBody.put("doctor", doctor);

        return new ResponseEntity<>(responseBody, HttpStatus.OK);

    }



}
