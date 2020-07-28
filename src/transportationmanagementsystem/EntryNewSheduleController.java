
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


public class EntryNewSheduleController implements Initializable {

    @FXML
    private TextField bid;
    @FXML
    private TextField origin;
    @FXML
    private TextField destination;
    @FXML
    private TextField time;
    @FXML
    private Label label;

    static ObservableList<busShedule> shedule = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        databaseConnection db=new databaseConnection();
        try {
            shedule=(ObservableList<busShedule>) db.loadbusShedule();
            BusEntryController.BList=db.loadbusInfo();
        } catch (SQLException ex) {
            Logger.getLogger(EntryNewSheduleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    String insertNewBusShedule(busShedule sheduleInfo) throws SQLException {
        databaseConnection db = new databaseConnection();
        Connection con = db.getConnection();
        Statement statement = con.createStatement();
        String query = "insert into busShedule " + "values("+sheduleInfo.getBid()+",'"+sheduleInfo.getOrigin()+"','"+sheduleInfo.getDestination()+"','"+sheduleInfo.getTime()+"')";
        statement.executeUpdate(query);
        if (statement.executeUpdate(query) > 0) {
            return "Bus added successfully";
        } else {
            return "Failed";
        }
    }

    @FXML
    private void saveButtonAction(ActionEvent event) throws SQLException {
        
        if (bid.getText().equals(" ")) {
            return;
        }
        int Bid = Integer.parseInt(bid.getText());
        String Origin = origin.getText();
        String Destination = destination.getText();
        String Time = time.getText();
        if (Origin.equals(" ") && Destination.equals(" ") && Time.equals(" ")) {
            return;
        }
        busShedule b=new busShedule(Bid,Origin,Destination,Time);
        bid.clear();
        origin.clear();
        destination.clear();
        time.clear();
        insertNewBusShedule(b);
    }

    @FXML
    private void resetButtonAction(ActionEvent event) {
        bid.clear();
        origin.clear();
        destination.clear();
        time.clear();
    }

    @FXML
    private void checkBusId(KeyEvent event) {
//        String s=bid.getText();
//        label.setText("");
//        if(s.equals(""))
//        {
//            return;
//        }
//        
////        for(busShedule bs:shedule)
////        {
////            if(bs.getBid()==Integer.parseInt(s))
////            {
////                label.setText("Already exist!");
////                break;
////            }
////        }    
//        for(businfo b:BusEntryController.BList)
//        {
//            if(b.getId()!=Integer.parseInt(s))
//            {
//                label.setText("Doesn't exist!");
//                break;
//            }
//        }
    }
}