package nobetim.Response;

import nobetim.core.Department;

import java.util.List;

/**
 * @author emirhan yasin cetin
 */
public class GetDepartmentsResponse {

    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "GetDepartmentsResponse{" +
                "departments=" + departments +
                '}';
    }
}
