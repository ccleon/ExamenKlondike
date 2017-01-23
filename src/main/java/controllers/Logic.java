package controllers;

import models.Game;

public class Logic {
	private Game game;
	private StartController startController;
	private MenuOptionController menuOptionController;
	private OptionInputController optionInputController;
	private SuitOptionController suitOptionController;
	
	public Logic (){
		game = new Game();
		startController = new StartController(game);
		menuOptionController = new MenuOptionController(game);
		optionInputController = new OptionInputController(game);
		suitOptionController = new SuitOptionController(game);
	}
	
	public OperationController getOperationController (){
		switch(game.getState()){
		case SELECT_SUIT:
			return suitOptionController;
		case INITIAL:
			return startController;
		case SELECT_OPTION:
			return optionInputController; 
		case IN_GAME:
			return menuOptionController.getOperationMenu(optionInputController.getOption());
		case EXIT:
		default:
			return null;
		}
	}
	
}
