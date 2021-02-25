package hashcode.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import hashcode.model.InputFile;
import hashcode.model.OutputFile;
import hashcode.model.Pizza;
import hashcode.model.Team;

public class PizzaUtils {
	
	private static final String SPACE = " ";
	
	private static final String LN = "\n";

    public static InputFile readInputFile(String path) throws NumberFormatException, IOException {
        
    	InputFile inputFile = null;
    	
    	try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
        	// setting des paramètres initiaux contenu dans la première ligne
            String parameters[] = br.readLine().split(SPACE);
            Integer availablePizzas = Integer.valueOf(parameters[0]);
            Integer twoPersonsTeams = Integer.valueOf(parameters[1]);
            Integer threePersonsTeams = Integer.valueOf(parameters[2]);
            Integer fourPersonsTeams = Integer.valueOf(parameters[3]);
            
            inputFile = new InputFile(availablePizzas, twoPersonsTeams, threePersonsTeams, fourPersonsTeams);

            String line;
            
            List<Pizza> pizzas = new ArrayList<Pizza>();

            int idPizza = 0;

            while ((line = br.readLine()) != null && !line.isEmpty()) {

                String[] pizzaParameters = line.split(SPACE);
                Integer numberIngredients = Integer.valueOf(pizzaParameters[0]);
                List<String> ingredients = new ArrayList<String>();
                for (int i = 1; i < pizzaParameters.length; i++) {
                	ingredients.add(pizzaParameters[i]);
                }
                
                Pizza pizza = new Pizza(idPizza, numberIngredients, ingredients);

                idPizza++;

                pizzas.add(pizza);
            }
            
            inputFile.setPizzas(pizzas);
        }
		return inputFile;
    }
    
    public static void writeOutputFile(OutputFile outputFile, String path) {
    	final StringBuilder outputFileString = new StringBuilder();
    	outputFileString.append(outputFile.getDeliveredTeams()).append(LN);
    	for (Team team : outputFile.getTeams()) {
    		outputFileString.append(team.getPersons()).append(SPACE);
    		for (Pizza pizza : team.getPizzas()) {
    			outputFileString.append(pizza.getId()).append(SPACE);
    		}
    		outputFileString.append(LN);
    	}
    	writeUsingOutputStream(outputFileString.toString(), path);
    }
    
    public static void writeUsingOutputStream(final String data, final String out) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File(out));
            os.write(data.getBytes(), 0, data.length());
        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
