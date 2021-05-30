package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;


import com.IsteMysql.Util.VeritabaniUtil;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SampleController {
	
	String sql="";
	int idm=0;
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;

    public SampleController() {
		baglanti=VeritabaniUtil.Baglan();
	}
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Kayitlar> tableview_kayitlar;

    @FXML
    private TableColumn<Kayitlar, Integer> kID;

    @FXML
    private TableColumn<Kayitlar, String> kulad;

    @FXML
    private TableColumn<Kayitlar, String> sifre;

    @FXML
    private TextField txt_kul_ad;

    @FXML
    private TextField txt_sifre;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_sil;

    @FXML
    private Button btn_guncelle;

    @FXML
    private Label lbl_sonuc;

    @FXML
    void Ekle_Click(ActionEvent event) {
    	sql="insert into login(kul_ad,sifre) values(?,?)";
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			sorguIfadesi.setString(1, txt_kul_ad.getText().trim());
			sorguIfadesi.setString(2, txt_sifre.getText().trim());
			sorguIfadesi.executeUpdate();
			lbl_sonuc.setText("Ekleme işlemi başarılı");
			DegerleriGetir(tableview_kayitlar);
		} catch (Exception e) {
			lbl_sonuc.setText(e.getMessage().toString());
		}
    }

    @FXML
    void Guncelle_Click(ActionEvent event) {
    	sql="update login set kul_ad=?,sifre=? where kID=?";
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			sorguIfadesi.setString(1, txt_kul_ad.getText().trim());
			sorguIfadesi.setString(2, txt_sifre.getText().trim());
			sorguIfadesi.setInt(3, idm);
			sorguIfadesi.executeUpdate();
			lbl_sonuc.setText("Güncelleme işlemi başarılı");
			DegerleriGetir(tableview_kayitlar);
		} catch (Exception e) {
			lbl_sonuc.setText(e.getMessage().toString());
		}
    }

    @FXML
    void Sil_Click(ActionEvent event) {
    	sql="delete from login where kul_ad=? and kID=?";
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			sorguIfadesi.setString(1, txt_kul_ad.getText().trim());
			sorguIfadesi.setInt(2, idm);
			sorguIfadesi.executeUpdate();
			lbl_sonuc.setText("Silme işlemi başarılı");
			DegerleriGetir(tableview_kayitlar);
		} catch (Exception e) {
			lbl_sonuc.setText(e.getMessage().toString());
		}
    }

    @FXML
    void tableView_MouseClick(MouseEvent event) {
    	Kayitlar kayit=new Kayitlar();
    	kayit= (Kayitlar) tableview_kayitlar.getItems().get(tableview_kayitlar.getSelectionModel().getSelectedIndex());
    	txt_kul_ad.setText(kayit.getSutun_kulad());
    	txt_sifre.setText(kayit.getSifre());
    	idm=kayit.getId();
    }
    
    public void DegerleriGetir(TableView tablo) {
    	sql="select * from login";
    	ObservableList<Kayitlar> kayitlarListe=FXCollections.observableArrayList();
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			while(getirilen.next()) {
				kayitlarListe.add(new Kayitlar(getirilen.getInt("kID"), getirilen.getString("kul_ad"), getirilen.getString("sifre")));
			}		
			
			kID.setCellValueFactory(new PropertyValueFactory<>("id"));
			kulad.setCellValueFactory(new PropertyValueFactory<>("sutun_kulad"));
			sifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));
			tableview_kayitlar.setItems(kayitlarListe);
			lbl_sonuc.setText("Bağlantı başarılı");
			
		} catch (Exception e) {
			lbl_sonuc.setText(e.getMessage().toString());
		}
    }
    
    
    
    @FXML
    void initialize() {
    	DegerleriGetir(tableview_kayitlar);
    	
        
    }
}
