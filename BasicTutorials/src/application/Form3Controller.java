package application;

import java.net.URL;

import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class Form3Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Spinner<Integer> spinner1;

    @FXML
    private Spinner<String> spinner2;

    @FXML
    private Spinner<Integer> spinner3;

    @FXML
    private Spinner<Integer> spinner4;

    @FXML
    private Spinner<Integer> spinner5;

    @FXML
    private Spinner<Integer> spinner6;

    @FXML
    private Spinner<Double> spinner7;

    @FXML
    private Spinner<String> spinner8;

    @FXML
    private Slider slidery;

    @FXML
    private Slider sliderd;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Button btn;

    @FXML
    void btn_click(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	int secilen=3;
    	SpinnerValueFactory<Integer> deger1=new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5,secilen);// spinnera at�lacak de�erleri ve spinnerda se�ilecek de�erler
    	spinner1.setValueFactory(deger1);
    	
    	ObservableList<String> aylar=FXCollections.observableArrayList("Ocak","�ubat","Mart","Nisan","May�s");
    	SpinnerValueFactory<String> deger2=new SpinnerValueFactory.ListSpinnerValueFactory<String>(aylar);// spinnera at�lacak de�erler spinnervalue faktory e al�nmak zorundad�r
    	deger2.setValue("Deneme");// observableliste veri ekleme
    	spinner2.setValueFactory(deger2);
    	 //spinner2.setEditable(true); // editable �zelli�ini a�ma
    	SpinnerValueFactory<Integer> deger3=new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5);
    	
    	SpinnerValueFactory<Double> deger4=new SpinnerValueFactory.DoubleSpinnerValueFactory(1.1, 5.7,1.3,0.1);//1.1 ile 5.7 aras�nda 1.3 se�i olacak ve 0.1 art�� miktar� olacak
    	// spinner g�r�nt� i�lemleri
    	spinner3.setValueFactory(deger3);
    	spinner3.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL);
    	
    	spinner4.setValueFactory(deger3);
    	spinner4.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
    	
    	spinner5.setValueFactory(deger3);
    	spinner5.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);
    
    	spinner6.setValueFactory(deger3);
    	spinner6.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL);
    	
    	spinner7.setValueFactory(deger4);
    	spinner7.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_RIGHT_HORIZONTAL);
    	
    	spinner8.setValueFactory(deger2);
    	
    	spinner8.valueProperty().addListener(
    			(obs,oldValue,newValue)-> System.out.println("Spinner eski De�er"+oldValue +"Spinner Yeni De�er"+ newValue)
    			);// Listener Olu�turma
    	
    	slidery.setMax(75);
    	slidery.setMin(15);
    	slidery.setShowTickLabels(true);
    	slidery.setShowTickMarks(true);
    	slidery.setMajorTickUnit(5);// artt�rma de�eri
    	slidery.setBlockIncrement(10);//block artt�rma de�eri
    	
    	/*slidery.valueProperty().addListener(
    			new ChangeListener<Number>() {
    			 public void changed(javafx.beans.value.ObservableValue<? extends Number> obs0, Number oldValue, Number newValue) {
    				 
    				 System.out.println("Slider yeni De�eri "+newValue);
    				 
    				 
    				 
    				 lbl1.setText("Yeni De�er: "+String.format("%.2f",newValue));//String.format fonk. ile stringe gelecek olan say�n�n format� d�zenlebebilir.
    				 lbl2.setText("Eski De�er: "+String.format("%.2f",oldValue));
    			 };
			
    			
    			});*/
    	
    	slidery.valueProperty().addListener(
    			(obs,oldValue,newValue)-> {lbl1.setText("Eski De�er: "+String.format("%.2f", oldValue));
    			lbl2.setText("Yeni De�er:"+String.format("%.2f", newValue));
    			
    			}
    			);
    	
    	
    
    
    	
        
    }
}
