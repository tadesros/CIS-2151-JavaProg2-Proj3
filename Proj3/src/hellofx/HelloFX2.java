
package hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author tomad
 */
public class HelloFX2 extends Application {
    


    @Override
    public void start(Stage stage) throws Exception {
        //Because we are using fxml
        Parent root = FXMLLoader.load(getClass().getResource("HelloFXML.fxml"));
        Scene scene = new Scene(root);
       
        stage.setTitle("Movie Application");
        stage.setScene(scene);
        stage.show();
    }
        
    public static void main(String[] args)
    {
        launch(args);
    }
     
}
