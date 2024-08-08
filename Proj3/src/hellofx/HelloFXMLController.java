/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hellofx;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author tomad
 */
public class HelloFXMLController implements Initializable {

    @FXML
    private Label theLabel;
    @FXML
    private TextField txtInput;
    @FXML
    private ListView<String> movieListView;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO Setup Here        
            //Configure ListView to Allow multiple selections
            movieListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            
    }//end initialize 
    
   /**
     * ADD = Button is clicked 
     * @param event 
     */
    @FXML
    private void handleAdd(ActionEvent event) {
        
        //Get String from txtInput 
        //Remove whitespace
        //Make all characters lowercase
        String nextMovie = txtInput.getText().trim().toLowerCase();
        
        //Add the sring to the listView        
         movieListView.getItems().add(nextMovie);   
        
        //Clear the text input box
         txtInput.clear();
       
    }//End handleAdd 

    /**
     * REMOVE = Button is clicked remove the selected items from the listView
     * @param event 
     */
    @FXML
    private void handleRemove(ActionEvent event) {
        
        
         ObservableList selectedIndices = movieListView.getSelectionModel().getSelectedIndices();

         if(selectedIndices.isEmpty())
         {
             
             System.out.println("Empty");
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("");
             alert.setHeaderText("");
             alert.setContentText("Please select an item to delete!");
             alert.showAndWait();
             
         }
         else{
             
              movieListView.getItems().removeAll(movieListView.getSelectionModel().getSelectedItems());
             
         }       
    } //End handleRemove

    /**
     * Load Data File
     * @param event 
     */
    @FXML
    private void handleLoad(ActionEvent event) throws FileNotFoundException, IOException {
        
        String filename = "movies.txt";
        
        //Clear before load
        movieListView.getItems().clear();
                
        ///Open an input stream
        try(BufferedReader in = 
        new BufferedReader(
        new FileReader(filename)))
        {            
            //Read data from the stream and print it to the console
            String line = in.readLine();

            //Keep Reading in from text file
            while(line != null){

                   //   System.out.println(line);
                 
                  //Add the sring to the listView        
                   movieListView.getItems().add(line);                 
                 
                 line = in.readLine();            
            } 

            in.close();
        }
        catch(FileNotFoundException e) 
        {
           System.out.println("not found");
        } 
         
    }//End handleLoad

    /**
     * Save Data File
     * @param event
     * @throws IOException 
     */
    @FXML
    private void handleSave(ActionEvent event) throws IOException {     
         
         //String Filename
         String filename = "movies.txt";
         
         //Open an output stream
         PrintWriter out = new PrintWriter(
         new BufferedWriter(
         new FileWriter(filename)));
         
         //Get Values from ListView
         ObservableList<String> items = movieListView.getItems();
         
         for (String movie : items) {
                   // Process each car (e.g., access properties, perform calculations)
                 out.println(movie); // ...
            }
         
         //Write Data to the stream
       //  out.println("New Test");
         
         //Close the oputput stream
         out.close();
         
    } //End Save
    
    /**
     * Handle Reset Button
     * Remove any selected choices from List View
     * @param event 
     */
    @FXML
    private void handleResetButton(ActionEvent event) throws FileNotFoundException, IOException {
        movieListView.getSelectionModel().clearSelection();      
    }//End Reset Button
    
}
