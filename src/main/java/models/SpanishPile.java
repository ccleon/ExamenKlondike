package models;

public class SpanishPile extends SpanishCardStack {
	int whichPile;
	
	public SpanishPile (int whichPile){
		this.whichPile = whichPile;
	}
	
	public void turnUpFirstCard(){
		this.cardStack.peek().setTurnedUp(true);
	}
	
	@Override
	public String toString(){
		if (this.cardStack.isEmpty()){
			return "Escalera " + whichPile +  ": <vacio>";
		}else{
			return "Escalera " + whichPile + ": " + super.toString();

		}
	}

}
