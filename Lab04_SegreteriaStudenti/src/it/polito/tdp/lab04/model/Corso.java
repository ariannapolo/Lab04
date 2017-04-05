package it.polito.tdp.lab04.model;

import java.util.LinkedList;

public class Corso {

	private String codice;
	private int crediti;
	private String nome;
	private int periodo;
	private LinkedList<Studente> iscritti;
	
	public Corso(String codice, int crediti, String nome, int periodo) {
		this.codice = codice;
		this.crediti = crediti;
		this.nome = nome;
		this.periodo = periodo;
		iscritti = new LinkedList<Studente>();
	}
	
	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}
	/**
	 * @return the crediti
	 */
	public int getCrediti() {
		return crediti;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @return the periodo
	 */
	public int getPeriodo() {
		return periodo;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @param crediti the crediti to set
	 */
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nome;
	}
	
	public void aggiungiIscritti(Studente studente){
		iscritti.add(studente);
	}

	/**
	 * @return the iscritti
	 */
	public LinkedList<Studente> getIscritti() {
		return iscritti;
	}
	
	
	
	
	
}
