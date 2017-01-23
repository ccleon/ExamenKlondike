package models;

public class SpanishDeck extends SpanishCardStack{
	public SpanishDeck (){
		super();
		SpanishRank[] ranks = SpanishRank.values();
		SpanishSuit[] suits = SpanishSuit.values();
		for (SpanishRank rank : ranks){
			for (SpanishSuit suit : suits){
				cardStack.add(new SpanishCard(rank, suit));
			}
		}
		this.shuffle();
	}
	
	@Override
	public String toString(){
		if (cardStack.isEmpty()){
			return "<vacio>";
		}else{
			return "[X,X]";
		}
	}
}
