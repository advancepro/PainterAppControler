package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PainterAppController {

    private enum PenSize {
        SMALL(2),
        MEDIUM(4),
        LARGE(6);
        private final int radius;

        PenSize(int radius) {
            this.radius = radius;
        }

        public int getRadius() {
            return radius;
        }
    }

    @FXML private RadioButton blackBut;
    @FXML private RadioButton redBut;
    @FXML private RadioButton greenBut;
    @FXML private RadioButton blueBut;
    @FXML private RadioButton smallBut;
    @FXML private RadioButton medBut;
    @FXML private RadioButton largeBut;
    @FXML private Pane drawingAreaPane;
    @FXML private ToggleGroup colorGroupButtons;
    @FXML private ToggleGroup sizeGroupButtons;

    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;

    @FXML
    public void initialize() {
        blackBut.setUserData(Color.BLACK);
        redBut.setUserData(Color.RED);
        greenBut.setUserData(Color.GREEN);
        blueBut.setUserData(Color.BLUE);
        smallBut.setUserData(PenSize.SMALL);
        medBut.setUserData(PenSize.MEDIUM);
        largeBut.setUserData(PenSize.LARGE);
    }

    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), radius.getRadius(), brushColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    private void colorRadioButtonSelected(ActionEvent event) {
        brushColor =
                (Color) colorGroupButtons.getSelectedToggle().getUserData();

    }

    @FXML
    private void sizeRadioButtonSelected(ActionEvent event) {
        radius =
                (PenSize) sizeGroupButtons.getSelectedToggle().getUserData();
    }

    @FXML
    private void clearButtonPressed (ActionEvent event){
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    private void undoButtonPressed(ActionEvent event) {
        int count = drawingAreaPane.getChildren().size();
        if (count > 0) {
            drawingAreaPane.getChildren().remove(count - 1);
        }
    }
}


