package application;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;

public class Form2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt1;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private ListView<String> lst1;

    @FXML
    private Button btn;

    @FXML
    private Label lblSonuc;

    @FXML
    private Button btnGetir;

    @FXML
    void btnGetir_click(ActionEvent event) {
    	comboBox.getItems().add(txt1.getText());
    	ObservableList<String> icerik;
    	icerik=lst1.getSelectionModel().getSelectedItems();
    	for (String i : icerik) {
			System.out.println(i);
		}
    	ObservableList<Integer> indisler;
    	indisler=lst1.getSelectionModel().getSelectedIndices();
    	for (int i : indisler) {
			System.out.println(i);
		}
    }

    @FXML
    void btn_click(ActionEvent event) {
    	
    	
    }

    @FXML
    void comboBox_Action(ActionEvent event) {
    	comboBox.getItems().clear();// t�m�n� temizler 
    	comboBox.getItems().remove(2);// belirli indisi siler
    	comboBox.getItems().remove("Deneme1");// belirli itemi siler
    	comboBox.getItems().remove("Dizi silme i�lemide yap�labilir");// Dizilerin i�erisindeki de�erler komple silinebilir.
    	lblSonuc.setText(comboBox.getSelectionModel().getSelectedItem());//se�ilen itemi labale yazd�rma
    	lblSonuc.setText(String.valueOf(comboBox.getSelectionModel().getSelectedIndex()));
    	System.out.println(comboBox.getItems().get(2));
    	System.out.println(comboBox.getItems().indexOf("Deneme1")); // de�er arama fakat ilk indisi getirir.
    	System.out.println(comboBox.getItems().lastIndexOf("Deneme1"));// de�er arama fakat son indisi getirir.

    }

    @FXML
    void initialize() {
        
comboBox.setPromptText("De�er Se�iniz");
String[] dizi= {"Deneme1","Deneme2","Deneme3"};
comboBox.getItems().addAll(dizi);
comboBox.getItems().add(1,"�ste....");// araya ekleme i�lemi
comboBox.setVisibleRowCount(5); // ka� tane itemin ilk ba�ta g�sterilece�i

ObservableList<String> dizi2=FXCollections.observableArrayList("de�er1","de�er2","de�er3");
comboBox.getItems().addAll(dizi2);
lst1.getItems().addAll(dizi2);

lst1.getSelectionModel().getSelectedItem(); //listede se�ili olan itemi getirir
lst1.getSelectionModel().getSelectedIndex(); // se�ili olan itemin indexini verir
lst1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // listede se�imi �oklu olarak ayarlar
lst1.getSelectionModel().getSelectedIndices();// 1 den fazla se�imi yap�lanlar�n indexlerini getirir.
lst1.getSelectionModel().getSelectedItems();// 1 den fazla se�imi yap�lar�nlar�n itemini getirir.
lst1.getSelectionModel().select(2);// indexi 2 olan item se�ili olarak gelir
lst1.getSelectionModel().selectAll();// itemlar�n hepsi se�ili halde gelir.
lst1.getSelectionModel().selectFirst();// 1. item se�ili olarak gelir.
lst1.getSelectionModel().selectLast();// son item se�ili olarak gelir.
lst1.getSelectionModel().selectNext();// bir sonrakini se�er.
lst1.getSelectionModel().selectPrevious();// bir �ncekini se�er
lst1.getSelectionModel().selectRange(0, 5);// belirli indexler aras� se�imler yapar
lst1.getSelectionModel().clearSelection();// se�ileni siler

}
}
