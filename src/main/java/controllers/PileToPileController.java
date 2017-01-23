package controllers;

import java.util.Stack;

import models.FrenchCard;
import models.Game;
import models.SpanishCard;
import models.SpanishPile;
import models.SpanishRank;
import models.FrenchPile;
import models.FrenchRank;
import models.State;
import utils.LimitedIntDialog;

public class PileToPileController extends OperationController{
	
	public PileToPileController(Game game){
		super(game);
	}
	
	public void movePileToPile(){
		int origin = new LimitedIntDialog("De que escalera?", 1, 7).read() -1;
		int dest = new LimitedIntDialog("A que escalera?", 1, 7).read() -1;
		FrenchPile pileOrigin = this.getPiles().get(origin);
		FrenchPile pileDest = this.getPiles().get(dest);
		int quantity = new LimitedIntDialog("Cuantas?", 1, pileOrigin.getVisibleCards().size()).read();
		
		if (!pileOrigin.isEmpty()){
			if (quantity == 1){
				if (suitablePile(pileDest, pileOrigin.peekCard())) {
					pileDest.pushCard(pileOrigin.popCard());
				}else { errorReport.generalError(); }
			}else{
				Stack<FrenchCard> visibleCards = pileOrigin.getVisibleCards();
				FrenchCard temp = visibleCards.elementAt(quantity-1);
				FrenchPile tempPile = new FrenchPile(22);
				
				if (suitablePile(pileDest, temp)){
					for (int i=0; i<quantity; i++){
						tempPile.pushCard(pileOrigin.popCard());
					}
					for (int j=0; j<quantity; j++){
						pileDest.pushCard(tempPile.popCard());
					}
				}else{ errorReport.generalError(); }
			}
		}else{ errorReport.specificError("ERROR: la escalera origen está vacía"); }
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
	
	public void movePileToPile2(){
		int origin = new LimitedIntDialog("De que escalera?", 1, 7).read() -1;
		int dest = new LimitedIntDialog("A que escalera?", 1, 7).read() -1;
		SpanishPile pileOrigin = this.getSpPiles().get(origin);
		SpanishPile pileDest = this.getSpPiles().get(dest);
		int quantity = new LimitedIntDialog("Cuantas?", 1, pileOrigin.getVisibleCards().size()).read();
		
		if (!pileOrigin.isEmpty()){
			if (quantity == 1){
				if (suitablePile2(pileDest, pileOrigin.peekSpCard())) {
					pileDest.pushSpCard(pileOrigin.popSpCard());
				}else { errorReport.generalError(); }
			}else{
				Stack<SpanishCard> visibleCards = pileOrigin.getVisibleCards();
				SpanishCard temp = visibleCards.elementAt(quantity-1);
				SpanishPile tempPile = new SpanishPile(22);
				
				if (suitablePile2(pileDest, temp)){
					for (int i=0; i<quantity; i++){
						tempPile.pushSpCard(pileOrigin.popSpCard());
					}
					for (int j=0; j<quantity; j++){
						pileDest.pushSpCard(tempPile.popSpCard());
					}
				}else{ errorReport.generalError(); }
			}
		}else{ errorReport.specificError("ERROR: la escalera origen está vacía"); }
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
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
		
	}
	@Override
	public void setState() {
		this.setState(State.SELECT_OPTION);
	}
}
