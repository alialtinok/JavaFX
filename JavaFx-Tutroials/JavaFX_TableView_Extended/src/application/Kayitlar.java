package application;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

//Kayitlar icin class olusturup setter getter ayarlama
public class Kayitlar{
	
	private int id;
	private String kul_adi;
	private String sifre;
	
	private CheckBox onay;
	private TextField metinkutusu;
	private Button buton;
	
	Kayitlar(){
		
	}
	
	Kayitlar(int id, String kul_ad, String sifre, String icerik, Button buton){
		this.id=id;
		this.kul_adi=kul_ad;
		this.sifre=sifre; 
		
		this.onay= new CheckBox();
		this.metinkutusu=new TextField();
		this.metinkutusu.setText(icerik);
		
		this.buton=buton; this.buton.setText("Email");
		
	}
	
	
	public CheckBox getOnay() {
		return onay;
	}

	public void setOnay(CheckBox onay) {
		this.onay = onay;
	}

	public TextField getMetinkutusu() {
		return metinkutusu;
	}

	public void setMetinkutusu(TextField metinkutusu) {
		this.metinkutusu = metinkutusu;
	}

	public Button getButon() {
		return buton;
	}

	public void setButon(Button buton) {
		this.buton = buton;
	}
	

	
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKul_adi() {
		return kul_adi;
	}
	public void setKul_adi(String kul_adi) {
		this.kul_adi = kul_adi;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
}