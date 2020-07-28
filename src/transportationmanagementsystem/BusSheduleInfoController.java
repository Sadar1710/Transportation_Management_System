
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
import javafx.scene.layout.AnchorPane;

public class BusSheduleInfoController implements Initializable {

    @FXML
    private AnchorPane mainContent;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("shedule.fxml"));
            mainContent.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(BusSheduleInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void showBusShedule(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("shedule.fxml"));
        mainContent.getChildren().setAll(root);
    }

    @FXML
    private void AddNewBusShedule(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("entryNewShedule.fxml"));
        mainContent.getChildren().setAll(root);
    }
}
