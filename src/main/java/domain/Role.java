package domain;

import java.io.Serializable;

public class Role implements Serializable {

    private static final long serialVersionUID = -6176487673690070965L;
    private int id;
    private String name;

    public Role() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role { " +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';
    }
}
