package views;

import utils.IO;
import utils.LimitedIntDialog;

public class SuitOptionView {
	private IO io;
	
	public SuitOptionView(){
		io = new IO();
	}
	
	public int readOptionSuit(){
		io.writeln(
				"--------------------------------\n¿Qué baraja desea?\n"
				+ "1. Baraja Española\n"
				+ "2. Baraja Francesa\n"
				);
		
		io.writeln();
		return new LimitedIntDialog("Opción?", 1, 2).read();
	}

}
