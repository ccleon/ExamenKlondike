package models;

public class SpanishWaste  extends SpanishCardStack{
	@Override
	public String toString(){
		if(this.cardStack.isEmpty()){
			return "<vacio>";
		}else{
			return super.toString();
		}
	}
}
