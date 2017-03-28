package it.polito.tdp.lab04.model;

public class Studente {
	
	private int matricola;
	private String nome;
	private String cognome;
	private String corsoDiStudi;
	
	public Studente(int matricola, String nome, String cognome, String corsoDiStudi) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.corsoDiStudi = corsoDiStudi;
	}

	/**
	 * @return the matricola
	 */
	public int getMatricola() {
		return matricola;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @return the corsoDiStudi
	 */
	public String getCorsoDiStudi() {
		return corsoDiStudi;
	}
	
	
	
}
