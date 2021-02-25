package hashcode.model;

import java.util.List;

public class InputFile {
	
	private Integer availablePizzas;
	
	private Integer twoPersonsTeams;
	
	private Integer threePersonsTeams;
	
	private Integer fourPersonsTeams;
	
	private List<Pizza> pizzas;

	public InputFile(Integer availablePizzas, Integer twoPersonsTeams, Integer threePersonsTeams,
			Integer fourPersonsTeams) {
		super();
		this.availablePizzas = availablePizzas;
		this.twoPersonsTeams = twoPersonsTeams;
		this.threePersonsTeams = threePersonsTeams;
		this.fourPersonsTeams = fourPersonsTeams;
	}

	public Integer getAvailablePizzas() {
		return availablePizzas;
	}

	public void setAvailablePizzas(Integer availablePizzas) {
		this.availablePizzas = availablePizzas;
	}

	public Integer getTwoPersonsTeams() {
		return twoPersonsTeams;
	}

	public void setTwoPersonsTeams(Integer twoPersonsTeams) {
		this.twoPersonsTeams = twoPersonsTeams;
	}

	public Integer getThreePersonsTeams() {
		return threePersonsTeams;
	}

	public void setThreePersonsTeams(Integer threePersonsTeams) {
		this.threePersonsTeams = threePersonsTeams;
	}

	public Integer getFourPersonsTeams() {
		return fourPersonsTeams;
	}

	public void setFourPersonsTeams(Integer fourPersonsTeams) {
		this.fourPersonsTeams = fourPersonsTeams;
	}
	
	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public void checkInputFile() {
		if (availablePizzas != pizzas.size()) {
			throw new RuntimeException("Wrong reading of the input file");
		}
	}

}
