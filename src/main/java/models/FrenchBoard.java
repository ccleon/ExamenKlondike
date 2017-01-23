package models;

import java.util.List;
import java.util.ArrayList;

public class FrenchBoard {
	public FrenchDeck deck;
	public Waste waste;
	public List<FrenchFoundation> foundations;
	public List<FrenchPile> piles;
	
	public FrenchBoard (){
		deck = new FrenchDeck();
		waste = new Waste();
		foundations = new ArrayList<FrenchFoundation>();
		piles = new ArrayList<FrenchPile>();
		initFoundations();
		initPiles();
	}
	
	public void initFoundations(){
		foundations.add(new FrenchFoundation(FrenchSuit.CLUBS));
		foundations.add(new FrenchFoundation(FrenchSuit.DIAMONDS));
		foundations.add(new FrenchFoundation(FrenchSuit.HEARTS));
		foundations.add(new FrenchFoundation(FrenchSuit.SPADES));
	}
	
	public void initPiles(){
		for (int i=0; i<7; i++){
			piles.add(new FrenchPile(i+1));
		}
		cardsToPiles();
	}
	
	public void cardsToPiles(){
		int stop = 1;
		for (FrenchPile pile : piles){
			for(int i=0; i<stop; i++){
				pile.pushCard(deck.popCard());
			}
			stop++;
			pile.turnUpFirstCard();
		}
	}
	
	public FrenchDeck getDeck(){
		return deck;
	}
	
	public Waste getWaste(){
		return waste;
	}
	
	public List<FrenchFoundation> getFoundations(){
		return foundations;
	}
	
	public FrenchFoundation getFoundation(FrenchSuit suit){
		for (FrenchFoundation founds : this.getFoundations()){
			if(founds.getSuit() == suit){
				return founds;
			}
		}
		return null;
	}
	
	public List<FrenchPile> getPiles(){
		return piles;
	}

}
