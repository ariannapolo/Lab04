package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.*;

public class TestDAO {

	public static void main(String[] args) {
		StudenteDAO sdao = new StudenteDAO();
		CorsoDAO cdao = new CorsoDAO();
		
		Studente s = new Studente(146101, null, null, null);
		sdao.getStudente(s);
		Corso c = new Corso("01OVYPG", 0, null,0);
		cdao.getCorso(c);
		System.out.println(c +";"+ s);
		if(cdao.inscriviStudenteACorso(s, c))
			System.out.println("studente già iscritto");
		else{
			System.out.println("Studente da iscrivere");
			System.out.println(cdao.iscrizione(s, c));
		}
			
	}

}
