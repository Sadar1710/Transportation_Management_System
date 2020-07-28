package transportationmanagementsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class DriverEntryController implements Initializable {

    @FXML
    private TextField drivername;
    @FXML
    private TextField phone;
    @FXML
    private TextField maritalstatus;
    @FXML
    private TextField licence;

    static ObservableList<driver> DList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    void insertNewDriver(String Dname,int Dphone,String Dms,String Dlicence) throws SQLException {
        databaseConnection d = new databaseConnection();
        Connection con = d.getConnection();
        Statement statement = con.createStatement();
        String query = "insert into driverinfo(Driver_Name,Phone,Marital_Status,Licence) values('"+Dname+"',"+Dphone+",'"+Dms+"','"+Dlicence+"')";
        statement.executeUpdate(query);      
    }

    @FXML
    private void saveButtonAction(ActionEvent event) throws SQLException {

        if (drivername.getText().equals("") && phone.getText().equals("") && maritalstatus.getText().equals("") && licence.getText().equals("")) {
            return;
        }
        
       
        String dname = drivername.getText();
        int dphone = Integer.parseInt(phone.getText());
        String dms = maritalstatus.getText();
        String dlicence = licence.getText();
 
        insertNewDriver(dname,dphone,dms,dlicence);
        drivername.clear();
        phone.clear();
        maritalstatus.clear();
        licence.clear();
    }

    @FXML
    private void resetButtonAction(ActionEvent event) {

        drivername.clear();
        phone.clear();
        maritalstatus.clear();
        licence.clear();
    }

}
