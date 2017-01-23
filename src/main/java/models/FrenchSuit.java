package models;

public enum FrenchSuit {
	
	HEARTS("h"),
	DIAMONDS("d"),
	CLUBS("c"),
	SPADES("s");
	private String value;
	
	private FrenchSuit (String value){
		this.value = value;
	}
	
	public String getFrenchSuit(){
		return value;
	}
}
