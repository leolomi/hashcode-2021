package hashcode.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private Integer persons;
	
	private List<Pizza> pizzas;
	
	public Team(Integer persons, List<Pizza> pizzas) {
		super();
		if (pizzas.size() != persons) {
			throw new RuntimeException("Number of delivered pizzas incorrect for the team");
		}
		this.persons = persons;
		this.pizzas = pizzas;
		System.out.println(persons + " persons team, score " + this.getScore());
	}

	public Integer getPersons() {
		return persons;
	}

	public void setPersons(Integer persons) {
		this.persons = persons;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	public Integer getScore() {
		List<String> ingredients = new ArrayList<String>();
		Integer differentIngredients = 0;
		for (Pizza pizza : this.pizzas) {
			for (String ingredient : pizza.getIngredients()) {
				if (!ingredients.contains(ingredient)) {
					ingredients.add(ingredient);
					differentIngredients++;
				}
			}
		}
		return differentIngredients*differentIngredients;
	}
	
}
