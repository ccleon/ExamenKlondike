package models;

import java.util.List;

public class Game {
	
	private State state;
	private FrenchBoard board;
	private SpanishBoard spboard;
	
	public Game (){
		state = State.SELECT_SUIT;
		board = new FrenchBoard();
		spboard = new SpanishBoard();
	}
	
	public State getState(){
		return state;
	}
	
	public void setState(State state){
		this.state = state;
	}
	
	public FrenchDeck getDeck(){
		return board.getDeck();
	}
	
	public SpanishDeck getSpDeck(){
		return spboard.getDeck();
	}
	
	public Waste getWaste(){
		return board.getWaste();
	}
	
	public SpanishWaste getSpWaste(){
		return spboard.getWaste();
	}
	
	public List<FrenchFoundation> getFoundations(){
		return board.getFoundations();
	}
	
	public List<FrenchPile> getPiles(){
		return board.getPiles();
	}
	
	public FrenchFoundation getFoundation(FrenchSuit suit){
		return board.getFoundation(suit);
	}
	
	public List<SpanishFoundation> getSpanishFoundation(){
		return spboard.getFoundations();
	}
	
	public List<SpanishPile> getSpPiles(){
		return spboard.getPiles();
	}
	
	public SpanishFoundation getFoundation(SpanishSuit suit){
		return spboard.getFoundation(suit);
	}
	

}
