package models;

public class SpanishCard {
	private SpanishRank rank;
	private SpanishSuit suit;
	private boolean turnedUp;

	public SpanishCard (SpanishRank rank, SpanishSuit suit){
		this.rank = rank;
		this.suit = suit;
		this.turnedUp = false;
	}
	
	public SpanishRank getRank(){
		return rank;
	}
		
	public SpanishSuit getSuit(){
		return suit;
	}
	
	public boolean isTurnedUp(){
		return turnedUp;
	}
	
	public void setTurnedUp (boolean turnedUp){
		this.turnedUp = turnedUp;
	}
	
	public boolean sameSuit (SpanishCard card){
		return card.getSuit() == suit;
	}
	
	public boolean isNextRank (SpanishCard card){
		assert card != null;
		return rank.nextRank() == card.getRank();
	}
	
	public boolean isPreviousRank (SpanishCard card){
		assert card != null;
		return rank.previousRank() == card.getRank();
	}
	
	@Override
	public String toString (){
		return "[" + rank.getRank() + ", " + suit.getSpanishSuit() + "]";
	}
}
