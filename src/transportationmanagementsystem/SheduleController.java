/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SheduleController implements Initializable {

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
            EntryNewSheduleController.shedule=db.loadbusShedule();
            sheduleTable.setItems(EntryNewSheduleController.shedule);
        } catch (SQLException ex) {
            Logger.getLogger(BusListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void deleteshedule(ObservableList<busShedule> selectedItems) throws SQLException
    {
        databaseConnection db= new databaseConnection();
        db.getConnection();
        Statement statement=(Statement) db.getConnection().createStatement();
        for(busShedule b:selectedItems)
        {
            String query="delete from busshedule where Bid ="+b.getBid();
            statement.executeUpdate(query);
        }
    }
    @FXML
    private void deleteButtonAction(ActionEvent event) throws SQLException {
         ObservableList<busShedule> selectedItems=FXCollections.observableArrayList();

           selectedItems=sheduleTable.getSelectionModel().getSelectedItems();
           deleteshedule(selectedItems);
           EntryNewSheduleController.shedule.removeAll(selectedItems);
    }

}
