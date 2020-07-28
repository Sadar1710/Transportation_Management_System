package transportationmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static transportationmanagementsystem.FXMLDocumentController.stage;

public class StudentsViewController implements Initializable {

    @FXML
    private AnchorPane maincontent;
    @FXML
    private AnchorPane mainContent;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("generalInfo.fxml"));
            maincontent.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(StudentsViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void busShedule(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("studentviewshedule.fxml"));
        maincontent.getChildren().setAll(root);
    }

    @FXML
    private void busInfo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("studentviewBus.fxml"));
        maincontent.getChildren().setAll(root);
    }

    @FXML
    private void driverInfo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("studentviewDriver.fxml"));
        maincontent.getChildren().setAll(root);
    }

    @FXML
    private void logout(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        mainContent.getChildren().setAll(root);
    }

    @FXML
    private void infoButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("generalInfo.fxml"));
        maincontent.getChildren().setAll(root);
    }

}
