import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class MainController {
    private FlightController flightController = new FlightController();
    private TextArea flightDisplay;
    private TextField flightNumberField;
    private TextField originField;
    private TextField destinationField;
    private TextField departureTimeField;
    private TextField arrivalTimeField;

    public Scene createScene() {
        BorderPane mainLayout = new BorderPane();
        flightDisplay = new TextArea();
        flightDisplay.setEditable(false);

        // Create input fields
        flightNumberField = new TextField();
        originField = new TextField();
        destinationField = new TextField();
        departureTimeField = new TextField();
        arrivalTimeField = new TextField();

        // Create buttons
        Button addButton = new Button("Add Flight");
        Button viewButton = new Button("View Flights");
        Button deleteButton = new Button("Delete Flight");
        Button editButton = new Button("Edit Flight");

        // Set button actions
        addButton.setOnAction(e -> handleAddFlight());
        viewButton.setOnAction(e -> handleViewFlights());
        deleteButton.setOnAction(e -> handleDeleteFlight());
        editButton.setOnAction(e -> handleEditFlight());

        // Layout for input fields
        GridPane inputLayout = new GridPane();
        inputLayout.setVgap(10);
        inputLayout.setHgap(10);
        inputLayout.add(new Label("Flight Number:"), 0, 0);
        inputLayout.add(flightNumberField, 1, 0);
        inputLayout.add(new Label("Origin:"), 0, 1);
        inputLayout.add(originField, 1, 1);
        inputLayout.add(new Label("Destination:"), 0, 2);
        inputLayout.add(destinationField, 1, 2);
        inputLayout.add(new Label("Departure Time:"), 0, 3);
        inputLayout.add(departureTimeField, 1, 3);
        inputLayout.add(new Label("Arrival Time:"), 0, 4);
        inputLayout.add(arrivalTimeField, 1, 4);

        VBox buttonLayout = new VBox(10, addButton, viewButton, deleteButton, editButton);
        mainLayout.setLeft(buttonLayout);
        mainLayout.setCenter(flightDisplay);
        mainLayout.setRight(inputLayout);

        return new Scene(mainLayout, 600, 300);
    }

    private void handleAddFlight() {
        String flightNumber = flightNumberField.getText();
        String origin = originField.getText();
        String destination = destinationField.getText();
        String departureTime = departureTimeField.getText();
        String arrivalTime = arrivalTimeField.getText();

        Flight newFlight = new Flight(flightNumber, origin, destination, departureTime, arrivalTime);
        flightController.addFlight(newFlight);
        showAlert("Success", "Flight added successfully");

        // Clear input fields
        clearInputFields();
    }

    private void handleViewFlights() {
        StringBuilder flightsInfo = new StringBuilder("Flight Schedule:\n");
        for (Flight flight : flightController.viewFlights()) {
            flightsInfo.append(flight.toString()).append("\n");
        }
        flightDisplay.setText(flightsInfo.toString());
    }

    private void handleDeleteFlight() {
        String flightNumber = flightNumberField.getText();
        try {
            flightController.deleteFlight(flightNumber);
            showAlert("Success", "Flight deleted successfully");
            clearInputFields();
        } catch (FlightNotFoundException e) {
            showAlert("Error", e.getMessage());
        }
    }

    private void handleEditFlight() {
        String flightNumber = flightNumberField.getText();
        String origin = originField.getText();
        String destination = destinationField.getText();
        String departureTime = departureTimeField.getText();
        String arrivalTime = arrivalTimeField.getText();

        try {
            Flight updatedFlight = new Flight(flightNumber, origin, destination, departureTime, arrivalTime);
            flightController.editFlight(flightNumber, updatedFlight);
            showAlert("Success", "Flight updated successfully");
            clearInputFields();
        } catch (FlightNotFoundException e) {
            showAlert("Error", e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearInputFields() {
        flightNumberField.clear();
        originField.clear();
        destinationField.clear();
        departureTimeField.clear();
        arrivalTimeField.clear();
    }
}
