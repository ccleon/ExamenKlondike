package controllers;

import models.Game;
import models.SpanishPile;
import models.FrenchPile;
import models.State;
import utils.LimitedIntDialog;

public class TurnUpCardInPileController extends OperationController{
	
	public TurnUpCardInPileController(Game game){
		super(game);
	}
	
	public void turnUpCardInPile(){
		int whichPile = new LimitedIntDialog("Qué escalera?", 1, 7).read() -1;
		FrenchPile pile = getPiles().get(whichPile);
		
		if (!pile.isEmpty()){
			if (pile.peekCard().isTurnedUp()){
				errorReport.specificError("ERROR: La carta ya está volteada");
			}else{
				pile.peekCard().setTurnedUp(true);
			}
		}else{
			errorReport.generalError();
		}
	}

	public void turnUpCardInPile2(){
		int whichPile = new LimitedIntDialog("Qué escalera?", 1, 7).read() -1;
		SpanishPile pile = getSpPiles().get(whichPile);
		
		if (!pile.isEmpty()){
			if (pile.peekSpCard().isTurnedUp()){
				errorReport.specificError("ERROR: La carta ya está volteada");
			}else{
				pile.peekSpCard().setTurnedUp(true);
			}
		}else{
			errorReport.generalError();
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
