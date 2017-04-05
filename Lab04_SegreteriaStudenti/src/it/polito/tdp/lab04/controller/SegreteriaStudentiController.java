package it.polito.tdp.lab04.controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

	private Model model;
	List<Corso> corsi = new LinkedList<Corso>();

	@FXML
	private ComboBox<Corso> comboCorso;

	@FXML
	private Button btnCercaIscrittiCorso;

	@FXML
	private Button btnCercaCorsi;

	@FXML
	private Button btnCercaNome;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnIscrivi;

	@FXML
	private TextField txtMatricola;

	@FXML
	private Button btnReset;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCognome;

	public void setModel(Model model) {
		this.model = model;
		LinkedList<Corso> corsi = new LinkedList<Corso>();
		CorsoDAO d = new CorsoDAO();
		corsi.addAll(d.getTuttiICorsi());
		corsi.add(new Corso("", 0, "", 0));
		this.comboCorso.getItems().addAll(corsi);

	}

	@FXML
	void doReset(ActionEvent event) {
		this.txtCognome.clear();
		this.txtMatricola.clear();
		this.txtNome.clear();
		this.txtResult.clear();

	}

	@FXML
	void doCercaNome(ActionEvent event) {
		try{
		int matricola = Integer.parseInt(txtMatricola.getText().trim());
		Studente s = model.getStudente(matricola);
		if(s.getCognome()==null){
			txtResult.setText("Studente non presente!");
		}
		txtNome.setText(s.getNome());
		txtCognome.setText(s.getCognome());
		}catch(NumberFormatException nfe ){
			txtResult.setText("Formato matricola errato.");
		}

	}

	@FXML
	void doCercaIscrittiCorso(ActionEvent event) {
		Corso c = comboCorso.getValue();
		
		for(Studente s : model.getStudentiIscritti(c))
			txtResult.appendText(s.toString()+"\n");

	}

	@FXML
	void doCercaCorsi(ActionEvent event) {
		try{
			int matricola = Integer.parseInt(txtMatricola.getText().trim());
			Studente s = model.getStudente(matricola);
			if(s.getCognome()==null){
				txtResult.setText("Studente non presente nel database");
				return;
			}
			for(Corso c : model.getCorsiIscritto(s))
				txtResult.appendText(c.getCodice()+" "+c.getCrediti()+" "+c.getNome()+" "+c.getPeriodo()+"\n");
			
			}catch(NumberFormatException nfe ){
				txtResult.setText("Formato matricola errato.");
			}

	}

	@FXML
	void doIscrivi(ActionEvent event) {
		int matricola = Integer.parseInt(txtMatricola.getText().trim());
		if(model.iscriviStudenteACorso(model.getStudente(matricola), comboCorso.getValue())){
			txtResult.setText("Studente già iscritto a questo corso.");
		}else{
			if(model.iscrizione(model.getStudente(matricola), comboCorso.getValue()))
				txtResult.setText("Studente iscritto!");
		}

	}

	@FXML
	void initialize() {
		assert comboCorso != null : "fx:id=\"comboCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	}
	

}
