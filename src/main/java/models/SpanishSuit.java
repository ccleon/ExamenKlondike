package models;

public enum SpanishSuit {
	
	ORO("o"),
	ESPADA("e"),
	COPA("c"),
	BASTO("b");
	private String value;
	
	private SpanishSuit (String value){
		this.value = value;
	}
	
	public String getSpanishSuit(){
		return value;
	}
}
