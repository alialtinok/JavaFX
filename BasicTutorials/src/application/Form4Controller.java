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
    private TextField txtKullan�c�Ad�;

    @FXML
    private Button btnlogin;

    @FXML
    private Button btnBilgi;

    @FXML
    private Button btnCombo;

    @FXML
    private Button btn�nput;

    @FXML
    private Button btnSoru;

    @FXML
    private Button btnHata;

    @FXML
    private Button btnCikis;

    @FXML
    void btnBilgi_click(ActionEvent event) {
Alert alert=new Alert(AlertType.INFORMATION);
alert.setTitle("�ste Otomasyon");
alert.setHeaderText("Bilgi Mesaj�.......");
alert.setContentText("�ste Otomasyon Sistemidir.");
alert.showAndWait();// hangi butona t�kland��� bilgisini al�r.
    }

    @FXML
    void btnCikis_click(ActionEvent event) {
System.exit(0); // pro�ram kapatma
    }

    @FXML
    void btnCombo_click(ActionEvent event) {
    	List<String> sec=new ArrayList<>();
    	sec.add("1.Se�enek");
    	sec.add("2.Se�enek");
    	sec.add("3.Se�enek");
    	ChoiceDialog<String> dialog=new ChoiceDialog<String>("1.Se�enek",sec);
    	Optional<String> sonuc= dialog.showAndWait(); // se�ilen se�ene�in bilgisini verir
    	
    	if (sonuc.isPresent()) {
    		System.out.println("Secilen: "+sonuc.get());
			
		}
    }

    @FXML
    void btnHata_click(ActionEvent event) {
Alert alert=new Alert(AlertType.ERROR);
alert.setTitle("�ste Otomasyon");
alert.setHeaderText("Hata Mesaj�.......");
alert.setContentText("�ste Otomasyon Sistemidir.");
alert.showAndWait();
    }

    @FXML
    void btnSoru_click(ActionEvent event) {
Alert alert=new Alert(AlertType.CONFIRMATION);
	alert.setTitle("�ste Otomasyon");
	alert.setHeaderText("Onay Kutusu");
	alert.setContentText("Silmek �stedi�inize Eminmisiniz?");
	// Yeni Butonlar Atama
	ButtonType btn1=new ButtonType("Evet");
	ButtonType btn2=new ButtonType("Hay�r");
	ButtonType btn3=new ButtonType("�ptal",ButtonData.CANCEL_CLOSE);
	ButtonType btn4=new ButtonType("Tamam",ButtonData.OK_DONE);
	
	alert.getButtonTypes().setAll(btn1,btn2,btn3,btn4);// butonlar� alert pencerisi i�erisine atama
	Optional<ButtonType> sonuc=alert.showAndWait(); // butona t�klanma bilgisini almak i�in
	if(sonuc.get()==btn1) {
		System.out.println("Evet Butonuna bas�ld�");
	}
	else if(sonuc.get()==btn2) {
		System.out.println("Hay�r Butonuna Bas�ld�");
	}
	else if(sonuc.get()==btn3) {
		System.out.println("�ptal Butonuna Bas�ld�");
	}
	else if(sonuc.get()==btn4) {
		System.out.println("Tamam Butonuna Bas�ld�");
	}
	else {
		System.out.println("Butona Bas�lmad�..");
	}

    }

    @FXML
    void btnlogin_click(ActionEvent event) {
LoginKontrol(txtKullan�c�Ad�.getText(), txtSifre.getText());
    }

    @FXML
    void btn�nput_click(ActionEvent event) {
    	TextInputDialog dialog=new TextInputDialog("�ste");
    	dialog.setTitle("�ste....");
    	dialog.setHeaderText("Otomasyon Onay");
    	dialog.setContentText("Telefonunuza G�nderilen Onay Kodunu Giriniz..");
    	Optional<String> deger= dialog.showAndWait();
    	if(deger.isPresent()) {
    		System.out.println("Girilen Metin: "+deger.get());
    	}
    }
//Login Kontrol� ��in Fonk. Olu�turuldu
    public void LoginKontrol(String Kul,String Sifre){
    	Alert alert=new Alert(AlertType.ERROR);
    	alert.setTitle("�ste Otomasyon");
    	alert.setHeaderText("Hata Mesaj Kutusu");
    	if(!Kul.isEmpty() && !Sifre.isEmpty()) {
    		if (Kul.contains("@iste.edu.tr")&&Kul.length()>13) {
				if(Sifre.contains("=")||Sifre.contains("'")||Sifre.contains("\\x75")||Sifre.contains("\\x25")) {
					alert.setContentText("SQL �NJECT�ON TESP�T ED�LD�.");
					System.exit(0);
				}
				else {
					if(Sifre.length()<8) {
						alert.setContentText("�ifre 8 Karakterden Az Olamaz");
					}
					else {
						alert.setContentText("Giri� Ba�ar�l�d�r.");
					}
				}
			}
    		else {
    			alert.setContentText("�ste Mail Adresi �le Giri� Yap�labilir.");
    		}
    		
    	}
    	
    	
    	 else {
    		    alert.setContentText("Kullan�c� Ad� ve �ifre Bo� Ge�ilemez.....");
    		    }
    	alert.showAndWait();
    }
   
    @FXML
    void initialize() {
        

    }
}
