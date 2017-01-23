package controllers;

import models.Game;
import models.State;

public class SuitOptionController extends OperationController{
	private int suitOption;
	
	protected SuitOptionController (Game game){
		super(game);
	}
	
	public void setOption(int suitOption){
		this.suitOption = suitOption;
	}
	
	public int getSuitOption(){
		return suitOption;
	}
	
	
	public void setState(){
		this.setState(State.INITIAL);
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
