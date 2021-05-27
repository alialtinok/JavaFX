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
    private TextField txt_hýz1;

    @FXML
    private TextField txt_hýz2;

    @FXML
    private TextField txt_süre;

    @FXML
    private Button btnHesapla;

    @FXML
    private Label lblSonuc;

    @FXML
    private Button btnTemizle;

    @FXML
    void btnHesapla_click(ActionEvent event) {
double hiz1,hiz2,sure;
hiz1=Double.parseDouble(txt_hýz1.getText());
hiz2=Double.parseDouble(txt_hýz2.getText());
sure=Double.parseDouble(txt_süre.getText());

double sonuc=(hiz1-hiz2)*sure;
if(sonuc<0) {
	sonuc=Math.abs(sonuc);
}
lblSonuc.setText(String.valueOf(sonuc)+ "km");
    }

    @FXML
    void btnTemizle_click(ActionEvent event) {
    	lblSonuc.setText("... km");
    	txt_hýz1.setText("");
    	txt_hýz2.clear();
    	txt_süre.setText("");
    	
    }

    @FXML
    void initialize() {
        assert anchor1 != null : "fx:id=\"anchor1\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txt_hýz1 != null : "fx:id=\"txt_hýz1\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txt_hýz2 != null : "fx:id=\"txt_hýz2\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txt_süre != null : "fx:id=\"txt_süre\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnHesapla != null : "fx:id=\"btnHesapla\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lblSonuc != null : "fx:id=\"lblSonuc\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnTemizle != null : "fx:id=\"btnTemizle\" was not injected: check your FXML file 'Sample.fxml'.";

    }
}
