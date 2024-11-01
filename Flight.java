public class Flight {
  private String flightNumber;
  private String origin;
  private String destination;
  private String departureTime;
  private String arrivalTime;

  public Flight(String flightNumber, String origin, String destination, String departureTime, String arrivalTime) {
      this.flightNumber = flightNumber;
      this.origin = origin;
      this.destination = destination;
      this.departureTime = departureTime;
      this.arrivalTime = arrivalTime;
  }

  // Getters and setters
  public String getFlightNumber() { return flightNumber; }
  public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

  public String getOrigin() { return origin; }
  public void setOrigin(String origin) { this.origin = origin; }

  public String getDestination() { return destination; }
  public void setDestination(String destination) { this.destination = destination; }

  public String getDepartureTime() { return departureTime; }
  public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }

  public String getArrivalTime() { return arrivalTime; }
  public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }

  @Override
  public String toString() {
      return flightNumber + ": " + origin + " to " + destination + " | Departure: " + departureTime + " | Arrival: " + arrivalTime;
  }
}
