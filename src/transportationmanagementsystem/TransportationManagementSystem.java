
package transportationmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TransportationManagementSystem extends Application {
    
    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setMaxHeight(680);
        stage.setMaxWidth(900);
        stage.setMinHeight(680);
        stage.setMinWidth(900);
        stage.setTitle("Transportation Management System");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
