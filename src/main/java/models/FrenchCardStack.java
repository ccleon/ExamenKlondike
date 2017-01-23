package models;

import java.util.Stack;
import java.util.Collections;

public class FrenchCardStack {
	protected Stack<FrenchCard> cardStack;
	
	public FrenchCardStack(){
		cardStack = new Stack<FrenchCard>();
	}
	
	public void shuffle(){
		Collections.shuffle(cardStack);
	}
	
	public int size(){
		return this.cardStack.size();
	}
	
	public boolean isEmpty(){
		return this.cardStack.empty();
	}
	
	public FrenchCard popCard(){
		return this.cardStack.pop();
	}
	
	public void pushCard(FrenchCard card){
		this.cardStack.push(card);
	}
	
	public FrenchCard peekCard(){
		return this.cardStack.peek();
	}
	
	public void turnDownAll (){
		for (FrenchCard card : this.cardStack){
			card.setTurnedUp(false);
		}
	}
	
	public Stack<FrenchCard> getVisibleCards(){
		Stack<FrenchCard> stack = new Stack<FrenchCard>();
		stack.addAll(cardStack);
		Stack<FrenchCard> visibleCards = new Stack<FrenchCard>();
		
		for(int i=0; i<this.size(); i++){
			FrenchCard topCard = stack.peek();
			if (topCard.isTurnedUp()){
				visibleCards.push(stack.pop());
			}
		}
		return visibleCards;
	}
	
	public String toString(){
		if (cardStack.empty()){
			return "[ ]";
		}else{
			String stackString = "";
			for (int i=0; i<cardStack.size(); i++){
				if (i== cardStack.size() -1 && !cardStack.get(i).isTurnedUp()){
					stackString += "[X, X]";
				}else if (cardStack.get(i).isTurnedUp()){
					stackString += cardStack.get(i).toString();
				}else{
					stackString += "[";
				}
			}
			return stackString;
		}
	}
}
