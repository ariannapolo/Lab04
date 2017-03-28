package it.polito.tdp.lab04.model;

public class Corso {

	private String codice;
	private int crediti;
	private String nome;
	private int periodo;
	
	public Corso(String codice, int crediti, String nome, int periodo) {
		this.codice = codice;
		this.crediti = crediti;
		this.nome = nome;
		this.periodo = periodo;
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
	
	
	
}
