package controllers;

import models.Game;
import models.SpanishDeck;
import models.SpanishFoundation;
import models.SpanishPile;
import models.SpanishSuit;
import models.SpanishWaste;
import models.State;
import java.util.List;
import models.FrenchDeck;
import models.Waste;
import models.FrenchFoundation;
import models.FrenchPile;
import models.FrenchSuit;

public abstract class Controller {
	protected Game game;
	
	protected Controller (Game game){
		assert game != null;
		this.game = game;
	}
	
	protected Game getGame(){
		return game;
	}
	
	protected State getState(){
		return game.getState();
	}
	
	protected abstract void setState();
	
	public void setState (State state){
		assert state != null;
		game.setState(state);
	}
	
	public FrenchDeck getDeck(){
		return game.getDeck();
	}
	
	public SpanishDeck getSpDeck(){
		return game.getSpDeck();
	}
	
	public Waste getWaste(){
		return game.getWaste();
	}
	
	public SpanishWaste getSpWaste(){
		return game.getSpWaste();
	}
	
	public List<FrenchFoundation> getFoundations(){
		return game.getFoundations();
	}
	
	public List<FrenchPile> getPiles(){
		return game.getPiles();
	}
	
	public FrenchFoundation getFoundation(FrenchSuit suit){
		return game.getFoundation(suit);
	}
	
	public List<SpanishFoundation> getSpFoundations(){
		return game.getSpanishFoundation();
	}
	
	public List<SpanishPile> getSpPiles(){
		return game.getSpPiles();
	}
	
	public SpanishFoundation getFoundation (SpanishSuit suit){
		return game.getFoundation(suit);
	}

}
