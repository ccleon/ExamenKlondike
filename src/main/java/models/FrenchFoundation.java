package models;

public class FrenchFoundation extends FrenchCardStack{
	private FrenchSuit suit;
	
	public FrenchFoundation(FrenchSuit suit){
		super();
		this.suit = suit;
	}
	
	public boolean sameSuit(FrenchCard card){
		return card.getSuit() == suit;
	}
	
	public FrenchSuit getSuit (){
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
