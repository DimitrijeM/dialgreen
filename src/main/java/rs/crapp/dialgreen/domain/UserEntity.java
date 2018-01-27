package rs.crapp.dialgreen.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="user")
public class UserEntity {

    @Id
    String id;

    String name;

    String points;

    public UserEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
