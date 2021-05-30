package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Spinner<Integer> spin1;

    @FXML
    private Spinner<String> spin2;

    @FXML
    private Spinner<Integer> spin3;

    @FXML
    private Spinner<Integer> spin4;

    @FXML
    private Spinner<Integer> spin5;

    @FXML
    private Spinner<Integer> spin6;

    @FXML
    private Spinner<Double> spin7;

    @FXML
    private Spinner<String> spin8;

    @FXML
    private Slider slider1;

    @FXML
    private Slider slider2;

    @FXML
    private Label lbl1;

    @FXML
    void initialize() {
    	int secilen=3;
    	//Spinnera integer deger atama 1 ile 5 arasinda 3 secili olarak gelir
    	SpinnerValueFactory<Integer> deger1=new  //
    			SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, secilen);
    	spin1.setValueFactory(deger1);
    	
    	//Spinnera String deger atama
		ObservableList<String> aylar=FXCollections.observableArrayList("Ocak", "Şubat", "Mart", "Nisan");
		SpinnerValueFactory<String> deger2=new ListSpinnerValueFactory<String>(aylar);
		
    	deger2.setValue("Deneme");
    	spin2.setValueFactory(deger2);
    	
    	//Spinner goruntuleme turleri Oklar solda yatay
    	SpinnerValueFactory<Integer> deger3=new  //
    			SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, secilen);
    	spin3.setValueFactory(deger3);
    	spin3.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL);
		
    	//Spinner goruntuleme turleri Oklar solda dikey
    	SpinnerValueFactory<Integer> deger4=new  //
    			SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, secilen);
    	spin4.setValueFactory(deger4);
    	spin4.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL);
    	
    	//Spinner goruntuleme turleri Oklar Yukarda asagida
    	SpinnerValueFactory<Integer> deger5=new  //
    			SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, secilen);
    	spin5.setValueFactory(deger5);
    	spin5.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
    	
    	SpinnerValueFactory<Integer> deger6=new  //
    			SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, secilen);
    	spin6.setValueFactory(deger6);
    	spin6.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);
    	
    	//Spinnera Double deger atama 1.1 ile 5.7 arasinda 1.3 secili, 0.1 artarak gider
    	SpinnerValueFactory<Double> deger7=new  //
    			SpinnerValueFactory.DoubleSpinnerValueFactory(1.1, 5.7, 1.3, 0.1);
    	spin7.setValueFactory(deger7);
    	
    	
    	ObservableList<String> isimler=FXCollections.observableArrayList("Ahmet", "Seyit", "Ayşe", "Hatice");
		SpinnerValueFactory<String> deger8=new ListSpinnerValueFactory<String>(isimler);
		
		spin8.setValueFactory(deger8);
		
		//Spinner a Lambda idafesiyle listener atanmasi
		spin8.valueProperty().addListener(
				(obs, oldValue, newValue)-> System.out.println("Spinner yeni değeri:"+newValue)
				);
		
		//Slider max ve min degerleri belirleme
		slider1.setMax(75);
		slider1.setMin(15);
		
		//Slider goruntulemede olceklerin belirlenmesi
		slider1.setShowTickLabels(true);
		slider1.setShowTickMarks(true);
		//Her 5 degerde bir olcekleme ayarlamasi
		slider1.setMajorTickUnit(5);
		//Blok artirma degeri
		slider1.setBlockIncrement(10);
		
		//Slidera ChangeListener ile change kontrolu atanmasi
		slider1.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observed, Number oldValue, Number newValue) {
				System.out.println("Slider Yatay Degeri:"+ newValue);
				lbl1.setText("Slider Yatay Degeri:"+ newValue);
				
			}
		});
		
		//Slidera lambda ifadesiyle listener atanmasi
		slider2.valueProperty().addListener(
				
				(obs, OldValue, newValue)-> 
				{
					System.out.println("Slider Diker Deger:"+newValue);
					lbl1.setText("Slider Dikey Deger:"+newValue);
				}
				
				);
		   	

    }
}
