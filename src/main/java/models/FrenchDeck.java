package models;

public class FrenchDeck extends FrenchCardStack{
	
	public FrenchDeck (){
		super();
		FrenchRank[] ranks = FrenchRank.values();
		FrenchSuit[] suits = FrenchSuit.values();
		for (FrenchRank rank : ranks){
			for (FrenchSuit suit : suits){
				cardStack.add(new FrenchCard(rank, suit));
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
