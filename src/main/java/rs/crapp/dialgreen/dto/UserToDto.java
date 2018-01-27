package rs.crapp.dialgreen.dto;

public class UserToDto {

    Long id;

    String name;

    Double point;

    public UserToDto() {
    }

    public UserToDto(Long id, String name, Double point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }
}
