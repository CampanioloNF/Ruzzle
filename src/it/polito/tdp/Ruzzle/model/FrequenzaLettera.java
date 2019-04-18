package it.polito.tdp.Ruzzle.model;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FrequenzaLettera {

	
	public Map <Character, Double> calcolaFrequenza(List<String> dizionario){
		
    Map<Character, Integer> frequenzeLettere = new TreeMap <Character, Integer>();
    Map<Character, Double> probabilita = new TreeMap <Character, Double>();
    
    for(char c = 'A'; c<='Z'; c++) {
    	frequenzeLettere.put(c, 0);
    }
    
    int lettereTot = 0;
    
    for(String s : dizionario) {
    	
    	s = s.toUpperCase();
    	
    	for(Character ch : s.toCharArray()) {
    		for(Character cm : frequenzeLettere.keySet()) {
    			if(ch==cm) {
    				
    				int prima = frequenzeLettere.get(cm);
    				frequenzeLettere.put(cm, prima+1);
    				lettereTot++;
    				
    			}
    			    
    		}
    	}
    	
    }
    
    for(Character c : frequenzeLettere.keySet()) {
    	
    	double prob = (frequenzeLettere.get(c)*1000/lettereTot);
    	probabilita.put(c, prob);
    }
    
    return probabilita;
    
		}
	

}
