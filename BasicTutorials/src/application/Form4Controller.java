package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;

public class Form4Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField txtSifre;

    @FXML
    private TextField txtKullanýcýAdý;

    @FXML
    private Button btnlogin;

    @FXML
    private Button btnBilgi;

    @FXML
    private Button btnCombo;

    @FXML
    private Button btnÝnput;

    @FXML
    private Button btnSoru;

    @FXML
    private Button btnHata;

    @FXML
    private Button btnCikis;

    @FXML
    void btnBilgi_click(ActionEvent event) {
Alert alert=new Alert(AlertType.INFORMATION);
alert.setTitle("Ýste Otomasyon");
alert.setHeaderText("Bilgi Mesajý.......");
alert.setContentText("Ýste Otomasyon Sistemidir.");
alert.showAndWait();// hangi butona týklandýðý bilgisini alýr.
    }

    @FXML
    void btnCikis_click(ActionEvent event) {
System.exit(0); // proðram kapatma
    }

    @FXML
    void btnCombo_click(ActionEvent event) {
    	List<String> sec=new ArrayList<>();
    	sec.add("1.Seçenek");
    	sec.add("2.Seçenek");
    	sec.add("3.Seçenek");
    	ChoiceDialog<String> dialog=new ChoiceDialog<String>("1.Seçenek",sec);
    	Optional<String> sonuc= dialog.showAndWait(); // seçilen seçeneðin bilgisini verir
    	
    	if (sonuc.isPresent()) {
    		System.out.println("Secilen: "+sonuc.get());
			
		}
    }

    @FXML
    void btnHata_click(ActionEvent event) {
Alert alert=new Alert(AlertType.ERROR);
alert.setTitle("Ýste Otomasyon");
alert.setHeaderText("Hata Mesajý.......");
alert.setContentText("Ýste Otomasyon Sistemidir.");
alert.showAndWait();
    }

    @FXML
    void btnSoru_click(ActionEvent event) {
Alert alert=new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Ýste Otomasyon");
	alert.setHeaderText("Onay Kutusu");
	alert.setContentText("Silmek Ýstediðinize Eminmisiniz?");
	// Yeni Butonlar Atama
	ButtonType btn1=new ButtonType("Evet");
	ButtonType btn2=new ButtonType("Hayýr");
	ButtonType btn3=new ButtonType("Ýptal",ButtonData.CANCEL_CLOSE);
	ButtonType btn4=new ButtonType("Tamam",ButtonData.OK_DONE);
	
	alert.getButtonTypes().setAll(btn1,btn2,btn3,btn4);// butonlarý alert pencerisi içerisine atama
	Optional<ButtonType> sonuc=alert.showAndWait(); // butona týklanma bilgisini almak için
	if(sonuc.get()==btn1) {
		System.out.println("Evet Butonuna basýldý");
	}
	else if(sonuc.get()==btn2) {
		System.out.println("Hayýr Butonuna Basýldý");
	}
	else if(sonuc.get()==btn3) {
		System.out.println("Ýptal Butonuna Basýldý");
	}
	else if(sonuc.get()==btn4) {
		System.out.println("Tamam Butonuna Basýldý");
	}
	else {
		System.out.println("Butona Basýlmadý..");
	}

    }

    @FXML
    void btnlogin_click(ActionEvent event) {
LoginKontrol(txtKullanýcýAdý.getText(), txtSifre.getText());
    }

    @FXML
    void btnÝnput_click(ActionEvent event) {
    	TextInputDialog dialog=new TextInputDialog("Ýste");
    	dialog.setTitle("Ýste....");
    	dialog.setHeaderText("Otomasyon Onay");
    	dialog.setContentText("Telefonunuza Gönderilen Onay Kodunu Giriniz..");
    	Optional<String> deger= dialog.showAndWait();
    	if(deger.isPresent()) {
    		System.out.println("Girilen Metin: "+deger.get());
    	}
    }
//Login Kontrolü Ýçin Fonk. Oluþturuldu
    public void LoginKontrol(String Kul,String Sifre){
    	Alert alert=new Alert(AlertType.ERROR);
    	alert.setTitle("Ýste Otomasyon");
    	alert.setHeaderText("Hata Mesaj Kutusu");
    	if(!Kul.isEmpty() && !Sifre.isEmpty()) {
    		if (Kul.contains("@iste.edu.tr")&&Kul.length()>13) {
				if(Sifre.contains("=")||Sifre.contains("'")||Sifre.contains("\\x75")||Sifre.contains("\\x25")) {
					alert.setContentText("SQL ÝNJECTÝON TESPÝT EDÝLDÝ.");
					System.exit(0);
				}
				else {
					if(Sifre.length()<8) {
						alert.setContentText("Þifre 8 Karakterden Az Olamaz");
					}
					else {
						alert.setContentText("Giriþ Baþarýlýdýr.");
					}
				}
			}
    		else {
    			alert.setContentText("Ýste Mail Adresi Ýle Giriþ Yapýlabilir.");
    		}
    		
    	}
    	
    	
    	 else {
    		    alert.setContentText("Kullanýcý Adý ve Þifre Boþ Geçilemez.....");
    		    }
    	alert.showAndWait();
    }
   
    @FXML
    void initialize() {
        

    }
}
