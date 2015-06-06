package UIComponent.Team;

import javax.swing.JPanel;

public class TeamDetailPanel extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String team;
public TeamDetailPanel(String teamName){
	this.team=teamName;
}
public String getTeam(){
	return this.team;
}
}
