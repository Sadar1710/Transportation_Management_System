package transportationmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class databaseConnection {

    Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transportation", "root", "");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    ObservableList<businfo> loadbusInfo() throws SQLException {
        ObservableList<businfo> busInfo = FXCollections.observableArrayList();
        Connection con = getConnection();
        String query = "select * from businfo";
        ResultSet rs = con.createStatement().executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("Id");
            String busname = rs.getString("Bus_Name");
            String model = rs.getString("Model");
            int capacity = rs.getInt("Capacity");
            String is = rs.getString("Insurance_Status");
            businfo b = new businfo(id, busname, model, capacity, is);
            busInfo.addAll(b);
        }
        return busInfo;
    }

    ObservableList<driver> loaddriverInfo() throws SQLException {
        ObservableList<driver> driverList = FXCollections.observableArrayList();
        Connection con = getConnection();
        String query = "select * from driverinfo";
        ResultSet rs = con.createStatement().executeQuery(query);
        while (rs.next()) {
            int did=rs.getInt("Id");
            String dname=rs.getString("Driver_Name");
            int phn=rs.getInt("Phone");
            String ms=rs.getString("Marital_Status");
            String licence=rs.getString("Licence");
            driver d=new driver(did,dname,phn,ms,licence);
            driverList.addAll(d);
        }
        return driverList;
    }
    
    ObservableList<busShedule> loadbusShedule() throws SQLException {
        ObservableList<busShedule> sheduleList = FXCollections.observableArrayList();
        Connection con = getConnection();
        String query = "select * from busShedule";
        ResultSet rs = con.createStatement().executeQuery(query);
        while (rs.next()) {
            int a=rs.getInt("Bid");
            String b=rs.getString("Origin");
            String c=rs.getString("Destination");
            String d=rs.getString("Time");
            busShedule bs=new busShedule(a,b,c,d);
            sheduleList.addAll(bs);
        }
        return sheduleList;
    }
}
