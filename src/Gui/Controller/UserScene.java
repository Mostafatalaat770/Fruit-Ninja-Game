package Gui.Controller;

import Gui.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserScene implements Initializable {
@FXML private ComboBox<String> usernameCombobox;
@FXML private JFXTextField usernameTextField;
@FXML private JFXButton logIn;
@FXML private JFXButton signUp;
private Controller controller=Controller.getInstance();
ArrayList<String> names= new ArrayList<>();
ObservableList<String> usernames= FXCollections.observableArrayList();


    public void initialize(URL location, ResourceBundle resources) {
        // TODO: 21-May-19 loadind the db goes here 
        for (int i=0;i<controller.usersDB.getPlayers().size();i++){
            names.add(controller.usersDB.getPlayers().get(i).getUsername());
        }
        usernames.addAll(names);
        usernameCombobox.setItems(usernames);

        logIn.setOnMouseClicked(event -> {
            usernameCombobox.getValue();//brings the chosen name
            // TODO: 21-May-19  do your seaarch to get a name
            //goes to main screeen
            controller.playSound("Next-screen-button.wav", 0);
            Main main = new Main();
            try {
                main.getMainMenu(event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        
        signUp.setOnMouseClicked(event -> {
            usernameTextField.getText();//gets the text in this feild
            // TODO: 21-May-19 do our thingie  
            // goes to main menu
            controller.playSound("Next-screen-button.wav", 0);
            Main main = new Main();
            try {
                main.getMainMenu(event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }


}
