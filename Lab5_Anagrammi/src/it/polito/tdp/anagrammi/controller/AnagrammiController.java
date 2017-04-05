package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	Model model = new Model();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnAnagramma;

    @FXML
    private TextArea txtCorrette;

    @FXML
    private TextArea txtErrate;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagramma(ActionEvent event) {
    	String parola = txtParola.getText();
    	Map <String, Boolean> parole = model.anagramma(parola);
    	for (String s : parole.keySet()){
    		if (parole.get(s)==true)
    			txtCorrette.appendText(s+"\n");
    		else
    			txtErrate.appendText(s+"\n");}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtCorrette.clear();
    	txtErrate.clear();
    	model.reset();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnAnagramma != null : "fx:id=\"btnAnagramma\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorrette != null : "fx:id=\"txtCorrette\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErrate != null : "fx:id=\"txtErrate\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}
