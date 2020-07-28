/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportationmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class BusInfoController implements Initializable {

    @FXML
    private AnchorPane mainContent;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("busList.fxml"));
             mainContent.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(BusInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    @FXML
    private void busListButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("busList.fxml"));
        mainContent.getChildren().setAll(root);
    }

    @FXML
    private void busEntryButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("busEntry.fxml"));
        mainContent.getChildren().setAll(root);
    }


}
