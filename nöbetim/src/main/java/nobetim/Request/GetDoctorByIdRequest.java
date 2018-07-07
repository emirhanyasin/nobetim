package nobetim.Request;

/**
 * @author emirhan yasin cetin
 */
public class GetDoctorByIdRequest {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GetDoctorByIdRequest{" +
                "id='" + id + '\'' +
                '}';
    }
}
