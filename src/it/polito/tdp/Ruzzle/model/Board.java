package it.polito.tdp.Ruzzle.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Memorizza le lettere presenti nella scacchiera Ruzzle.
 * @author Fulvio
 *
 */
public class Board {
	private List<Pos> positions;
	private Map<Pos, StringProperty> cells; //Mappano la posizione delle celle 
	//Data la posizione mi definice la StringProperty per aggiornare simultaneamente l'interfaccia utente (dettaglio UI)
	
    private int size;

	/**
	 * Crea una nuova scacchiera della dimensione specificata
	 * @param size
	 */
	public Board(int size) {
		this.size = size;

		//costruisce una lista con tutte le posizioni (positions)
		this.positions = new ArrayList<>();
		for (int row = 0; row < this.size; row++) {
			for (int col = 0; col < this.size; col++) {
				this.positions.add(new Pos(row, col));
			}
		}

		this.cells = new HashMap<>();

		for (Pos p : this.positions) { // bisogna creare la stringProperty
			this.cells.put(p, new SimpleStringProperty());
		}
	}
	
	/**
	 * Fornisce la {@link StringProperty} corrispondente alla {@link Pos} specificata. <p>
	 * 
	 * Può essere usata per sapere che lettera è presente
	 * (es. {@code getCellValueProperty(p).get()}) oppure per fare un binding della proprietà stessa sulla mappa visuale.
	 * @param p
	 * @return
	 */
	public StringProperty getCellValueProperty(Pos p) { //sia leggerla che modificarla
		return this.cells.get(p) ;
	}

	/**
	 * Restituisce la lista di oggetti {@link  Pos} che corrispondono alle posizioni lecite sulla scacchiera. Gli elementi sono ordinati per righe.
	 * @return
	 */
	public List<Pos> getPositions() {
		return positions;
	}

	/**
	 * Crea una nuova scacchiera generando tutte lettere casuali
	 */
	public void reset(List <String> dizionario) { // crea delle lettere a caso nelle griglie
		
     
		for(Pos p: this.positions) {
			
			int random = (int)(Math.random()*1000);
			String letter ="";
			
			
			
			if(random<115)
				letter = Character.toString('A');
			
			else if(random>=115 && random<133)	
				letter = Character.toString('B');
			
			else if(random>=133 && random<183)	
				letter = Character.toString('C');
			
			else if(random>=183 && random<206)	
				letter = Character.toString('D');
			
			else if(random>=206 && random<305)	
				letter = Character.toString('E');
			
			else if(random>=305 && random<318)	
				letter = Character.toString('F');
			
			else if(random>=318 && random<341)	
				letter = Character.toString('G');
			
			else if(random>=341 && random<348)	
				letter = Character.toString('H');
			
			else if(random>=348 && random<479)	
				letter = Character.toString('I');
			
			else if(random>=479 && random<515)	
				letter = Character.toString('L');
			
			else if(random>=515 && random<551)	
				letter = Character.toString('M');
			
			else if(random>=551 && random<612)	
				letter = Character.toString('N');
			
			else if(random>=612 && random<692)	
				letter = Character.toString('O');
			
			else if(random>=692 && random<715)
				letter = Character.toString('P');
			
			else if(random>=715 && random<799)	
				letter = Character.toString('R');
			
			else if(random>=799 && random<862)	
				letter = Character.toString('S');
			
			else if(random>=862 && random<935)	
				letter = Character.toString('T');
			
			else if(random>=935 && random<953)	
				letter = Character.toString('U');
			
			else if(random>=953 && random<973)	
				letter = Character.toString('V');
			
			else if(random>=973 && random<989)	
				letter = Character.toString('Z');
			
			else {
			
				int ultimo = (int)(Math.random()*6) ;
				 
			switch(ultimo) {
				
				 case 0: 
				 	letter = Character.toString('Q');
				 	break;
				 case 1:
					letter = Character.toString('Z');
					break;
				 case 2:
					letter = Character.toString('Z');
					break;
				 case 3:
					letter = Character.toString('Z');
					break;
				 case 4:
					letter = Character.toString('Z');
					break;
				 case 5:
					letter = Character.toString('Z');
					break;
				 default: 
					System.out.println("ERRORE");
					
				}
				
				
			}
			
		
			this.cells.get(p).set(letter);
		}
		
	}

	public List<Pos> getAdiacenti(Pos ultima) {
		
		List <Pos> result = new ArrayList<Pos>();
		
		for(int r=-1; r<=1; r++) {
			for(int c=-1; c<=1; c++) {
				//tutte le 9 posizioni
				
				//escludo la cella stessa
				if(r!=0 || c!=0) {
					Pos p = new Pos (ultima.getRow()+r,ultima.getCol()+c);
					if(positions.contains(p)) {
						result.add(p);
					}
				}
				
			}
		}
		
		return result;
	}

	
}
