package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_tum;

    @FXML
    private AnchorPane anchor_sol;

    @FXML
    private AnchorPane anchor_sag;

    @FXML
    private Button btn_ic;

    @FXML
    private Button btn_dis;

    @FXML
    private Button btn_trans;

    @FXML
    private Button btn_menu;

    @FXML
    void btn_dis_Click(ActionEvent event) {
    	
    	//Stage olarak dis ayri form olusturma
    	try {
    		Stage stage1=new Stage();
			AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("Form1.fxml"));
			Scene scene1=new Scene(pane1);
			stage1.setScene(scene1);
			stage1.show();
			
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	//Dis forma veri aktarimi
    	
    	    	try {
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Form1.fxml"));
			AnchorPane pane2= (AnchorPane) loader.load();
			Form1Controller nesne= loader.getController();
			Scene scene2=new Scene(pane2);
			nesne.VeriAl("Merhaba");
			
			
			Stage stage2=new Stage();
			stage2.setScene(scene2);
			stage2.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));		
			stage2.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
    	
    	
    	
    }

    @FXML
    void btn_ic_Click(ActionEvent event) {
    	//Tasarlanmis FXML dosyasinin AnchorPane icerisine
    	//Stage olusturmadan gomulmesi

    	try {
			AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("Form1.fxml"));
			anchor_sag.getChildren().setAll(pane1);
    	
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void btn_menu_Click(ActionEvent event) {
    	//Tasarlanmis FXML dosyasinin AnchorPane icerisine
    	//Stage olusturmadan gomulmesi
    	try {
			AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("Form2.fxml"));
			anchor_sol.getChildren().setAll(pane1);
    	
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    	
    	
    	
    	

    }

    @FXML
    void btn_trans_Click(ActionEvent event) {
    	try {
    		Stage stage1=new Stage();
			AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("Form1.fxml"));
			Scene scene1=new Scene(pane1);
			stage1.setScene(scene1);
			//Formun opakligini ayarlama
			stage1.setOpacity(0.8);
			//Forma baslik atama
			stage1.setTitle("Merhaba İSTE");
			//Formun merkezde calistirilmasi
			stage1.centerOnScreen();
			//Formun gosterim bicimlerini ayarlama
			stage1.initStyle(StageStyle.DECORATED); //Varsayilan
			stage1.initStyle(StageStyle.UNDECORATED); //Menu tuslari olmadan baslatir
			stage1.initStyle(StageStyle.TRANSPARENT); //Menu tuslari olmadan gosterir
			stage1.initStyle(StageStyle.UNIFIED); //Varsayilan
			stage1.initStyle(StageStyle.UTILITY); //Sadece kapama butonu
						
			//Forma icon ekleme
			//stage1.getIcons().add(new Image(("file:logo.png")));
			stage1.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));
			stage1.show();
			//Ekrani full ekran yapma
			stage1.setFullScreen(true);
			
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	

    }

    @FXML
    void initialize() {
        assert anchor_tum != null : "fx:id=\"anchor_tum\" was not injected: check your FXML file 'Sample.fxml'.";
        assert anchor_sol != null : "fx:id=\"anchor_sol\" was not injected: check your FXML file 'Sample.fxml'.";
        assert anchor_sag != null : "fx:id=\"anchor_sag\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btn_ic != null : "fx:id=\"btn_ic\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btn_dis != null : "fx:id=\"btn_dis\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btn_trans != null : "fx:id=\"btn_trans\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btn_menu != null : "fx:id=\"btn_menu\" was not injected: check your FXML file 'Sample.fxml'.";

    }
}
