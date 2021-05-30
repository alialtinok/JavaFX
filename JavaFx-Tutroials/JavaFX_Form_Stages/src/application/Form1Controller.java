package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Form1Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbl1;

    @FXML
    void initialize() {
        assert lbl1 != null : "fx:id=\"lbl1\" was not injected: check your FXML file 'Form1.fxml'.";

    }
    
    public void VeriAl(String icerik) {
    	lbl1.setText("Transfer Edilen Deger: "+icerik);
    }
}
