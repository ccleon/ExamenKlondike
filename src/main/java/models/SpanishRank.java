package models;

public enum SpanishRank {
	UNO ("1"),
	DOS ("2"),
	TRES ("3"),
	CUATRO ("4"),
	CINCO ("5"),
	SEIS ("6"),
	SIETE ("7"),
	SOTA ("10"),
	CABALLO ("11"),
	REY ("12");
	private String rank;
	
	private SpanishRank (String rank){
		this.rank = rank;
	}
	
	public SpanishRank nextRank(){
		SpanishRank[] ranks = values();
		return ranks[(this.ordinal() + 1) % ranks.length];
	}
	
	public SpanishRank previousRank(){
		SpanishRank[] ranks = values();
		return ranks[(this.ordinal() -1) % ranks.length];
	}
	
	public String getRank (){
		return rank;
	}
}
