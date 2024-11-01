import java.util.ArrayList;
import java.util.List;

public class FlightController {
    private List<Flight> flights;

    public FlightController() {
        flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void deleteFlight(String flightNumber) throws FlightNotFoundException {
        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            flights.remove(flight);
        } else {
            throw new FlightNotFoundException("Flight not found!");
        }
    }

    public void editFlight(String flightNumber, Flight updatedFlight) throws FlightNotFoundException {
        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            flight.setDepartureTime(updatedFlight.getDepartureTime());
            flight.setArrivalTime(updatedFlight.getArrivalTime());
            flight.setOrigin(updatedFlight.getOrigin());
            flight.setDestination(updatedFlight.getDestination());
        } else {
            throw new FlightNotFoundException("Flight not found!");
        }
    }

    public List<Flight> viewFlights() {
        return flights;
    }

    private Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }
}
