package UIComponent.Match;

import javax.swing.JPanel;

public class MatchDetailPanel extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String time;
private String winner;
public MatchDetailPanel(String stime,String swinner){
	this.time=stime;
	this.winner=swinner;
}
public String getTime(){
	return this.time;
	
}
public String getWinner(){
	return this.winner;
}
}
