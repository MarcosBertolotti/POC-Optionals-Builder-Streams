import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args){

        List<Event> events = Arrays.asList(
                new Event(3,"eventD",new Location(1,"loc1",new City(1,"Mar del Plata"))),
                new Event(6,"eventF",new Location(2,"loc2",new City(1,"Bahia Blanca"))),
                new Event(1,"eventB",new Location(3,"loc3",new City(3,"Necochea"))),
                new Event(5,"eventC",new Location(4,"loc4",new City(4,"Tandil"))),
                new Event(2,"eventA",new Location(5,"loc5",new City(5,"La Plata"))),
                new Event(4,"eventE",new Location(6,"loc6",new City(6,"Olavarria")))
        );

        System.out.println("Evento por Id: \n" + getEventById(events,4));

        System.out.println("\nCiudad del Evento: \n" + getCityNameFromEvent(events,3));

        System.out.println(String.format("\n Eventos ordenados por Nombre: \n %s", getEventsOrderByName(events)));

        System.out.println(String.format("\n Primeros 5 Eventos Ordenado Por Id: \n %s", getFirstEventsOrderById(events)));

    }

    public static Event getEventById(List<Event> events, Integer id){
        return events.stream()
                .filter(event -> id.equals(event.getId()))
                .findFirst()
                .get();
    }

    public static String getCityNameFromEvent(List<Event> events, Integer id) {
        return Optional.ofNullable(getEventById(events,id))
                .map(Event::getLocation)
                .map(Location::getCity)
                .map(City::getName)
                .orElse("Sin Ciudad");
    }

    public static List<Event> getEventsOrderByName(List<Event> events){
        return events.stream()
                .sorted(Comparator.comparing(event -> event.getName()))
                .collect(Collectors.toList());
    }

    public static List<Event> getFirstEventsOrderById(List<Event> events){
        return events.stream()
                .sorted(Comparator.comparing(event -> event.getId()))
                .limit(5)
                .collect(Collectors.toList());
    }

}

