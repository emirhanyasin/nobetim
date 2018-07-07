package nobetim.core;

import java.util.Arrays;

/**
 * @author emirhan yasin cetin
 */
public class Department {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
