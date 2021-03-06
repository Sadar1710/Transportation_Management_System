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

public class StudentviewBusController implements Initializable {

    @FXML
    private TableView<businfo> busListTable;
    @FXML
    private TableColumn<businfo, Integer> idCloumn;
    @FXML
    private TableColumn<businfo, String> busNameCloumn;
    @FXML
    private TableColumn<businfo, String> modelColumn;
    @FXML
    private TableColumn<businfo, Integer> capacityColumn;
    @FXML
    private TableColumn<businfo, String> insuranceStatusColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

       // busListTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        idCloumn.setCellValueFactory(new PropertyValueFactory<businfo, Integer>("id"));
        busNameCloumn.setCellValueFactory(new PropertyValueFactory<businfo, String>("busname"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<businfo, String>("model"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<businfo, Integer>("capacity"));
        insuranceStatusColumn.setCellValueFactory(new PropertyValueFactory<businfo, String>("insuranceStatus"));

        databaseConnection db = new databaseConnection();
        try {
            busListTable.setItems(db.loadbusInfo());
        } catch (SQLException ex) {
            Logger.getLogger(BusListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
