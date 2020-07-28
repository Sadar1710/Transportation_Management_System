
package transportationmanagementsystem;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentviewDriverController implements Initializable {

    @FXML
    private TableView<driver> driverTable;
    @FXML
    private TableColumn<driver, Integer> idColumn;
    @FXML
    private TableColumn<driver, String> drivernameColumn;
    @FXML
    private TableColumn<driver, Integer> phoneColumn;
    @FXML
    private TableColumn<driver, String> maritalstatusColumn;
    @FXML
    private TableColumn<driver, String> licenceColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        driverTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        idColumn.setCellValueFactory(new PropertyValueFactory<driver, Integer>("id"));
        drivernameColumn.setCellValueFactory(new PropertyValueFactory<driver, String>("drivername"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<driver, Integer>("phone"));
        maritalstatusColumn.setCellValueFactory(new PropertyValueFactory<driver, String>("maritalstatus"));
        licenceColumn.setCellValueFactory(new PropertyValueFactory<driver, String>("licence"));

        databaseConnection db = new databaseConnection();
        try {
            //DriverEntryController.DList = db.loaddriverInfo();
            driverTable.setItems(db.loaddriverInfo());
        } catch (SQLException ex) {
            Logger.getLogger(DriverListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
