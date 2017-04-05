package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.*;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				// Crea un nuovo JAVA Bean Corso
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				// Aggiungi il nuovo Corso alla lista
				corsi.add(c);
			}

			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso 
	 */
	public void getCorso(Corso corso) {
		// TODO
		String sql = "SELECT codins, crediti, nome, pd "+
					"FROM corso "+
					"WHERE codins = ? ";	
			
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso.getCodice());

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				//Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				corso.setCrediti(rs.getInt("crediti"));
				corso.setNome(rs.getString("nome"));
				corso.setPeriodo(rs.getInt("pd"));
			}
//			conn.close();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public void getStudentiIscrittiAlCorso(Corso corso) {
		// TODO
		String sql = "SELECT matricola "+
				"FROM iscrizione "+
				"WHERE codins = ? ";	
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso.getCodice());

			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				Studente s = new Studente(rs.getInt("matricola"),null, null, null);
				StudenteDAO dao = new StudenteDAO();
				dao.getStudente(s);
				corso.aggiungiIscritti(s);
			}
			//conn.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		
	}

	/*
	 * Data una matricola ed il codice insegnamento,
	 * iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		String sql = "SELECT matricola, codins FROM iscrizione WHERE matricola = ? AND codins = ?";
		boolean iscritto = false;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, studente.getMatricola());
			st.setString(2, corso.getCodice());
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				iscritto = true;
			}else{
				//da iscrivere
				//String sql1 = "INSERT INTO `iscritticorsi`.`iscrizione` ('matricola','codins') VALUES (?, ?)";
				//this.iscrizione(studente, corso);
			}
				
			
		}catch(SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		
		return iscritto;
	}
	
	public boolean iscrizione(Studente s, Corso c){
		//String matricola = "SELECT * FROM studente WHERE matricola = ?";
		//String corso = "SELECT * FROM corso WHERE codins = ?";
		String sql = "INSERT INTO iscrizione (matricola, codins) VALUES (?, ?)";
		boolean iscritto = false;
	
		try {
			Connection conn = ConnectDB.getConnection();
			
			//PreparedStatement st = conn.prepareStatement(matricola);
			//PreparedStatement st1 = conn.prepareStatement(corso);
			PreparedStatement st2 = conn.prepareStatement(sql);
			
			
			st2.setInt(1, s.getMatricola());
			st2.setString(1, c.getCodice());
			
			//ResultSet rs = st.executeQuery(matricola);
			//ResultSet rs2 = st1.executeQuery(corso);
			//st2.setInt(1, rs.getInt("matricola"));
			//st2.setString(2, rs2.getString("codins"));
			
			int result = st2.executeUpdate(sql);
			if(result ==1){
				iscritto = true;
				s.aggiungiCorso(c);
				c.aggiungiIscritti(s);
				
			}else
				iscritto = false;
			
			//conn.close();
		}catch(SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		return iscritto;
	}
	
	
}
