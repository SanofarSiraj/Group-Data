import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private final Stage primaryStage;
    private List<String> x = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
    private List<String> y = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
    private List<String> xy = new ArrayList<>();

    //Constructor
    public Board(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    //Presents the game
    public void presentation() {
        Scene scene = new Scene(battleField());
        primaryStage.setScene(scene);
    }

    //Creating two battlefields
    private AnchorPane battleField() {

        //Creating left battlefield (my map) with only one layer of rectangles to make ships visible
        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setPrefSize(1400, 900);
        anchorPane1.setLayoutX(0);
        anchorPane1.setLayoutY(0);
        anchorPane1.getChildren().add(addLabel("My map"));
        anchorPane1.getChildren().addAll(axisValue());
        List<Rectangle> rectanglesMyMap = addLowerRectangles();
        anchorPane1.getChildren().addAll(rectanglesMyMap);

        //Creating right battlefield (enemy map) with two layers of rectangles to be able to hide ships
        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setPrefSize(300, 900);
        anchorPane2.setLayoutX(700);
        anchorPane2.setLayoutY(0);
        anchorPane2.getChildren().add(addLabel("Enemy map"));
        anchorPane2.getChildren().addAll(axisValue());
        List<Rectangle> lowerRectanglesEnemyMap = addLowerRectangles();
        List<Rectangle> upperRectanglesEnemyMap = addUpperRectangles();
        anchorPane2.getChildren().addAll(lowerRectanglesEnemyMap);
        anchorPane2.getChildren().addAll(upperRectanglesEnemyMap);

        //Adds anchorPane 2 with enemy map into anchorPane 1
        anchorPane1.getChildren().add(anchorPane2);
        return anchorPane1;
    }

    //Sets the title above each of the two battlefields
    private Label addLabel(String labelText) {
        Label label = new Label(labelText);
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(60, 10, 10, 285));
        label.setFont(new Font("Arial", 26));
        return label;
    }

    //Gets a list with nodes of text that represent the x- and y-axis on the battlefields
    private List<Text> axisValue() {
        List<Text> axis = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Text xAxis = new Text(((i * 51) + 120), 640, x.get(i));
            xAxis.setFont(new Font("Arial", 20));
            axis.add(xAxis);
            for (int j = 0; j < 10; j++) {
                Text yAxis = new Text(75, (((j * 51) + 130)), y.get(j));
                yAxis.setFont(new Font("Arial", 20));
                axis.add(yAxis);
            }
        }
        return axis;
    }

    //Adds rectangles to the battlefields on to which ships are being placed
    private List<Rectangle> addLowerRectangles() {
        List<Rectangle> lowerRectangles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Rectangle lowerRectangle = new Rectangle(50, 50, Paint.valueOf("Blue"));
                lowerRectangle.setWidth(50);
                lowerRectangle.setHeight(50);
                lowerRectangle.setLayoutX((j * 51) + 100);
                lowerRectangle.setLayoutY((i * 51) + 100);
                lowerRectangles.add(lowerRectangle);
            }
        }
        return lowerRectangles;
    }

    //Adds a second layer of rectangles to the enemy battlefield for hiding the enemy ships
    private List<Rectangle> addUpperRectangles() {
        List<Rectangle> upperRectangles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Rectangle upperRectangle = new Rectangle(50, 50, Paint.valueOf("Turquoise"));
                upperRectangle.setWidth(50);
                upperRectangle.setHeight(50);
                upperRectangle.setLayoutX((j * 51) + 100);
                upperRectangle.setLayoutY((i * 51) + 100);
                upperRectangles.add(upperRectangle);
            }
        }
        return upperRectangles;
    }
}

