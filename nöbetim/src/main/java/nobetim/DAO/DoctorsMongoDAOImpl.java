package nobetim.DAO;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import nobetim.Request.RegisterNewDoctorRequest;
import nobetim.core.Doctor;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author emirhan yasin cetin
 */
@Service
public class DoctorsMongoDAOImpl implements DoctorsMongoDAO {

    @Override
    public List<Doctor> getDoctors() {

        MongoClient mongo = new MongoClient("localhost", 27017);

        MongoDatabase nobetim = mongo.getDatabase("nobetim");
        MongoCollection doctors = nobetim.getCollection("doctors");

        List<Doctor> docs = new ArrayList<>();
        docs = (List<Doctor>) doctors.find().into(new ArrayList<Doctor>());

        return docs;
    }

    @Override
    public List<String> getDoctorNames() {

        MongoClient mongo = new MongoClient("localhost", 27017);

        MongoDatabase nobetim = mongo.getDatabase("nobetim");
        MongoCollection doctors = nobetim.getCollection("doctors");

        List<Doctor> docs = new ArrayList<>();
        docs = (List<Doctor>) doctors.find().into(new ArrayList<Doctor>());

        List<String> doctorNames = new ArrayList<>();

        for(int i=0; i<docs.size(); i++){
            doctorNames.add(docs.get(i).getFirstName() + " " + docs.get(i).getLastName());
        }

        return doctorNames;
    }

    @Override
    public Doctor getDoctorById(String id){

        List<Doctor> doctors = getDoctors();
        Doctor doctor = new Doctor();

        for(int i=0; i<doctors.size(); i++){
            if(doctors.get(i).getId().equals(id)){
                doctor = doctors.get(i);
            }
        }

        return doctor;
    }

    @Override
    public void setDoctor(Doctor doctor) {

        MongoClient mongo = new MongoClient("localhost", 27017);

        MongoDatabase nobetim = mongo.getDatabase("nobetim");
        MongoCollection doctors = nobetim.getCollection("doctors");

        Document doc = new Document();

        doc.put("_id", doctor.getId());
        doc.put("firstName", doctor.getFirstName());
        doc.put("lastName", doctor.getLastName());
        doc.put("level", doctor.getLevel());
        doc.put("hospital", doctor.getHospital());
        doc.put("department", doctor.getDepartment());
        doc.put("age", doctor.getAge());
        doc.put("eMail", doctor.geteMail());
        doc.put("GSMNumber", doctor.getGsmnumber());

        doctors.insertOne(doc);

    }

    @Override
    public void deleteDoctor(Doctor doctor) {

        MongoClient mongo = new MongoClient("localhost", 27017);

        MongoDatabase nobetim = mongo.getDatabase("nobetim");
        MongoCollection doctors = nobetim.getCollection("doctors");

        Document document = new Document();

        document.put("id", doctor.getId());

        doctors.findOneAndDelete(document);

    }

    @Override
    public void updateDoctor(Doctor doctor) {

        MongoClient mongo = new MongoClient("localhost", 27017);

        MongoDatabase nobetim = mongo.getDatabase("nobetim");
        MongoCollection doctors = nobetim.getCollection("doctors");

        Document doc1 = new Document();

        doc1.put("id", doctor.getId());

        Document doc2 = new Document();

        doc2.put("_id", doctor.getId());
        doc2.put("firstName", doctor.getFirstName());
        doc2.put("lastName", doctor.getLastName());
        doc2.put("level", doctor.getLevel());
        doc2.put("hospital", doctor.getHospital());
        doc2.put("department", doctor.getDepartment());
        doc2.put("age", doctor.getAge());
        doc2.put("eMail", doctor.geteMail());
        doc2.put("GSMNumber", doctor.getGsmnumber());

       doctors.findOneAndUpdate(doc1, doc2);

    }


}
