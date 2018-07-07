package nobetim.DAO;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import nobetim.core.Department;
import nobetim.core.Doctor;
import nobetim.core.Hospital;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author emirhan yasin cetin
 */
@Service
public class HospitalsMongoDAOImpl implements HospitalsMongoDAO {

    @Override
    public List<Hospital> getHospitals() {

        MongoClient mongo = new MongoClient("localhost", 27017);

        MongoDatabase allHospitals = mongo.getDatabase("hospitals");
        MongoCollection hospitals = allHospitals.getCollection("hospitals");

        List<Hospital> getHospitals = new ArrayList<>();
        getHospitals = (List<Hospital>) hospitals.find().into(new ArrayList<Hospital>());

        return getHospitals;
    }

    @Override
    public List<String> getHospitalNames() {

        MongoClient mongo = new MongoClient("localhost", 27017);

        MongoDatabase allHospitals = mongo.getDatabase("hospitals");
        MongoCollection hospitals = allHospitals.getCollection("hospitals");

        List<Hospital> getHospitals = (List<Hospital>) hospitals.find().into(new ArrayList<Hospital>());

        List<String> hospitalNames = new ArrayList<>();

        for(int i=0; i<getHospitals.size(); i++){
            hospitalNames.add(getHospitals.get(i).getName());
        }

        return hospitalNames;
    }

    @Override
    public Hospital getHospitalByName(String hospitalName){

        List<Hospital> hospitals = getHospitals();
        Hospital hospital = new Hospital();

        for(int i=0; i<hospitals.size(); i++){
            if(hospitals.get(i).getName().equals(hospitalName)){
                hospital = hospitals.get(i);
            }
        }

        return hospital;
    }

    @Override
    public void setHospital(Hospital hospital) {

        MongoClient mongo = new MongoClient("localhost", 27017);

        MongoDatabase allHospitals = mongo.getDatabase("hospitals");
        MongoCollection hospitals = allHospitals.getCollection("hospitals");

        Document doc = new Document();

        doc.put("id", hospital.getName());
        doc.put("departments", hospital.getDepartments());

        Document doc2 = new Document();
        doc2.put("id", hospital.getName());

        for(int i=0; i<hospitals.count(); i++){
            if(!hospitals.find(doc2).equals(null)){
                hospitals.findOneAndUpdate(doc2, doc);
            }
        }

        hospitals.insertOne(doc);

    }

    @Override
    public void updateHospital(Hospital hospital){

        MongoClient mongo = new MongoClient("localhost", 27017);

        MongoDatabase allHospitals = mongo.getDatabase("hospitals");
        MongoCollection hospitals = allHospitals.getCollection("hospitals");

        Document hospital1 = new Document();
        hospital1.put("id", hospital.getName());

        Document hospital2 = new Document();
        hospital2.put("id", hospital.getName());
        hospital2.put("departments", hospital.getDepartments());

        hospitals.findOneAndUpdate(hospital1, hospital2);
    }

    @Override
    public List<Department> getDepartments(String hospitalName) {

        MongoClient mongo = new MongoClient("localhost", 27017);

        MongoDatabase allHospitals = mongo.getDatabase("hospitals");
        MongoCollection hospitals = allHospitals.getCollection("hospitals");

        Hospital hospital = getHospitalByName(hospitalName);

        return hospital.getDepartments();
    }


}
