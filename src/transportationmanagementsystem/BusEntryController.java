
package transportationmanagementsystem;

import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class BusEntryController implements Initializable {

    @FXML
    private TextField model;
    @FXML
    private TextField busName;
    @FXML
    private TextField insuranceStatus;
    @FXML
    private TextField capacity;
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        databaseConnection db=new databaseConnection();
        try {
            db.loadbusInfo();
        } catch (SQLException ex) {
            Logger.getLogger(BusEntryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static ObservableList<businfo> BList = FXCollections.observableArrayList();

    void insertNewBus(String bname, String model, int capacity, String is) throws SQLException {
        databaseConnection db = new databaseConnection();
        Connection con = db.getConnection();
        Statement statement = con.createStatement();
        String query = "insert into businfo(Bus_Name,Model,Capacity,Insurance_Status) values('"+bname+"','"+model+"',"+capacity+",'"+is+"')";
        statement.executeUpdate(query);
    }

    @FXML
    private void addNewBUs(ActionEvent event) throws SQLException {

        if (busName.getText().equals("") && model.getText().equals("") && capacity.getText().equals("") && insuranceStatus.getText().equals("")) {
            return;
        }
        String Bname = busName.getText();
        String Bmodel = model.getText();
        int Bcapacity = Integer.parseInt(capacity.getText());
        String Bis = insuranceStatus.getText();
        insertNewBus(Bname, Bmodel, Bcapacity, Bis);
        busName.clear();
        model.clear();
        capacity.clear();
        insuranceStatus.clear();

    }

    @FXML
    private void resetButtonAction(ActionEvent event) {

        busName.clear();
        model.clear();
        capacity.clear();
        insuranceStatus.clear();
    }
}
