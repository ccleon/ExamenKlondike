package models;

public enum FrenchRank {
	
	ACE ("A"),
	TWO ("2"),
	THREE ("3"),
	FOUR ("4"),
	FIVE ("5"),
	SIX ("6"),
	SEVEN ("7"),
	EIGHT ("8"),
	NINE ("9"),
	TEN ("10"),
	JACK ("J"),
	QUEEN ("Q"),
	KING ("K");
	private String rank;
	
	private FrenchRank (String rank){
		this.rank = rank;
	}
	
	public FrenchRank nextRank(){
		FrenchRank[] ranks = values();
		return ranks[(this.ordinal() + 1) % ranks.length];
	}
	
	public FrenchRank previousRank(){
		FrenchRank[] ranks = values();
		return ranks[(this.ordinal() -1) % ranks.length];
	}
	
	public String getRank (){
		return rank;
	}
	
}
