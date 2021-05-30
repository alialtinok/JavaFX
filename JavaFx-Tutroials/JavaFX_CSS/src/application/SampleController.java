package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lb1;

    @FXML
    private Label lb2;

    @FXML
    private Label lb3;

    @FXML
    private Label lb4;

    @FXML
    private Label lb5;

    @FXML
    private CheckBox check1;

    @FXML
    private Button button1;

    @FXML
    void btn1_click(ActionEvent event) {
    	//Checkbox üzerine kodlarla css atama
    	check1.setStyle("-fx-border-color:black;" +
    			"-fx-font-size:25; "+
    			"-fx-border-insets:-5;"+
    			"-fx-border-style: dotted;"+
    			"-fx-background-color: #B8FFD8;"+
    			"-fx-border-width: 5;"    			
    			);
    	
    	//Css dosyasından stil cagirmak icin SceneBuilder icerisinden
    	//Properties->StyleSheets kismindan kullanilacak css dosyasi secilir.
    	//Bu css icerisine bilesende kullanmak uzere .background, .menum gibi
    	//isimlerle css siniflari olusturulur
    	//Olusturulan bu css siniflari Properties->StyleSheets->Style Class kismindan secilir
    	
    	
    }

    @FXML
    void initialize() {
        
    }
}
