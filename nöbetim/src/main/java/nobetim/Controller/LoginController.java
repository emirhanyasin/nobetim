package nobetim.Controller;

import nobetim.Request.LoginRequest;
import nobetim.Service.HospitalService;
import nobetim.core.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author emirhan yasin cetin
 */
@Controller
public class LoginController extends HttpServlet {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<Boolean> isAuthenticate(HttpServletRequest request, @RequestBody LoginRequest loginRequest){

        boolean response = false;

        List<Hospital> hospitals = hospitalService.getHospitals();

        for(int i=0; i<hospitals.size(); i++){
            if(loginRequest.getHospitalName().equals(hospitals.get(i).getName())){
                Hospital hospital = hospitals.get(i);
                for(int j=0; j<hospital.getDepartments().size(); j++){
                    if(loginRequest.getDepartmentName().equals(hospital.getDepartments().get(i).getName()) && loginRequest.getPassword().equals(hospital.getDepartments().get(i).getPassword())){
                        response = true;
                    }
                }
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/")
    public String stdRedirect(){
        return "redirect:/nobetim/authenticate";
    }

    @RequestMapping(value="/nobetim/authenticate", method=RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("Login");
    }

}
