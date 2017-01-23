package controllers;

import models.FrenchCard;
import models.Game;
import models.SpanishCard;
import models.State;

public class DeckToWasteController extends OperationController{
	
	public DeckToWasteController(Game game){
		super(game);
	}
	
	public void moveDeckToWaste(){
		if(this.getDeck().isEmpty()){
			errorReport.specificError("ERROR: La baraja está vacía");
		}else{
			this.getWaste().turnDownAll();
			if (this.getDeck().size() < 3){
				moveCardsToWaste(this.getDeck().size());
			}else{
				moveCardsToWaste(3);
			}
		}
	}
	
	public void moveCardsToWaste(int quantity){
		for (int i=0; i<quantity; i++){
			FrenchCard card = this.getDeck().popCard();
			card.setTurnedUp(true);
			this.getWaste().pushCard(card);
		}
	}

	public void moveDeckToWaste2(){
		if(this.getSpDeck().isEmpty()){
			errorReport.specificError("ERROR: La baraja está vacía");
		}else{
			this.getSpWaste().turnDownAll();
			if (this.getSpDeck().size() < 3){
				moveCardsToWaste2(this.getSpDeck().size());
			}else{
				moveCardsToWaste2(3);
			}
		}
	}
	
	public void moveCardsToWaste2(int quantity){
		for (int i=0; i<quantity; i++){
			SpanishCard card = this.getSpDeck().popSpCard();
			card.setTurnedUp(true);
			this.getSpWaste().pushSpCard(card);
		}
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}
	
	@Override
	public void setState() {
		this.setState(State.SELECT_OPTION);
	}
}
