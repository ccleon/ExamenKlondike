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

public class FoundationToPileController extends OperationController{
	
	public FoundationToPileController(Game game){
		super(game);
	}
	
	public void moveFoundationToPile(){
		int origin = new LimitedIntDialog("De que palo?", 1, 4).read() -1;
		int dest = new LimitedIntDialog("A que escalera?", 1, 7).read() -1;
		FrenchFoundation foundOrigin = this.getFoundations().get(origin);
		FrenchPile pileDest = this.getPiles().get(dest);
		
		if (!foundOrigin.isEmpty()){
			if (suitablePileFromFoundation(pileDest, foundOrigin.peekCard())){
				pileDest.pushCard(foundOrigin.popCard());
			}else{
				errorReport.generalError();
			}
		}else{
			errorReport.specificError("ERROR: Palo vacio");
		}
	}
	
	public boolean suitablePileFromFoundation(FrenchPile pile, FrenchCard card) {
			if (pile.isEmpty()) {
				if (card.getRank() == FrenchRank.KING){
					return true;
				}else{
					return false;
				}
			}else{
				if (pile.peekCard().isTurnedUp()){
					if (card.getRank() != FrenchRank.KING) {
						FrenchCard destCard = pile.peekCard();
						if (card.isNextRank(destCard) && !card.sameColor(destCard))
							return true;
					}
				}
			} 
		return false;
	}

	public void moveFoundationToPile2(){
		int origin = new LimitedIntDialog("De que palo?", 1, 4).read() -1;
		int dest = new LimitedIntDialog("A que escalera?", 1, 7).read() -1;
		SpanishFoundation foundSpOrigin = this.getSpFoundations().get(origin);
		SpanishPile pileSpDest = this.getSpPiles().get(dest);
		
		if (!foundSpOrigin.isEmpty()){
			if (suitablePileFromFoundation2(pileSpDest, foundSpOrigin.peekSpCard())){
				pileSpDest.pushSpCard(foundSpOrigin.popSpCard());
			}else{
				errorReport.generalError();
			}
		}else{
			errorReport.specificError("ERROR: Palo vacio");
		}
	}
	
	public boolean suitablePileFromFoundation2(SpanishPile pile, SpanishCard card) {
			if (pile.isEmpty()) {
				if (card.getRank() == SpanishRank.REY){
					return true;
				}else{
					return false;
				}
			}else{
				if (pile.peekSpCard().isTurnedUp()){
					if (card.getRank() != SpanishRank.REY) {
						SpanishCard destCard = pile.peekSpCard();
						if (card.isNextRank(destCard) && !card.sameSuit(destCard))
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
