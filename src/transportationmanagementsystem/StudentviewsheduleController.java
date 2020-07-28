
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

public class StudentviewsheduleController implements Initializable {

    @FXML
    private TableColumn<busShedule, Integer> bidColumn;
    @FXML
    private TableColumn<busShedule, String> originColumn;
    @FXML
    private TableColumn<busShedule, String> destinationColumn;
    @FXML
    private TableColumn<busShedule, String> timeColumn;
    @FXML
    private TableView<busShedule> sheduleTable;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sheduleTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        bidColumn.setCellValueFactory(new PropertyValueFactory<busShedule, Integer>("bid"));
        originColumn.setCellValueFactory(new PropertyValueFactory<busShedule, String>("origin"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<busShedule, String>("destination"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<busShedule, String>("time"));

        databaseConnection db = new databaseConnection();
        try {
            EntryNewSheduleController.shedule = db.loadbusShedule();
            sheduleTable.setItems(EntryNewSheduleController.shedule);
        } catch (SQLException ex) {
            Logger.getLogger(BusListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
