package Gui.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ResourceBundle;

public class Classic implements Initializable {
    @FXML
    Canvas canvas=new Canvas();
    GraphicsContext gc= canvas.getGraphicsContext2D();
    Image image= new Image("Gui/Controller/546.Spash1-potassium-1024w-1366h@2xipad.jpg");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc.drawImage(image,0,0);
    }
}
