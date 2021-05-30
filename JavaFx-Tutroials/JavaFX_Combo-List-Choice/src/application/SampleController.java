package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> combo1;
    //<?> olan yerlere degerlerle calisilacagi icin <String> yazildi

    @FXML
    private TextField txt1;

    @FXML
    private Button btn1;

    @FXML
    private ChoiceBox<String> choice1;
    //<?> olan yerlere degerlerle calisilacagi icin <String> yazildi

    @FXML
    private TextField txt2;

    @FXML
    private Button btn2;

    @FXML
    private ListView<String> list1;
    //<?> olan yerlere degerlerle calisilacagi icin <String> yazildi

    @FXML
    private TextField txt3;

    @FXML
    private Button btn3;

    @FXML
    void btn1_Action(ActionEvent event) {
    	//Txt1 bilesenine yazili degeri combobox'a ekler
    	combo1.getItems().add(txt1.getText());
    }

    @FXML
    void btn2_Action(ActionEvent event) {

    }

    @FXML
    void btn3_Action(ActionEvent event) {
    	//Listede birden fazla secilen degerleri alma
		ObservableList<String> icerik2;		
		icerik2=list1.getSelectionModel().getSelectedItems();
		//Listede birden fazla secilen degerin indislerini cekme
		ObservableList<Integer> indisler;
		indisler=list1.getSelectionModel().getSelectedIndices();
		
		//Secilen indislerle islem yapma
		for(int aa: indisler)
			System.out.println(aa);
		//Secilen degerlerle islem yapma
		for(String deger: icerik2)
			System.out.println(deger);
			
    }

    @FXML
    void combo_Action(ActionEvent event) {
    	//Combobox secimi degisince tetiklenecek islem
    	System.out.println( combo1.getSelectionModel().getSelectedItem());
    }

    @FXML
    void initialize() {
    		//Combobox icerisine seciniz... ekleme
    		combo1.setPromptText("Seçiniz");
    		//Dizi kullanarak comboboxa deger atama
    		String[] dizi= {"Deneme1", "Deneme2", "Deneme3"};
    		combo1.getItems().addAll(dizi);
    		//Comboboxa tek satirlik deger atama
    		combo1.getItems().add("Merhaba");
    		//Comboboxa dogrudan coklu aktarim yapma
    		combo1.getItems().addAll("İSTE","İskenderun", "Hatay"); 
    		
    		//ObservedList kullanarak (VT kisminda kullanilacak) deger atama 
    		ObservableList<String> icerik=FXCollections.observableArrayList("Değer1", "Değer2", "Değer3");
    		combo1.getItems().addAll(icerik);
    		//Ayni ekleme ve silme komutlari choiceBox, ComboBox, ListView icin gecerlidir
    		choice1.getItems().addAll(icerik);
    		list1.getItems().addAll(icerik);
    		
    		//Combobox 2 nolu indexe deger atama
    		combo1.getItems().add(2,"***********");
    		//Comboboxtan belirli bir indisteki degeri silme
    		combo1.getItems().remove(3);
    		//Comboboxtan bir degerin silinmesi
    		combo1.getItems().remove("Deneme1");
    		//Comboboxtan toplu deger silme
    		combo1.getItems().removeAll("Değer2","Değer3");
    		
    		//Comboboxta bir indisteki degeri alma
    		System.out.println(combo1.getItems().get(3));  
    		//Comboboxtan "İskenderun" degerinin kacinci indiste oldugunu alma
    		System.out.println(combo1.getItems().indexOf("İskenderun"));
    		
    		//Comboboxin iceriklerinin duzenlebilir olmasini saglar
    		combo1.setEditable(true);
    		
    		//Listviewin birden fazla deger secilmesini saglar
    		list1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    		
    		//Listede seçili olan değerin
    		list1.getSelectionModel().getSelectedItem();
    		//Listede seçilen değerin kaçııncuı indekste olduğunu verir
    		list1.getSelectionModel().getSelectedIndex();
    		//Listeview içerisinde 3.indeksi seç
    		list1.getSelectionModel().select(3);
    		//Lİsteviewda son indexe gitme
    		list1.getSelectionModel().selectLast();
    		//Listview icerisindeki ilk kaydi secer
    		list1.getSelectionModel().selectFirst();
    		//Listview icerinde secili olandan sonraki kaydi secme
    		list1.getSelectionModel().selectNext();
    		//Listview icerisinde secili kayittan bir onceki kaydi secer
    		list1.getSelectionModel().selectPrevious();
   
    		
    		
    		
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
