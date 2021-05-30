package application;


//Kayitlar icin class olusturup setter getter ayarlama
public class Kayitlar{
	
	private int id;
	private String sutun_kulad;
	private String sifre;
	
	//private CheckBox onay;
	//private TextField metinkutusu;
	//private Button buton;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSutun_kulad() {
		return sutun_kulad;
	}
	public void setSutun_kulad(String sutun_kulad) {
		this.sutun_kulad = sutun_kulad;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
	
	Kayitlar(){
		
	}
	
	//Kayitlar(int id, String kul_ad, String sifre, String icerik, Button buton){
	Kayitlar(int id, String kulad, String sifre){
		this.id=id;
		this.sutun_kulad=kulad;
		this.sifre=sifre; 
		
		//this.onay= new CheckBox();
		//this.metinkutusu=new TextField();
		//this.metinkutusu.setText(icerik);
		
		//this.buton=buton; this.buton.setText("Email");
		
	}
	
	
	
	/*
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
	
	*/
	
	
	


}