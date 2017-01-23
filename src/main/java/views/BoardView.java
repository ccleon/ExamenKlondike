package views;

import controllers.*;

public class BoardView {
	private OperationController controller;
	private int i;
	
	public BoardView(OperationController controller, int i) {
		assert controller != null;
		this.controller = controller;
		this.i = i;
	}
	
	public int getSuitOption(){
		return i;
	}

	private void showDeck() {
		if (this.getSuitOption() == 2){
			controller.getDeck().toString();
			new CardStackView(controller.getDeck()).showCardStack("###################################\nBaraja: ");
		}else{
			controller.getSpDeck().toString();
			new CardStackView(controller.getSpDeck()).showSpCardStack("###################################\nBaraja: ");
		}
	}
	
	private void showFoundations() {
		if (this.getSuitOption() == 2){
			for (int i = 0; i < controller.getFoundations().size(); i++) {
				new CardStackView(controller.getFoundations().get(i)).showCardStack();
			}
		}else{
			for (int i = 0; i < controller.getSpFoundations().size(); i++) {
				new CardStackView(controller.getSpFoundations().get(i)).showCardStack();
			}
		}
	}
	
	private void showPiles() {
		if (this.getSuitOption() == 2){
			for (int i = 0; i < controller.getPiles().size(); i++) {
				new CardStackView(controller.getPiles().get(i)).showCardStack();
			}
		}else{
			for (int i = 0; i < controller.getSpPiles().size(); i++) {
				new CardStackView(controller.getSpPiles().get(i)).showCardStack();
			}
		}
	}
	
	
	private void showWaste() {
		if (this.getSuitOption() == 2){
			new CardStackView(controller.getWaste()).showCardStack("Descarte: ");
		}else{
			new CardStackView(controller.getSpWaste()).showSpCardStack("Descarte: ");
		}
	}

	
	public void showAllParts() {
		showDeck();
		showWaste();
		showFoundations();
		showPiles();
	}

}
