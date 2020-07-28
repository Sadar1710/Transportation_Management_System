/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportationmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static transportationmanagementsystem.FXMLDocumentController.stage;


public class HomeViewController implements Initializable {

    @FXML
    private AnchorPane mainContend;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void busesButtonAction(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("busInfo.fxml"));
        mainContend.getChildren().setAll(root);
    }

    @FXML
    private void busSheduleButtonAction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("busSheduleInfo.fxml"));
        mainContend.getChildren().setAll(root);
    }

    @FXML
    private void driversButtonAction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("driverInfo.fxml"));
        mainContend.getChildren().setAll(root);
    }

    @FXML
    private void logout(MouseEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setMaxHeight(680);
        stage.setMaxWidth(900);
        stage.setMinHeight(680);
        stage.setMinWidth(900);
        FXMLDocumentController.stage.close();
         stage.show();
    }

    @FXML
    private void aboutButton(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));
        mainContend.getChildren().setAll(root);
    }

    
    
}
