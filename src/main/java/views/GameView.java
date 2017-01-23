package views;

import controllers.*;
import models.State;

public class GameView implements OperationControllerVisitor{
	
	private int suitOption;
	
	public void interact(OperationController controller) {
		assert controller != null;
		controller.accept(this);
	}
		

	@Override
	public void visit(StartController startController) {
		startController.setState();
	}
	
	@Override
	public void visit(OptionInputController optionInputController) {
		if (optionInputController.isGameFinished()){
			optionInputController.setState(State.EXIT);
		}else{
			optionInputController.setState();
			new BoardView(optionInputController, suitOption).showAllParts();
			optionInputController.setOption(new MenuView().readOptionMenu());
		}
	}
	
	@Override
	public void visit(SuitOptionController suitOptionController) {
		suitOptionController.setState();
		new BoardView (suitOptionController, 1);
		suitOptionController.setOption(new SuitOptionView().readOptionSuit());
		suitOption = suitOptionController.getSuitOption();
		
	}

	@Override
	public void visit(DeckToWasteController deckToWasteController) {
		deckToWasteController.setState();
		if (suitOption == 2){	
			deckToWasteController.moveDeckToWaste();
		}else{
			deckToWasteController.moveDeckToWaste2();
		}
	}

	@Override
	public void visit(WasteToDeckController wasteToDeckController) {
		wasteToDeckController.setState();
		if (suitOption ==2){	
			wasteToDeckController.moveWasteToDeck();
		}else{
			wasteToDeckController.moveWasteToDeck2();
			
		}
	}

	@Override
	public void visit(ExitController exitController) {
		exitController.setState();
		System.out.println("Bye!");
	}

	@Override
	public void visit(FoundationToPileController foundationToPileController) {
		foundationToPileController.setState();
		if (suitOption ==2){	
			foundationToPileController.moveFoundationToPile();
		}else{
			foundationToPileController.moveFoundationToPile2();
		}
	}

	@Override
	public void visit(PileToFoundationController pileToFoundationController) {
		pileToFoundationController.setState();
		if (suitOption ==2){	
			pileToFoundationController.movePileToFoundation();
		}else{
			pileToFoundationController.movePileToFoundation2();
		}
	}

	@Override
	public void visit(PileToPileController pileToPileController) {
		pileToPileController.setState();
		if (suitOption ==2){	
			pileToPileController.movePileToPile();
		}else{
			pileToPileController.movePileToPile2();
		}
	}

	@Override
	public void visit(TurnUpCardInPileController turnUpCardInPileController) {
		turnUpCardInPileController.setState();
		if (suitOption ==2){	
			turnUpCardInPileController.turnUpCardInPile();
		}else{
			turnUpCardInPileController.turnUpCardInPile2();
		}
	}

	@Override
	public void visit(WasteToFoundationController wasteToFoundationController) {
		wasteToFoundationController.setState();
		if (suitOption ==2){	
			wasteToFoundationController.moveWasteToFoundation();
		}else{
			wasteToFoundationController.moveWasteToFoundation2();
		}
	}

	@Override
	public void visit(WasteToPileController wasteToPileController) {
		wasteToPileController.setState();
		if (suitOption ==2){	
			wasteToPileController.moveWasteToPile();
		}else{
			wasteToPileController.moveWasteToPile2();
		}
	}


	
}
