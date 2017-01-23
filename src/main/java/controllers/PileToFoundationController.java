package controllers;

import models.FrenchCard;
import models.FrenchFoundation;
import models.Game;
import models.SpanishCard;
import models.SpanishFoundation;
import models.SpanishPile;
import models.SpanishRank;
import models.FrenchPile;
import models.FrenchRank;
import models.State;
import utils.LimitedIntDialog;

public class PileToFoundationController extends OperationController{
	
	public PileToFoundationController(Game game){
		super(game);
	}
	
	public void movePileToFoundation(){
		int origin = new LimitedIntDialog("De que escalera?", 1, 7).read() -1;
		FrenchPile pile = this.getPiles().get(origin);
		
		if (!pile.isEmpty()){
			FrenchCard card = pile.peekCard();
			if (card.isTurnedUp()){
					FrenchFoundation foundation = this.getFoundation(card.getSuit());
					if (suitableSuitFromPile(card)){
						foundation.pushCard(pile.popCard());
					}else{
						errorReport.generalError();
					}
			}else{
				errorReport.specificError("ERROR: La carta no está volteada");
			}
		}else{
			errorReport.specificError("ERROR: La escalera está vacía");
		}
	}
	
	public boolean suitableSuitFromPile(FrenchCard card){
		FrenchFoundation foundation = this.getFoundation(card.getSuit());
		if (card.getRank() == FrenchRank.ACE && foundation.isEmpty()){
			return true;
		}else{
			if (!foundation.isEmpty()){
				FrenchRank previous = card.getRank().previousRank();
				if (previous == foundation.peekCard().getRank()){
					return true;
				}
			}
		}
		return false;
	}
	
	public void movePileToFoundation2(){
		int origin = new LimitedIntDialog("De que escalera?", 1, 7).read() -1;
		SpanishPile pile = this.getSpPiles().get(origin);
		
		if (!pile.isEmpty()){
			SpanishCard card = pile.peekSpCard();
			if (card.isTurnedUp()){
					SpanishFoundation foundation = this.getFoundation(card.getSuit());
					if (suitableSuitFromPile2(card)){
						foundation.pushSpCard(pile.popSpCard());
					}else{
						errorReport.generalError();
					}
			}else{
				errorReport.specificError("ERROR: La carta no está volteada");
			}
		}else{
			errorReport.specificError("ERROR: La escalera está vacía");
		}
	}
	
	public boolean suitableSuitFromPile2(SpanishCard card){
		SpanishFoundation foundation = this.getFoundation(card.getSuit());
		if (card.getRank() == SpanishRank.UNO && foundation.isEmpty()){
			return true;
		}else{
			if (!foundation.isEmpty()){
				SpanishRank previous = card.getRank().previousRank();
				if (previous == foundation.peekSpCard().getRank()){
					return true;
				}
			}
		}
		return false;
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
