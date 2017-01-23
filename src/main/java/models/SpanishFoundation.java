package models;

public class SpanishFoundation extends SpanishCardStack{
	private SpanishSuit suit;
	
	public SpanishFoundation(SpanishSuit suit){
		super();
		this.suit = suit;
	}
	
	public boolean sameSuit(SpanishCard card){
		return card.getSuit() == suit;
	}
	
	public SpanishSuit getSuit (){
		return suit;
	}
	
	@Override
	public String toString(){
		if (this.cardStack.isEmpty()){
			return "Palo " + suit.toString() + ": <vacio>"; 
		}else{
			return "Palo " + suit.toString() + ": " + super.toString();
		}
	}
}
