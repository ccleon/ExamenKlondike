package models;

public class FrenchCard {
	
	private FrenchRank rank;
	private FrenchSuit suit;
	private Color color;
	private boolean turnedUp;

	public FrenchCard (FrenchRank rank, FrenchSuit suit){
		this.rank = rank;
		this.suit = suit;
		this.turnedUp = false;
		if (suit.equals(FrenchSuit.CLUBS) || suit.equals(FrenchSuit.SPADES)){
			this.color = Color.BLACK;
		}else{
			this.color = Color.RED;
		}
	}
	
	public FrenchRank getRank(){
		return rank;
	}
		
	public FrenchSuit getSuit(){
		return suit;
	}
	
	public String getColor (){
		return color.getColor();
	}
	
	public boolean isTurnedUp(){
		return turnedUp;
	}
	
	public void setTurnedUp (boolean turnedUp){
		this.turnedUp = turnedUp;
	}
	
	public boolean sameColor (FrenchCard card){
		return card.getColor() == color.getColor();
	}
	
	public boolean sameSuit (FrenchCard card){
		return card.getSuit() == suit;
	}
	
	public boolean isNextRank (FrenchCard card){
		assert card != null;
		return rank.nextRank() == card.getRank();
	}
	
	public boolean isPreviousRank (FrenchCard card){
		assert card != null;
		return rank.previousRank() == card.getRank();
	}
	
	@Override
	public String toString (){
		return "[" + rank.getRank() + ", " + suit.getFrenchSuit() + "]";
	}
}
