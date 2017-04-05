package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public void getStudente(Studente studente){
		
		String sql = "SELECT matricola, cognome, nome, CDS FROM studente WHERE matricola = ?";
		try{
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,studente.getMatricola());
			
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setCorsoDiStudi(rs.getString("CDS"));
			}
			
			//conn.close();
			
		}catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}
	
	public void getCorsiIscritto(Studente s){
		
		String sql = "SELECT codins FROM iscrizione WHERE matricola = ?";
		
		try{
				Connection conn = ConnectDB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setInt(1, s.getMatricola());

				ResultSet rs = st.executeQuery();
				
				while(rs.next()){
					Corso c = new Corso(rs.getString("codins"),0,null,0);
					CorsoDAO dao = new CorsoDAO();
					dao.getCorso(c);
					s.aggiungiCorso(c);
				}
				//conn.close();

			
		}catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		
		
	}



}
