package application;

import java.net.URL;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableColumn<Kayitlar, String> yorum;

    @FXML
    private TableColumn<Kayitlar, String> secili;

    @FXML
    private TableColumn<Kayitlar, String> buton_sutun;

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
    
    @FXML
    private Button btn_yorum;

    @FXML
    private Button btn_secili;
    
    @FXML
    private TextField txt_sifre1;
    
    
    ObservableList<Kayitlar> veriler;
    Button[] butonlar=new Button[10];

    @FXML
    void btn_ekle_Click(ActionEvent event) {
    	veriler=FXCollections.observableArrayList();
    	veriler.add(new Kayitlar(3,txt_kul.getText(), txt_sifre.getText(), "----", butonlar[3]));
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
    	Kayitlar kk=new Kayitlar(idm,txt_kul.getText(), txt_sifre.getText(), "", butonlar[idm]);    	
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
    	//Secili olan kaydi txt Field lara atama
    	Kayitlar kayit=new Kayitlar();
    	kayit= (Kayitlar) kayitlar_table.getItems().get(kayitlar_table.getSelectionModel().getSelectedIndex());
    	txt_kul.setText(kayit.getKul_adi());
    	txt_sifre.setText(kayit.getSifre());
    	
    }
    
    
    @FXML
    void btn_secili_Click(ActionEvent event) {
    	//Secilmis satirlari belirleyerek degerleri aliyor
    	for(Kayitlar islem: veriler) {
    		if(islem.getOnay().isSelected()) {
    			System.out.println("Seçile olan kul:"+ islem.getKul_adi()+ "\n"+ //
    								"sifre:"+ islem.getSifre());
    			
    		}
    	}
    	
    }


    @FXML
    void btn_yorum_Click(ActionEvent event) {
    	//Yorum girilmis satirlar belirlenerek yorum degerleri aliniyor
    	for(Kayitlar islem: veriler) {
    		if(!islem.getMetinkutusu().getText().isEmpty()) {
    			System.out.println("Seçile olan kul:"+ islem.getKul_adi()+ "\n"+ //
    								"sifre:"+ islem.getSifre()+ "\n"+ //
    								"yorum:"+ islem.getMetinkutusu().getText() );
    		}
    	}
    }


    @FXML
    void initialize() {
    	

    	//Her Butona ayni fonksiyon Action olarak ataniyor ve id veriliyor
    	
    	for(int i=0; i<10; i++) {
    		butonlar[i]=new Button();
    		butonlar[i].setId("btn"+i);
    		butonlar[i].setOnAction(this::ButonOlayi);
    		
    	}
    	
    	
    	
    	//TableViewe Kayit girme
    	veriler=FXCollections.observableArrayList();
    	veriler.add(new Kayitlar(1,"admin", "123456", "", butonlar[0]));
    	veriler.add(new Kayitlar(2,"root", "ferffefe", "Bloke edilmiş üye", butonlar[1]));
    	veriler.add(new Kayitlar(3,"user", "gygyfr6464", "Deneme Yorum içeriği", butonlar[2]));
    	
    	//ilk id Tableview icerisindeki sutun adi
    	//ikinci id Kayitlar classindan gelen id
    	id.setCellValueFactory(new PropertyValueFactory<> ("id"));
    	kul_adi.setCellValueFactory(new PropertyValueFactory<> ("kul_adi"));
    	sifre.setCellValueFactory(new PropertyValueFactory<> ("sifre"));
    	yorum.setCellValueFactory(new PropertyValueFactory<>("metinkutusu"));
    	secili.setCellValueFactory(new PropertyValueFactory<>("onay"));
    	buton_sutun.setCellValueFactory(new PropertyValueFactory<>("buton"));
    	
    	
    	
    	
    	kayitlar_table.setItems(veriler);
    	
    	//TableView Sütunun gorunmez yapma
    	//kul_adi.setVisible(false);
    	//sifre.setVisible(false);
    	
    	 
    	 
    	
        
    }
    
    //Uretilen butonlara atanacak olay
    @FXML
    void ButonOlayi(ActionEvent event) {
    	for(int i=0;i<10;i++) {
    		//tetiklenen butonun hangisi olduguna bakiliyor
    		if(event.getSource()==butonlar[i]) {
    			System.out.println(i+".satirdaki buton tiklandi");
    		}
    	}
    }
    
   
    
    
    
    
    

    
   
    
    
}
