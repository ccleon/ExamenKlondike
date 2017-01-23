package models;

import java.util.List;
import java.util.ArrayList;

public class SpanishBoard {
	public SpanishDeck deck;
	public SpanishWaste waste;
	public List<SpanishFoundation> foundations;
	public List<SpanishPile> piles;
	
	public SpanishBoard (){
		deck = new SpanishDeck();
		waste = new SpanishWaste();
		foundations = new ArrayList<SpanishFoundation>();
		piles = new ArrayList<SpanishPile>();
		initFoundations();
		initPiles();
	}
	
	public void initFoundations(){
		foundations.add(new SpanishFoundation(SpanishSuit.BASTO));
		foundations.add(new SpanishFoundation(SpanishSuit.COPA));
		foundations.add(new SpanishFoundation(SpanishSuit.ESPADA));
		foundations.add(new SpanishFoundation(SpanishSuit.ORO));
	}
	
	public void initPiles(){
		for (int i=0; i<7; i++){
			piles.add(new SpanishPile(i+1));
		}
		cardsToPiles();
	}
	
	public void cardsToPiles(){
		int stop = 1;
		for (SpanishPile pile : piles){
			for(int i=0; i<stop; i++){
				pile.pushSpCard(deck.popSpCard());
			}
			stop++;
			pile.turnUpFirstCard();
		}
	}
	
	public SpanishDeck getDeck(){
		return deck;
	}
	
	public SpanishWaste getWaste(){
		return waste;
	}
	
	public List<SpanishFoundation> getFoundations(){
		return foundations;
	}
	
	public SpanishFoundation getFoundation(SpanishSuit suit){
		for (SpanishFoundation founds : this.getFoundations()){
			if(founds.getSuit() == suit){
				return founds;
			}
		}
		return null;
	}
	
	public List<SpanishPile> getPiles(){
		return piles;
	}
}
