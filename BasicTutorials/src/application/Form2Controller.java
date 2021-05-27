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
    	comboBox.getItems().clear();// tümünü temizler 
    	comboBox.getItems().remove(2);// belirli indisi siler
    	comboBox.getItems().remove("Deneme1");// belirli itemi siler
    	comboBox.getItems().remove("Dizi silme iþlemide yapýlabilir");// Dizilerin içerisindeki deðerler komple silinebilir.
    	lblSonuc.setText(comboBox.getSelectionModel().getSelectedItem());//seçilen itemi labale yazdýrma
    	lblSonuc.setText(String.valueOf(comboBox.getSelectionModel().getSelectedIndex()));
    	System.out.println(comboBox.getItems().get(2));
    	System.out.println(comboBox.getItems().indexOf("Deneme1")); // deðer arama fakat ilk indisi getirir.
    	System.out.println(comboBox.getItems().lastIndexOf("Deneme1"));// deðer arama fakat son indisi getirir.

    }

    @FXML
    void initialize() {
        
comboBox.setPromptText("Deðer Seçiniz");
String[] dizi= {"Deneme1","Deneme2","Deneme3"};
comboBox.getItems().addAll(dizi);
comboBox.getItems().add(1,"Ýste....");// araya ekleme iþlemi
comboBox.setVisibleRowCount(5); // kaç tane itemin ilk baþta gösterileceði

ObservableList<String> dizi2=FXCollections.observableArrayList("deðer1","deðer2","deðer3");
comboBox.getItems().addAll(dizi2);
lst1.getItems().addAll(dizi2);

lst1.getSelectionModel().getSelectedItem(); //listede seçili olan itemi getirir
lst1.getSelectionModel().getSelectedIndex(); // seçili olan itemin indexini verir
lst1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // listede seçimi çoklu olarak ayarlar
lst1.getSelectionModel().getSelectedIndices();// 1 den fazla seçimi yapýlanlarýn indexlerini getirir.
lst1.getSelectionModel().getSelectedItems();// 1 den fazla seçimi yapýlarýnlarýn itemini getirir.
lst1.getSelectionModel().select(2);// indexi 2 olan item seçili olarak gelir
lst1.getSelectionModel().selectAll();// itemlarýn hepsi seçili halde gelir.
lst1.getSelectionModel().selectFirst();// 1. item seçili olarak gelir.
lst1.getSelectionModel().selectLast();// son item seçili olarak gelir.
lst1.getSelectionModel().selectNext();// bir sonrakini seçer.
lst1.getSelectionModel().selectPrevious();// bir öncekini seçer
lst1.getSelectionModel().selectRange(0, 5);// belirli indexler arasý seçimler yapar
lst1.getSelectionModel().clearSelection();// seçileni siler

}
}
