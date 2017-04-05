package it.polito.tdp.lab04.model;

import java.util.LinkedList;

public class Studente {
	
	private int matricola;
	private String nome;
	private String cognome;
	private String corsoDiStudi;
	private LinkedList<Corso> corsiIscritto;
	
	public Studente(int matricola, String nome, String cognome, String corsoDiStudi) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.corsoDiStudi = corsoDiStudi;
		corsiIscritto = new LinkedList<Corso>();
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

	/**
	 * @param matricola the matricola to set
	 */
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @param corsoDiStudi the corsoDiStudi to set
	 */
	public void setCorsoDiStudi(String corsoDiStudi) {
		this.corsoDiStudi = corsoDiStudi;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return matricola + "   " + nome +"   "+ cognome + "   "
				+ corsoDiStudi;
	}
	
	
	public void aggiungiCorso(Corso c){
		corsiIscritto.add(c);
	}

	/**
	 * @return the corsiIscritto
	 */
	public LinkedList<Corso> getCorsiIscritto() {
		return corsiIscritto;
	}
	
	
}
