package controllers;

import models.FrenchCard;
import models.Game;
import models.SpanishCard;
import models.SpanishPile;
import models.SpanishRank;
import models.FrenchPile;
import models.FrenchRank;
import models.State;
import utils.LimitedIntDialog;

public class WasteToPileController extends OperationController{
	
	public WasteToPileController(Game game){
		super(game);
	}
	
	public boolean moveWasteToPile(){
		if (!this.getWaste().isEmpty()){
			int dest = new LimitedIntDialog("A que escalera?", 1, 7).read() - 1;
			FrenchCard card = this.getWaste().peekCard();
			FrenchPile pile = this.getPiles().get(dest);
			
			if (suitablePile(pile, card)){
				pile.pushCard(this.getWaste().popCard());
				return true;
			}else{
				errorReport.generalError();
				return false;
			}
		}else{
			errorReport.specificError("ERROR: Los descartes están vacíos");
			return false;
		}
	}
	
	public boolean suitablePile(FrenchPile pile, FrenchCard card){
		if (pile.isEmpty()){
			if (card.getRank() == FrenchRank.KING)
				return true;
		}else{
			if (card.getRank() != FrenchRank.KING){
				FrenchCard destCard = pile.peekCard();
				if (card.isNextRank(destCard) && !card.sameColor(destCard))
					return true;
			}
		}
		return false;
	}
	
	public boolean moveWasteToPile2(){
		if (!this.getSpWaste().isEmpty()){
			int dest = new LimitedIntDialog("A que escalera?", 1, 7).read() - 1;
			SpanishCard card = this.getSpWaste().peekSpCard();
			SpanishPile pile = this.getSpPiles().get(dest);
			
			if (suitablePile2(pile, card)){
				pile.pushSpCard(this.getSpWaste().popSpCard());
				return true;
			}else{
				errorReport.generalError();
				return false;
			}
		}else{
			errorReport.specificError("ERROR: Los descartes están vacíos");
			return false;
		}
	}
	
	public boolean suitablePile2(SpanishPile pile, SpanishCard card){
		if (pile.isEmpty()){
			if (card.getRank() == SpanishRank.REY)
				return true;
		}else{
			if (card.getRank() != SpanishRank.REY){
				SpanishCard destCard = pile.peekSpCard();
				if (card.isNextRank(destCard) && !card.sameSuit(destCard))
					return true;
			}
		}
		return false;
	}
	
	
	@Override
	public void setState() {
		this.setState(State.SELECT_OPTION);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
