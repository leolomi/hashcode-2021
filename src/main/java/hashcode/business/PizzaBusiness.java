package hashcode.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import hashcode.model.InputFile;
import hashcode.model.OutputFile;
import hashcode.model.Pizza;
import hashcode.model.Team;

public class PizzaBusiness {
	
	public static OutputFile deliverPizzas(InputFile inputFile) {
		List<Team> teams = new ArrayList<Team>();
		
		// Sort pizzas
		List<Pizza> sortedList = inputFile.getPizzas().stream()
				.sorted(Comparator.comparingInt(Pizza::getNumberIngredients).reversed())
				.collect(Collectors.toList());
		
		// 2 persons teams
		Integer nextIndexPizza = 0;
		for (int i=nextIndexPizza; i+1 < inputFile.getTwoPersonsTeams()*2 && i+1 < inputFile.getAvailablePizzas(); i+=2) {
			List<Pizza> pizzasTeam = new ArrayList<Pizza>();
			// 1rst pizza
			Pizza pizza1 = sortedList.get(i);
			pizzasTeam.add(pizza1);
			// 2nd pizza
			Integer differentIngredients = 0;
			Pizza pizza2 = sortedList.get(0);
			for (Pizza pizza : sortedList) {
				if (differentIngredients < pizza.calculateDifferentIngredients(pizzasTeam)) {
					differentIngredients = pizza.calculateDifferentIngredients(pizzasTeam);
					pizza2 = pizza;
				}
			}
			pizzasTeam.add(pizza2);
			Team team = new Team(2, pizzasTeam);
			teams.add(team);
			nextIndexPizza = i+2;
		}
		
		// 3 persons teams
		for (int i=nextIndexPizza; i+2 < inputFile.getThreePersonsTeams()*3 && i+2 < inputFile.getAvailablePizzas(); i+=3) {
			List<Pizza> pizzasTeam = new ArrayList<Pizza>();
			pizzasTeam.add(sortedList.get(i));
			pizzasTeam.add(sortedList.get(i+1));
			pizzasTeam.add(sortedList.get(i+2));
			Team team = new Team(3, pizzasTeam);
			teams.add(team);
			nextIndexPizza = i+3;
		}
		
		// 4 persons teams
		for (int i=nextIndexPizza; i+3 < inputFile.getThreePersonsTeams()*4 && i+3 < inputFile.getAvailablePizzas(); i+=4) {
			List<Pizza> pizzasTeam = new ArrayList<Pizza>();
			pizzasTeam.add(sortedList.get(i));
			pizzasTeam.add(sortedList.get(i+1));
			pizzasTeam.add(sortedList.get(i+2));
			pizzasTeam.add(sortedList.get(i+3));
			Team team = new Team(4, pizzasTeam);
			teams.add(team);
			nextIndexPizza = i+4;
		}
		
		OutputFile outputFile = new OutputFile(teams.size(), teams);
		
		return outputFile;
	}

}
