import java.util.Objects;

public class City {

    private int id;
    private String name;

    public City(){}

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City id(int id) {
        this.id = id;
        return this;
    }

    public City name(String name) {
        this.name = name;
        return this;
    }

    City build(){
        City c = new City();
        c.id =  this.id;
        c.name = this.name;
        return c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id &&
                Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /*
    @builder
    City{
        id;
        name;
    }
*/

}
