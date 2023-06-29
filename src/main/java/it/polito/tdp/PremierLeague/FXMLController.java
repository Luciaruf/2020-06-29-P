/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.PremierLeague;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.PremierLeague.model.Match;
import it.polito.tdp.PremierLeague.model.Match;
import it.polito.tdp.PremierLeague.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	Graph<Match, DefaultWeightedEdge> graph;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCreaGrafo"
    private Button btnCreaGrafo; // Value injected by FXMLLoader

    @FXML // fx:id="btnConnessioneMassima"
    private Button btnConnessioneMassima; // Value injected by FXMLLoader

    @FXML // fx:id="btnCollegamento"
    private Button btnCollegamento; // Value injected by FXMLLoader

    @FXML // fx:id="txtMinuti"
    private TextField txtMinuti; // Value injected by FXMLLoader

    @FXML // fx:id="cmbMese"
    private ComboBox<String> cmbMese; // Value injected by FXMLLoader

    @FXML // fx:id="cmbM1"
    private ComboBox<?> cmbM1; // Value injected by FXMLLoader

    @FXML // fx:id="cmbM2"
    private ComboBox<?> cmbM2; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doConnessioneMassima(ActionEvent event) {
    	List <DefaultWeightedEdge> result = this.model.listaArchi();
    	
    	for(DefaultWeightedEdge e : result) {
    		txtResult.appendText("\n connessione massima: " + this.graph.getEdgeWeight(e) +" match 1: "+ this.graph.getEdgeSource(e).getMatchID() +" match 2: "+ this.graph.getEdgeTarget(e).getMatchID()+"\n");
    	}
    }

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	
    	String minutitxt = this.txtMinuti.getText();
    	
    	int minuti = Integer.parseInt(minutitxt);
    	
    	String meseTxt = cmbMese.getValue();
    	
    	int mese = 0;
    	
    	if( meseTxt.compareTo("Gennaio")==0) {
    		mese = 1;
    	}
    	else if(meseTxt.compareTo("Febbraio")==0) {
    		mese = 2;
    	}
    	else if(meseTxt.compareTo("Marzo")==0) {
    		mese = 3;
    	}
    	else if(meseTxt.compareTo("Aprile")==0) {
    		mese = 4;
    	}
    	else if(meseTxt.compareTo("Maggio")==0) {
    		mese = 5;
    	}
    	else if(meseTxt.compareTo("Giugno")==0) {
    		mese = 6;
    	}
    	else if(meseTxt.compareTo("Luglio")==0) {
    		mese = 7;
    	}
    	else if(meseTxt.compareTo("Agosto")==0) {
    		mese = 8;
    	}
    	else if(meseTxt.compareTo("Settembre")==0) {
    		mese = 9;
    	}
    	else if(meseTxt.compareTo("Ottobre")==0) {
    		mese = 10;
    	}
    	else if(meseTxt.compareTo("Novembre")==0) {
    		mese = 11;
    	}
    	else if(meseTxt.compareTo("Dicembre")==0) {
    		mese = 12;
    	}
    	
    	this.graph = this.model.creaGrafo(mese, minuti);
    	
    	txtResult.appendText("il numero di vertici è: "+this.graph.vertexSet().size()+ "\n"+"il numero di archi è: "+this.graph.edgeSet().size());
    	
    	
    }

    @FXML
    void doCollegamento(ActionEvent event) {
    	
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnConnessioneMassima != null : "fx:id=\"btnConnessioneMassima\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCollegamento != null : "fx:id=\"btnCollegamento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMinuti != null : "fx:id=\"txtMinuti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbMese != null : "fx:id=\"cmbMese\" was not injected: check your FXML file 'Scene.fxml'.";        assert cmbM1 != null : "fx:id=\"cmbM1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbM2 != null : "fx:id=\"cmbM2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	
    	this.cmbMese.getItems().add("Gennaio");
    	this.cmbMese.getItems().add("Febbraio");
    	this.cmbMese.getItems().add("Marzo");
    	this.cmbMese.getItems().add("Aprile");
    	this.cmbMese.getItems().add("Maggio");
    	this.cmbMese.getItems().add("Giugno");
    	this.cmbMese.getItems().add("Luglio");
    	this.cmbMese.getItems().add("Agosto");
    	this.cmbMese.getItems().add("Settembre");
    	this.cmbMese.getItems().add("Ottobre");
    	this.cmbMese.getItems().add("Novembre");
    	this.cmbMese.getItems().add("Dicembre");
    	
  
    }
    
    
}
