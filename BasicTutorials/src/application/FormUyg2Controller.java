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
    //***** Veriyi Baþka forma aktarmak için oluþturulan fonk
public void VeriAl(String Ýcerik) {
	lblFormVeri.setText("Transfer Edilen Deðer: "+Ýcerik);
}
    @FXML
    void initialize() {
        
    }
}
