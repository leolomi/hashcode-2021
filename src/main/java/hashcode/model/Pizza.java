package hashcode.model;

import java.util.List;

public class Pizza {
	
	private Integer id;
	
	private Integer numberIngredients;

	private List<String> ingredients;

	public Pizza(Integer id, Integer numberIngredients, List<String> ingredients) {
		super();
		this.id = id;
		this.numberIngredients = numberIngredients;
		this.ingredients = ingredients;
		this.checkPizza();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumberIngredients() {
		return numberIngredients;
	}

	public void setNumberIngredients(Integer numberIngredients) {
		this.numberIngredients = numberIngredients;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public void checkPizza() {
		if (numberIngredients != ingredients.size()) {
			throw new RuntimeException("The pizza must have the number of ingredients defined");
		}
	}
	
	public Integer calculateDifferentIngredients(List<Pizza> pizzas) {
		Integer differentIngredients = 0;
		for (Pizza pizza : pizzas) {
			for (String ingredient : pizza.getIngredients()) {
				if (!ingredients.contains(ingredient)) {
					differentIngredients++;
				}
			}
		}
		return differentIngredients;
	}
}
