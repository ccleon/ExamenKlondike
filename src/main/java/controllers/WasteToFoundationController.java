package controllers;

import models.FrenchCard;
import models.FrenchFoundation;
import models.Game;
import models.SpanishCard;
import models.SpanishFoundation;
import models.SpanishRank;
import models.FrenchRank;
import models.State;

public class WasteToFoundationController extends OperationController{
	
	public WasteToFoundationController(Game game){
		super(game);
	}
	
	public boolean moveWasteToFoundation(){
		if (!this.getWaste().isEmpty()){
			FrenchCard card = this.getWaste().peekCard();
			if (this.suitableSuit(card)){
				this.getFoundation(card.getSuit()).pushCard(this.getWaste().popCard());
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
	
	
	public boolean suitableSuit(FrenchCard card){
		FrenchFoundation foundation = this.getFoundation(card.getSuit());
		if (card.getRank() == FrenchRank.ACE && foundation.isEmpty()){
			return true;
		}else{
			if (!foundation.isEmpty()){
				FrenchRank previous = card.getRank().previousRank();
				if (foundation.peekCard().getRank() == previous){
					return true;
				}
			}
		}
		return false;
	}

	
	public boolean moveWasteToFoundation2(){
		if (!this.getSpWaste().isEmpty()){
			SpanishCard card = this.getSpWaste().peekSpCard();
			if (this.suitableSuit2(card)){
				this.getFoundation(card.getSuit()).pushSpCard(this.getSpWaste().popSpCard());
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
	
	
	public boolean suitableSuit2(SpanishCard card){
		SpanishFoundation foundation = this.getFoundation(card.getSuit());
		if (card.getRank() == SpanishRank.UNO && foundation.isEmpty()){
			return true;
		}else{
			if (!foundation.isEmpty()){
				SpanishRank previous = card.getRank().previousRank();
				if (foundation.peekSpCard().getRank() == previous){
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
