import java.util.Objects;

public class Location {

    private int id;
    private String name;
    private City city;

    public Location(){}

    public Location(int id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Location id(int id) {
        this.id = id;
        return this;
    }

    public Location name(String name) {
        this.name = name;
        return this;
    }

    public Location city(City city) {
        this.city = city;
        return this;
    }

    Location build(){
        Location l = new Location();
        l.id = this.id;
        l.name = this.name;
        l.city = this.city;
        return l;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id == location.id &&
                Objects.equals(name, location.name) &&
                Objects.equals(city, location.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                '}';
    }
}
