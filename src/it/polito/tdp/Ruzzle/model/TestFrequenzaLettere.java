package it.polito.tdp.Ruzzle.model;

import java.util.Map;
import java.util.Map.Entry;

import it.polito.tdp.Ruzzle.db.DizionarioDAO;

public class TestFrequenzaLettere {
	
	


	public static void main(String[] args) {
		
		DizionarioDAO dao = new DizionarioDAO();

		FrequenzaLettera fl = new FrequenzaLettera();
		Map<Character, Double> frequenzeLettere = fl.calcolaFrequenza(dao.listParola());
		
		for(Entry <Character, Double>  entry : frequenzeLettere.entrySet()) {
			
			System.out.println("Lettera: "+entry.getKey()+" con frequenza "+entry.getValue());
			
		}

	}

}
