package nobetim.DAO.codec;

import nobetim.core.Department;
import nobetim.core.Hospital;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import java.util.ArrayList;
import java.util.List;


/**
 * @author emirhan yasin cetin
 */
public class HospitalCodec implements Codec<Hospital> {

    @Override
    public Hospital decode(BsonReader reader, DecoderContext decoderContext) {

        Hospital hospital = new Hospital();

        reader.readStartDocument();

        while(reader.readBsonType() != BsonType.END_OF_DOCUMENT){
            String fieldName = reader.readName();
            if("id".equals(fieldName)){
                hospital.setName(reader.readName());
            }
        }

        return null;
    }

    @Override
    public void encode(BsonWriter writer, Hospital hospital, EncoderContext encoderContext) {

        writer.writeStartDocument();

        writer.writeString("id", hospital.getName());
        for(int i=0; i<hospital.getDepartments().size(); i++){
            int num = 1;
            writer.writeString(num + "Department_Name", hospital.getDepartments().get(i).getName());
        }

        writer.writeEndDocument();

    }

    @Override
    public Class<Hospital> getEncoderClass() {
        return Hospital.class;
    }
}
