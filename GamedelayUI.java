import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GamedelayUI extends Application {
    private int delayInSeconds;

    @Override
    public void start(Stage primaryStage) {
        // Label to show selected delay
        Label delayLabel = new Label("Select Delay Between Shots (0-5 seconds):");

        // Slider for delay selection
        Slider delaySlider = new Slider(0, 5, 0);
        delaySlider.setMajorTickUnit(1);
        delaySlider.setMinorTickCount(0);
        delaySlider.setSnapToTicks(true);
        delaySlider.setShowTickMarks(true);
        delaySlider.setShowTickLabels(true);

        // Update delay time based on slider value
        delaySlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            delayInSeconds = newVal.intValue();
        });

        // Button to simulate shot loop with delay
        Button startGameButton = new Button("Start Game with Delay");
        startGameButton.setOnAction(event -> startShootingWithDelay());

        VBox root = new VBox(10, delayLabel, delaySlider, startGameButton);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Game Delay Feature");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Simulate shooting loop with delay
    private void startShootingWithDelay() {
        new Thread(() -> {
            for (int shot = 1; shot <= 5; shot++) {
                System.out.println("Shot #" + shot);

                // Delay between shots
                try {
                    Thread.sleep(delayInSeconds * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("All shots fired with " + delayInSeconds + " second(s) delay.");
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

