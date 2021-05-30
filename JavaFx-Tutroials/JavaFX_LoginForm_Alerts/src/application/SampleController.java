package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_kul;

    @FXML
    private PasswordField txt_pass;

    @FXML
    private Button btn_giris;

    @FXML
    private Button btn_alertbilgi;

    @FXML
    private Button btn_hata;

    @FXML
    private Button btn_soru;

    @FXML
    private Button btn_input;

    @FXML
    private Button btn_Combo;

    @FXML
    private Button btn_Cikis;

    @FXML
    void btn_Alertbilgi_Click(ActionEvent event) {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("İste otomasyon");
    	alert.setHeaderText("Bilgi Mesajı");
    	alert.setContentText("Bu bir bilgi mesajıdır \n Merhaba");
    	alert.showAndWait();
    	

    }

    @FXML
    void btn_Cikis_click(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void btn_Combo_click(ActionEvent event) {
    	
    	
    	List<String> sec=new ArrayList<>();
    	sec.add("1.secenek");
    	sec.add("2.secenek");
    	sec.add("3.secenek");
    	
    	
    	ChoiceDialog<String> dialog= new ChoiceDialog<String>("2.secenek", sec);
    	
    	Optional<String> sonuc= dialog.showAndWait();
    	
    	if(sonuc.isPresent()) {
    		System.out.println("Seçilen:"+ sonuc.get());
    	}
    	
    	
    	
    	
    
    }

    @FXML
    void btn_Hata_Click(ActionEvent event) {
    	Alert alert=new Alert(AlertType.WARNING);
    	alert.setTitle("İste otomasyon");
    	alert.setHeaderText("Uyarı Mesajı");
    	alert.setContentText("Bu bir uyarı mesajıdır\n Merhaba");
    	alert.showAndWait();
    }

    @FXML
    void btn_giris_Click(ActionEvent event) {
    	Kontrol(txt_kul.getText(),txt_pass.getText());
    }
    
    public void Kontrol(String kul, String sifre) {
    	Alert alert=new Alert(AlertType.ERROR);
    	alert.setTitle("İste otomasyon");
    	alert.setHeaderText("Hata Mesajı");
    	
    	if(!kul.isEmpty() && !sifre.isEmpty()) {
    		if(kul.contains("@iste.edu.tr") && kul.length()>13) {
    			if(sifre.contains("=") || sifre.contains("'") || sifre.contains("\\x27")) {
    				alert.setContentText("Sql injection tespit edildi");
    			}
    			else {
    				if(sifre.length()<4) {
    					alert.setContentText("Şifre en az 4 karakter olmalı");
    				}
    				else {
    					alert.setContentText("Giriş başarılı");
    				}
    				
    				
    			}
    		}
    		else {
    			alert.setContentText("İste mail adresiyle girilmelidir ve gecerli bir mail giriniz");
    		}
    	}
    	else {
    		alert.setContentText("Kullanıcı mail ve şifre boş geçilemez");
    	}
    	
    	alert.showAndWait();
    	
    }

    @FXML
    void btn_input_Click(ActionEvent event) {

    	TextInputDialog dialog=new TextInputDialog("iste");
    	dialog.setTitle("İste ");
    	dialog.setHeaderText("otomasyon onay");
    	dialog.setContentText("Telefonunuza gönderilen onay kodunu giriniz.");
    	
    	Optional<String> sonuc=dialog.showAndWait();
    	if(sonuc.isPresent()) {
    		System.out.println("Girilen metin:"+sonuc.get());
    	}
    	
    }

    @FXML
    void btn_soru_Click(ActionEvent event) {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("İste otomasyon");
    	alert.setHeaderText("Mesajı");
    	alert.setContentText("Silmek istediğinize emin misiniz?");
 
    	
    	ButtonType btn1=new ButtonType("Evet");
    	ButtonType btn2=new ButtonType("Hayır");
    	ButtonType btn3=new ButtonType("iptal", ButtonData.CANCEL_CLOSE);
    	
    	alert.getButtonTypes().setAll(btn1,btn2,btn3);
    	
    	Optional<ButtonType> sonuc=alert.showAndWait();
    	if(sonuc.get()==btn1) {
    		System.out.println("Evet seçeneğine basıldı");
    	}
    	else if(sonuc.get()==btn2) {
    		System.out.println("Hayır seçeneğine basıldı");
    	}
    	else if(sonuc.get()==btn3) {
    		System.out.println("İptal butonuna basıldı");
    	}
    	else {
    		System.out.println("İptal butonuna basıldı");
    	}
    	
    	
    	
    
    }

    @FXML
    void initialize() {

    }
}
