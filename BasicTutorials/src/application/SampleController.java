package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor1;

    @FXML
    private TextField txt_h�z1;

    @FXML
    private TextField txt_h�z2;

    @FXML
    private TextField txt_s�re;

    @FXML
    private Button btnHesapla;

    @FXML
    private Label lblSonuc;

    @FXML
    private Button btnTemizle;

    @FXML
    void btnHesapla_click(ActionEvent event) {
double hiz1,hiz2,sure;
hiz1=Double.parseDouble(txt_h�z1.getText());
hiz2=Double.parseDouble(txt_h�z2.getText());
sure=Double.parseDouble(txt_s�re.getText());

double sonuc=(hiz1-hiz2)*sure;
if(sonuc<0) {
	sonuc=Math.abs(sonuc);
}
lblSonuc.setText(String.valueOf(sonuc)+ "km");
    }

    @FXML
    void btnTemizle_click(ActionEvent event) {
    	lblSonuc.setText("... km");
    	txt_h�z1.setText("");
    	txt_h�z2.clear();
    	txt_s�re.setText("");
    	
    }

    @FXML
    void initialize() {
        assert anchor1 != null : "fx:id=\"anchor1\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txt_h�z1 != null : "fx:id=\"txt_h�z1\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txt_h�z2 != null : "fx:id=\"txt_h�z2\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txt_s�re != null : "fx:id=\"txt_s�re\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnHesapla != null : "fx:id=\"btnHesapla\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lblSonuc != null : "fx:id=\"lblSonuc\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnTemizle != null : "fx:id=\"btnTemizle\" was not injected: check your FXML file 'Sample.fxml'.";

    }
}
