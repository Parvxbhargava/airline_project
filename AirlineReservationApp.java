import javafx.application.Application;
import javafx.stage.Stage;

public class AirlineReservationApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            MainController mainController = new MainController();
            primaryStage.setTitle("Airline Reservation System - Admin");
            primaryStage.setScene(mainController.createScene());
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
