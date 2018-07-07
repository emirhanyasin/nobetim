package nobetim.Controller;

import nobetim.Request.RegisterNewHospitalRequest;
import nobetim.Service.HospitalService;
import nobetim.core.Department;
import nobetim.core.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author emirhan yasin cetin
 */
@Controller
public class RegisterNewHospitalController extends HttpServlet {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping(value = "/newHospital", method = RequestMethod.POST)
    public ResponseEntity registerHospital(HttpServletRequest request, @RequestBody RegisterNewHospitalRequest registerNewHospitalRequest){

        if(hospitalService.getHospitalByName(registerNewHospitalRequest.getHospitalName()) == null){
            Hospital hospital = new Hospital();
            List<Department> departments = new ArrayList<>();
            Department department = new Department();
            department.setName(registerNewHospitalRequest.getDepartmentName());
            department.setPassword(registerNewHospitalRequest.getPassword());
            departments.add(department);

            hospitalService.setHospital(hospital);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        Hospital hospital = hospitalService.getHospitalByName(registerNewHospitalRequest.getHospitalName());
        List<Department> departments = hospital.getDepartments();
        Department department = new Department();
        department.setName(registerNewHospitalRequest.getDepartmentName());
        department.setPassword(registerNewHospitalRequest.getPassword());
        departments.add(department);

        hospitalService.setHospital(hospital);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
