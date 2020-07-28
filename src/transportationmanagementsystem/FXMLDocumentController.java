package transportationmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

   
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    private BorderPane mainContent;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public static Stage stage = new Stage();

    @FXML
    private void loginButtonAction(ActionEvent event) throws SQLException, IOException {

        databaseConnection con = new databaseConnection();
        Statement statement1 = con.getConnection().createStatement();
        Statement statement2 = con.getConnection().createStatement();
        String query1 = "select * from admin where Username='" + username.getText() + "' and Password = '" + password.getText() + "' and Role=1";
        String query2 = "select * from admin where Username='" + username.getText() + "' and Password = '" + password.getText() + "' and Role=2";
        ResultSet rs1 = statement1.executeQuery(query1);
        ResultSet rs2 = statement2.executeQuery(query2);

        if (rs1.next()) {
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setMaxHeight(680);
            stage.setMaxWidth(900);
            stage.setMinHeight(680);
            stage.setMinWidth(900);
            stage.setTitle("Transportation Management System");
            TransportationManagementSystem.stage.close();
            stage.show();
        }
        
        else if(rs2.next())
        {
            Parent root = FXMLLoader.load(getClass().getResource("studentsView.fxml"));
            mainContent.getChildren().setAll(root);
        }
        
        else {
          Alert a=new Alert(Alert.AlertType.ERROR);
          a.setContentText("Username/Password is wrong");
          a.show();
        }
        
        username.clear();
        password.clear();
    }

    @FXML
    private void resetButtonAction(ActionEvent event) {
        username.clear();
        password.clear();
    }
    
}
