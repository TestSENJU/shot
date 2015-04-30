package launch;

import BL.InitBL;
import BL.InitBL_Impl;
import ui.Controller;
import ui.Monitor;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller ui = new Controller();
		
		ui.layout();
		
		InitBL init=new InitBL_Impl("E://newData");
	
		
	}
}
