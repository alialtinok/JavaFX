package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FormUyg2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblFormVeri;
    //***** Veriyi Ba�ka forma aktarmak i�in olu�turulan fonk
public void VeriAl(String �cerik) {
	lblFormVeri.setText("Transfer Edilen De�er: "+�cerik);
}
    @FXML
    void initialize() {
        
    }
}
