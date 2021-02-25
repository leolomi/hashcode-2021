package hashcode.model;

import java.util.List;

public class OutputFile {
	
	private Integer deliveredTeams;
	
	private List<Team> teams;

	public OutputFile(Integer deliveredTeams, List<Team> teams) {
		super();
		this.deliveredTeams = deliveredTeams;
		this.teams = teams;
		System.out.println("Total score " + this.getScore());
	}

	public Integer getDeliveredTeams() {
		return deliveredTeams;
	}

	public void setDeliveredTeams(Integer deliveredTeams) {
		this.deliveredTeams = deliveredTeams;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	public Integer getScore() {
		return teams.stream().mapToInt(team -> team.getScore()).sum();
	}

}
