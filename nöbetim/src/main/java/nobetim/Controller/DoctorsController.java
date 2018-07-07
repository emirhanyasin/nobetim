package nobetim.Controller;

import nobetim.Request.DeleteDoctorRequest;
import nobetim.Request.GetDoctorByIdRequest;
import nobetim.Request.UpdateDoctorRequest;
import nobetim.Response.GetDoctorByIdResponse;
import nobetim.Response.GetDoctorNamesResponse;
import nobetim.Response.GetDoctorsResponse;
import nobetim.Service.DoctorService;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author emirhan yasin cetin
 */
@Controller
public class DoctorsController extends HttpServlet {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/allDoctors", method = RequestMethod.GET)
    public ResponseEntity<GetDoctorsResponse> getDoctors(HttpServletRequest request){

        GetDoctorsResponse response = new GetDoctorsResponse();
        List<Doctor> doctors = doctorService.getDoctors();

        Collections.sort(doctors, new levelComparator());

        response.setDoctors(doctors);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/allDoctorNames", method = RequestMethod.GET)
    public ResponseEntity<GetDoctorNamesResponse> getDoctorNames(HttpServletRequest request){

        GetDoctorNamesResponse response = new GetDoctorNamesResponse();
        List<Doctor> doctors = doctorService.getDoctors();

        Collections.sort(doctors, new levelComparator());

        List<String> doctorNames = new ArrayList<>();

        for(int i=0; i<doctors.size(); i++){
            doctorNames.add(doctors.get(i).getFirstName() + " " + doctors.get(i).getLastName());
        }

        response.setDoctorNames(doctorNames);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @RequestMapping(value = "/getDoctorById", method = RequestMethod.GET)
    public ResponseEntity<GetDoctorByIdResponse> getDoctorById(HttpServletRequest request, @RequestBody GetDoctorByIdRequest getDoctorByIdRequest){

        GetDoctorByIdResponse response = new GetDoctorByIdResponse();
        Doctor doctor = doctorService.getDoctorById(getDoctorByIdRequest.getId());

        response.setDoctor(doctor);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteDoctor", method = RequestMethod.POST)
    public ResponseEntity deleteDoctor(HttpServletRequest request, @RequestBody DeleteDoctorRequest deleteDoctorRequest){

        Doctor doctor = doctorService.getDoctorById(deleteDoctorRequest.getId());
        doctorService.deleteDoctor(doctor);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/updateDoctor", method = RequestMethod.POST)
    public ResponseEntity updateDoctor(HttpServletRequest request, @RequestBody UpdateDoctorRequest updateDoctorRequest){

        Doctor doctor = new Doctor();

        doctor.setId(updateDoctorRequest.getId());
        doctor.setFirstName(updateDoctorRequest.getFirstName());
        doctor.setLastName(updateDoctorRequest.getLastName());
        doctor.setLevel(updateDoctorRequest.getLevel());
        doctor.setAge(updateDoctorRequest.getAge());
        doctor.setHospital(updateDoctorRequest.getHospital());
        doctor.setDepartment(updateDoctorRequest.getDepartment());
        doctor.seteMail(updateDoctorRequest.geteMail());
        doctor.setGsmnumber(updateDoctorRequest.getGsmnumber());

        doctorService.updateDoctor(doctor);

        return new ResponseEntity(HttpStatus.OK);
    }

}

class levelComparator implements Comparator<Doctor> {
    public int compare(Doctor doctor, Doctor doctor1) {
        if (doctor.getLevel() == doctor1.getLevel()) {
            return 0;
        } else if (doctor.getLevel() > doctor1.getLevel()) {
            return 1;
        } else {
            return -1;
        }
    }
}
