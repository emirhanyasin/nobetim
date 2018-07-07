package nobetim.Controller;

import nobetim.Request.GetDepartmentsRequest;
import nobetim.Response.GetDepartmentsResponse;
import nobetim.Response.GetHospitalsResponse;
import nobetim.Service.HospitalService;
import nobetim.core.Department;
import nobetim.core.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author emirhan yasin cetin
 */
@Controller
public class HospitalController extends HttpServlet {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping(value = "/allHospitals", method = RequestMethod.GET)
    public ResponseEntity<GetHospitalsResponse> getHospitals(HttpServletRequest request){

        GetHospitalsResponse response = new GetHospitalsResponse();

        List<Hospital> hospitals = hospitalService.getHospitals();
        response.setHospitals(hospitals);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public ResponseEntity<GetDepartmentsResponse> getDepartments(HttpServletRequest request, @RequestBody GetDepartmentsRequest getDepartmentsRequest){

        GetDepartmentsResponse response = new GetDepartmentsResponse();

        List<Department> departments = hospitalService.getDepartments(getDepartmentsRequest.getHospitalName());

        response.setDepartments(departments);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
