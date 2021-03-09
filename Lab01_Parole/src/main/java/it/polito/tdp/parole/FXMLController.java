package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextField txttempoesecuzione;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	double inizio = System.nanoTime();
    	String parola=txtParola.getText();
    	elenco.addParola(parola);
    	this.txtParola.clear();
    	this.txtResult.clear();
    	for(String p:elenco.getElenco())
    		this.txtResult.appendText(p+"\n");
    	
    	double fine=System.nanoTime();
    	this.txttempoesecuzione.setText(""+(fine-inizio));
    }

    @FXML
    void doReset(ActionEvent event) {
    	double inizio = System.nanoTime();
    	this.txtResult.clear();
    	this.elenco.reset();
    	String t=Long.toString(System.nanoTime());
    	this.txttempoesecuzione.setText(t);
    	
    	double fine=System.nanoTime();
    	this.txttempoesecuzione.setText(""+(fine-inizio));
    }
    

    @FXML
    void CancellaParola(ActionEvent event) {
    	double inizio = System.nanoTime();
    	String elimina=this.txtResult.getSelectedText();
    	elenco.removeParola(elimina);
    	
    	this.txtResult.clear();
    	for(String p:elenco.getElenco())
    		this.txtResult.appendText(p+"\n");
    	String t=Long.toString(System.nanoTime());
    	this.txttempoesecuzione.setText(t);
    	
    	double fine=System.nanoTime();
    	this.txttempoesecuzione.setText(""+(fine-inizio));
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txttempoesecuzione != null : "fx:id=\"txttempoesecuzione\" was not injected: check your FXML file 'Scene.fxml'.";
        elenco = new Parole() ;
    }
}
