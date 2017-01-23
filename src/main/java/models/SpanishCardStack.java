package models;

import java.util.Collections;
import java.util.Stack;

public class SpanishCardStack {
	protected Stack<SpanishCard> cardStack;
	
	public SpanishCardStack(){
		cardStack = new Stack<SpanishCard>();
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
	
	public SpanishCard popSpCard(){
		return this.cardStack.pop();
	}
	
	public void pushSpCard(SpanishCard card){
		this.cardStack.push(card);
	}
	
	public SpanishCard peekSpCard(){
		return this.cardStack.peek();
	}
	
	public void turnDownAll (){
		for (SpanishCard card : this.cardStack){
			card.setTurnedUp(false);
		}
	}
	
	public Stack<SpanishCard> getVisibleCards(){
		Stack<SpanishCard> stack = new Stack<SpanishCard>();
		stack.addAll(cardStack);
		Stack<SpanishCard> visibleCards = new Stack<SpanishCard>();
		
		for(int i=0; i<this.size(); i++){
			SpanishCard topCard = stack.peek();
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
