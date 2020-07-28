package transportationmanagementsystem;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class DriverListController implements Initializable {

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
            DriverEntryController.DList=db.loaddriverInfo();
            driverTable.setItems(DriverEntryController.DList);
        } catch (SQLException ex) {
            Logger.getLogger(DriverListController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void deletedriver(ObservableList<driver> selecteddrivers) throws SQLException {
        databaseConnection db = new databaseConnection();
        db.getConnection();
        Statement statement = (Statement) db.getConnection().createStatement();
        for (driver d : selecteddrivers) {
            String query = "delete from driverinfo where Id=" + d.getId();
            statement.executeUpdate(query);
        }
    }

    @FXML
    private void driverDeleteButtonAction(ActionEvent event) throws SQLException {
        ObservableList<driver> selecteddrivers = FXCollections.observableArrayList();
        selecteddrivers = driverTable.getSelectionModel().getSelectedItems();
        deletedriver(selecteddrivers);
        DriverEntryController.DList.removeAll(selecteddrivers);
    }
}
