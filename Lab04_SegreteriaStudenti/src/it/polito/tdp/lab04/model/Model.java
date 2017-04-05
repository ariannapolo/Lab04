package it.polito.tdp.lab04.model;

import java.util.LinkedList;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	public Model(){
		
	}
	
	public Studente getStudente(int matricola){
		Studente s = new Studente(matricola, null, null, null);
		StudenteDAO dao = new StudenteDAO();
		dao.getStudente(s);
		return s;
				
	}
	
	public LinkedList<Studente> getStudentiIscritti(Corso c){
		CorsoDAO dao = new CorsoDAO();
		dao.getStudentiIscrittiAlCorso(c);
		return c.getIscritti();
		
	}
	
	public LinkedList<Corso> getCorsiIscritto(Studente s){
		StudenteDAO dao = new StudenteDAO();
		dao.getCorsiIscritto(s);
		return s.getCorsiIscritto();
		
	}
	
	public boolean iscriviStudenteACorso(Studente studente, Corso corso){
		CorsoDAO dao = new CorsoDAO();
		return dao.inscriviStudenteACorso(studente, corso);
		
	}
	
	public boolean iscrizione(Studente studente, Corso corso){
		CorsoDAO dao = new CorsoDAO();
		return dao.iscrizione(studente, corso);
	}

}
