package application;

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

public class FormUyg3Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorTüm;

    @FXML
    private AnchorPane anchorSol;

    @FXML
    private AnchorPane anchorSag;

    @FXML
    private Button btnÝc;

    @FXML
    private Button btnDis;

    @FXML
    private Button btnMenü;

    @FXML
    private Button btnTrans;

    @FXML
    void btnDis_click(ActionEvent event) {
    	//Stage Olarak Dýþ Form Oluþturma
    	
    	/*try {
    		Stage stage1=new Stage();
			AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("FormUyg2.fxml")); 
			Scene scene = new Scene(pane1);
			stage1.setScene(scene);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
    	//Dýþ Forma Veri Aktarýmý
    	try {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("FormUyg2.fxml"));
    		AnchorPane pane2=(AnchorPane) loader.load();
    		FormUyg2Controller nesne=loader.getController();// baþka formun controllerýndaki fonk eriþebilmek için
    		Scene scene2=new Scene(pane2);
    		nesne.VeriAl(" Merhaba ");
    		
    		Stage stage2=new Stage();
    		stage2.setScene(scene2);
    		stage2.getIcons().add(new Image(getClass().getResourceAsStream("a.png")));
    		stage2.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void btnMenü_click(ActionEvent event) {
    	try {
			AnchorPane panel=(AnchorPane) FXMLLoader.load(getClass().getResource("FormUyg1.fxml"));
			anchorSol.getChildren().setAll(panel);// anchor pane e children olarak atama yapýlýr.
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    }

    @FXML
    void btnTrans_click(ActionEvent event) {
    	try {
			Stage stage1=new Stage();
			AnchorPane panel=(AnchorPane) FXMLLoader.load(getClass().getResource("FormUyg2.fxml"));
			Scene scene=new Scene(panel);
			
			stage1.setScene(scene);
			stage1.setOpacity(0.8);// from þeffalýðýný ayarlama
			stage1.setTitle("MERHABA ÝSTE");// form baþlýk atama
			stage1.centerOnScreen();// ekranýn ortasýnda görüntüleme
			  //*********************Form gösterim Biçimleri.**********************
			stage1.initStyle(StageStyle.DECORATED);//varsýyýlan yapý
			stage1.initStyle(StageStyle.UNDECORATED);// menü tuþlarý olmadan gösterim saðlama
			stage1.initStyle(StageStyle.TRANSPARENT);// transparan görünmesini saðlamak
			stage1.initStyle(StageStyle.UNIFIED);//varsayýlan
			stage1.initStyle(StageStyle.UTILITY);//sadece kapama butonu
			stage1.getIcons().add(new Image(getClass().getResourceAsStream("a.png")));
			stage1.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnÝc_click(ActionEvent event) {
    	try {
    		AnchorPane panel= (AnchorPane) FXMLLoader.load(getClass().getResource("FormUyg2.fxml"));
    		anchorSag.getChildren().setAll(panel);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    }

    @FXML
    void initialize() {
        

    }
}
