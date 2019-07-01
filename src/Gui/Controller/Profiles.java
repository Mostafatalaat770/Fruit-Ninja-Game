package Gui.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.jdom2.JDOMException;

import javax.sound.sampled.Clip;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Profiles implements Initializable {
    public Text text1;
    public Text text2;
    public Text comboBoxText;
    @FXML
    private ComboBox<String> usernameCombobox;
@FXML private JFXTextField usernameTextField;
@FXML private JFXButton logIn;
@FXML private JFXButton signUp;
    final Controller controller = Controller.getInstance();
    private final ArrayList<String> names = new ArrayList<>();
    private ObservableList<String> usernames = FXCollections.observableArrayList();


    public void initialize(URL location, ResourceBundle resources) {

        logIn.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 18));
        signUp.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 18));
        usernameTextField.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 18));
        comboBoxText.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 18));
        text1.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 34));
        text2.setFont(Font.loadFont(this.getClass().getResourceAsStream("/fonts/GangOfThree.ttf"), 34));
        try {
            controller.loadPlayers();
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
        controller.playSound("main theme", Clip.LOOP_CONTINUOUSLY);
        for (int i=0;i<controller.usersDB.getPlayers().size();i++){
            names.add(controller.usersDB.getPlayers().get(i).getUsername());
        }
        usernames.addAll(names);
        usernameCombobox.setItems(usernames);

        logIn.setOnMouseClicked(event -> {
            if (usernameCombobox.getValue() != null) {
                try {
                    controller.setUser(usernameCombobox.getValue());//brings the chosen name
                } catch (JDOMException | IOException e) {
                    e.printStackTrace();
                }
                // goes to main screen
                controller.playSound("press", 0);
                try {
                    controller.sceneChanger.getMainMenu(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                //TODO show error message
            }
        });
        
        signUp.setOnMouseClicked(event -> {
            if (controller.usersDB.verify(usernameTextField.getText())) {
                controller.usersDB.addUser(usernameTextField.getText(), 0, 0);
                controller.usersDB.setPlayer(usernameTextField.getText());
                controller.settings.getSounds().setMusic(true);
                controller.settings.getSounds().setFx(true);
                controller.settings.changeBackground(1);
                try {
                    controller.saveSettings();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // goes to main menu
                controller.playSound("press", 0);
                try {
                    controller.savePlayers();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    controller.sceneChanger.getMainMenu(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                //TODO show error message user already exists!
            }
        });
    }
}
