package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.IsteMysql.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.sql.*;




public class SampleController {
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label lbl_sonuc;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;
    
    @FXML
    private TextField txt_kul;

    @FXML
    private TextField txt_sifre;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    public SampleController() {
		baglanti=VeritabaniUtil.Baglan();
	}


    @FXML
    void btn1_Login(ActionEvent event) {
    	sql="select * from login where kul_ad=? and sifre=?";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txt_kul.getText().trim());
    		sorguIfadesi.setString(2, txt_sifre.getText().trim());
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		
    		if(!getirilen.next()) {
    			lbl_sonuc.setText("Kullanıcı adı ya da şifre hatalı");    
    		}
    		else {
    			//getirilen.getString(1); //Tabloda 1nolu sutundaki degeri getirir 
    		   System.out.println( "kID:"+getirilen.getString("kID")+ "\n"+ //
    				   				"Kullanıcı adı:"+ getirilen.getString("kul_ad")+ "\n"+ //
    				   				"Sifre:"+ getirilen.getString("sifre"));
    		   
    		   //getirilen.getInt("kID"); //getirilen verinin integer olarak alinmasi
    		   //getirilen.getDouble("sutun_adi"); //getirilen verinni double olarak alinmasi
    		   //getirilen.getDate("tarih"); //Getirilen degerin tarih formatinda alinmasi
    		   
    		}
			
		} catch (Exception e) {
			lbl_sonuc.setText(e.getMessage().toString());
		}
    }
    

    @FXML
    void btn2_Ekle(ActionEvent event) {
    	sql="insert into login(kul_ad,sifre) values(?,?)";
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			sorguIfadesi.setString(1, txt_kul.getText().trim());
			sorguIfadesi.setString(2, txt_sifre.getText().trim());
			sorguIfadesi.executeUpdate();
			lbl_sonuc.setText("Ekleme işlemi başarılı");
		} catch (Exception e) {
			lbl_sonuc.setText(e.getMessage().toString());
		}
    }

    @FXML
    void btn3_Sil(ActionEvent event) {
    	sql="delete from login where kul_ad=? and sifre=?";
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			sorguIfadesi.setString(1, txt_kul.getText().trim());
			sorguIfadesi.setString(2, txt_sifre.getText().trim());
			sorguIfadesi.executeUpdate();
			lbl_sonuc.setText("Silme işlemi başarılı");
		} catch (Exception e) {
			lbl_sonuc.setText(e.getMessage().toString());
		}
    }

    @FXML
    void btn4_Guncelle(ActionEvent event) {
    	sql="update login set kul_ad=?, sifre=? where kID=4";
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			sorguIfadesi.setString(1, txt_kul.getText().trim());
			sorguIfadesi.setString(2, txt_sifre.getText().trim());
			sorguIfadesi.executeUpdate();
			lbl_sonuc.setText("Güncelleme işlemi başarılı");
		} catch (Exception e) {
			lbl_sonuc.setText(e.getMessage().toString());
		}
    }
    

    
    @FXML
    void initialize() {
    	
    }
    

}
