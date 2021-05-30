package application;

import java.net.URL;
import java.util.Observer;
import java.util.ResourceBundle;

import application.SampleController.Kayitlar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Kayitlar> kayitlar_table;

    @FXML
    private TableColumn<Kayitlar, Integer> id;

    @FXML
    private TableColumn<Kayitlar, String> kul_adi;

    @FXML
    private TableColumn<Kayitlar, String> sifre;

    @FXML
    private TextField txt_kul;

    @FXML
    private TextField txt_sifre;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_sil;

    @FXML
    private Button btn_goster;

    @FXML
    private Button btn_guncelle;
    
    
    ObservableList<Kayitlar> veriler;
    

    @FXML
    void btn_ekle_Click(ActionEvent event) {
    	veriler=FXCollections.observableArrayList();
    	veriler.add(new Kayitlar(3,txt_kul.getText(), txt_sifre.getText()));
    	kayitlar_table.getItems().addAll(veriler);
    }

    @FXML
    void btn_goster_Click(ActionEvent event) {
    	Kayitlar kayit=new Kayitlar();
    	if(kayitlar_table.getSelectionModel().getSelectedIndex()!=-1) {
    		kayit= (Kayitlar) kayitlar_table.getItems().get(kayitlar_table.getSelectionModel().getSelectedIndex());
    		System.out.println("Seçilen Kullanıcı adı:"+ kayit.getKul_adi() + "\n" + //
    							"Şifre:"+ kayit.getSifre() + "\n" + //
    							"Id:"+ kayit.getId() );
    	}
    	else {
    		System.out.println("Herhangi bir kayit secilmedi...");
    	}
    }

    @FXML
    void btn_guncelle_Click(ActionEvent event) {
    	
    	//Secili kaydi alin
    	Kayitlar kayit=new Kayitlar();
    	kayit= (Kayitlar) kayitlar_table.getItems().get(kayitlar_table.getSelectionModel().getSelectedIndex());
    	int idm=kayit.getId();
    	
    	//Yeni kayitlar olusturularak indise gore set edilir
    	Kayitlar kk=new Kayitlar(idm,txt_kul.getText(), txt_sifre.getText());    	
    	int sira= kayitlar_table.getSelectionModel().getSelectedIndex();
    	kayitlar_table.getItems().set(sira, kk);
    	
    }

    @FXML
    void btn_sil_Click(ActionEvent event) {
    	ObservableList<Kayitlar> secilenKayit, tumKayitlar;
    	tumKayitlar=kayitlar_table.getItems();
    	secilenKayit=kayitlar_table.getSelectionModel().getSelectedItems();
    	
    	secilenKayit.forEach(tumKayitlar::remove);
    	
    }

    @FXML
    void kayitlar_table_Click(MouseEvent event) {
    	Kayitlar kayit=new Kayitlar();
    	kayit= (Kayitlar) kayitlar_table.getItems().get(kayitlar_table.getSelectionModel().getSelectedIndex());
    	txt_kul.setText(kayit.getKul_adi());
    	txt_sifre.setText(kayit.getSifre());
    }

    @FXML
    void initialize() {
    	
    	
    	

    	//Tooltip Ekleme
    	btn_ekle.setTooltip(new Tooltip("Kayıt Eklemeyi sağlar"));
    	
    	Tooltip tip=new Tooltip();
    	tip.setStyle("-fx-background-color:yellow;");
    	tip.setText("Silme işlemini sağlayan butondur");
    	Image img=new Image(getClass().getResourceAsStream("warn.png"));
    	tip.setGraphic(new ImageView(img));
    	btn_sil.setTooltip(tip);    	

    	
    	//TableViewe Kayit girme
    	veriler=FXCollections.observableArrayList();
    	veriler.add(new Kayitlar(1,"admin", "123456"));
    	veriler.add(new Kayitlar(2,"root", "ferffefe"));
    	veriler.add(new Kayitlar(3,"user", "gygyfr6464"));
    	
    	//ilk id Tableview icerisindeki sutun adi
    	//ikinci id Kayitlar classindan gelen id
    	id.setCellValueFactory(new PropertyValueFactory<> ("id"));
    	kul_adi.setCellValueFactory(new PropertyValueFactory<> ("kul_adi"));
    	sifre.setCellValueFactory(new PropertyValueFactory<> ("sifre"));
    	
    	kayitlar_table.setItems(veriler);
    	
    	//TableView Sütunun gorunmez yapma
    	//kul_adi.setVisible(false);
    	
    	
    	//Kodla tableview olusturma

    	
    	
        
    }
    
    
    //Kayitlar icin class olusturup setter getter ayarlama
    public static class Kayitlar{
    	private int id;
    	private String kul_adi;
    	private String sifre;
    	
    	Kayitlar(){
    		
    	}
    	
    	Kayitlar(int id, String kul_ad, String sifre){
    		this.id=id;
    		this.kul_adi=kul_ad;
    		this.sifre=sifre;    		
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
    
   
    
    
}
