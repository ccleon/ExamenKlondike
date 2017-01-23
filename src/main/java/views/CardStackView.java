package views;

import models.FrenchCardStack;
import models.SpanishCardStack;
import utils.IO;

public class CardStackView {
	
	private FrenchCardStack cardStack;
	private SpanishCardStack spCardStack;
	private IO io;

	public CardStackView(FrenchCardStack cardStack) {
		this.io = new IO();
		this.cardStack = cardStack;
	}
	
	public CardStackView(SpanishCardStack spCardStack) {
		this.io = new IO();
		this.spCardStack = spCardStack;
	}
	
	public void showCardStack() {
		io.writeln(this.toString());
	}
	
	public void showSpCardStack() {
		io.writeln(this.spCardStack.toString());
	}

	public void showCardStack(String title) {
		io.writeln(title + this.toString());
	}
	
	public void showSpCardStack(String title) {
		io.writeln(title + this.spCardStack.toString());
	}

	@Override
	public String toString() {
		if (cardStack == null){
			return this.spCardStack.toString();
		}else{
			return this.cardStack.toString();
		}
	}
}
