package hashcode;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import hashcode.business.PizzaBusiness;
import hashcode.model.InputFile;
import hashcode.model.OutputFile;
import hashcode.utils.PizzaUtils;

/**
 * Unit test for simple App.
 */
public class PizzaAppTest {
	
	private static final String PATH_INPUT_FILES = "src/test/resources/input/";
	
	private static final String PATH_OUTPUT_FILES = "src/test/resources/output/";
	
	private static final String FILE_A_IN = "a_example";
	
	private static final String FILE_B_IN = "b_little_bit_of_everything.in";
	
	private static final String FILE_C_IN = "c_many_ingredients.in";
	
	private static final String FILE_D_IN = "d_many_pizzas.in";
	
	private static final String FILE_E_IN = "e_many_teams.in";
	
	private static final String FILE_A_OUT = "a_example.out";
	
	private static final String FILE_B_OUT = "b_little_bit_of_everything.out";
	
	private static final String FILE_C_OUT = "c_many_ingredients.out";
	
	private static final String FILE_D_OUT = "d_many_pizzas.out";
	
	private static final String FILE_E_OUT = "e_many_teams.out";
    
    @Test
    public void pizzaAppTest() throws NumberFormatException, IOException {

    	// Read input file
        InputFile inputFileA = PizzaUtils.readInputFile(PATH_INPUT_FILES + FILE_A_IN);
        InputFile inputFileB = PizzaUtils.readInputFile(PATH_INPUT_FILES + FILE_B_IN);
        InputFile inputFileC = PizzaUtils.readInputFile(PATH_INPUT_FILES + FILE_C_IN);
        InputFile inputFileD = PizzaUtils.readInputFile(PATH_INPUT_FILES + FILE_D_IN);
        InputFile inputFileE = PizzaUtils.readInputFile(PATH_INPUT_FILES + FILE_E_IN);
        
        // Business
        OutputFile outputFileA = PizzaBusiness.deliverPizzas(inputFileA);
        OutputFile outputFileB = PizzaBusiness.deliverPizzas(inputFileB);
        OutputFile outputFileC = PizzaBusiness.deliverPizzas(inputFileC);
        OutputFile outputFileD = PizzaBusiness.deliverPizzas(inputFileD);
        OutputFile outputFileE = PizzaBusiness.deliverPizzas(inputFileE);
        
        // Write output file
        PizzaUtils.writeOutputFile(outputFileA, PATH_OUTPUT_FILES + FILE_A_OUT);
        PizzaUtils.writeOutputFile(outputFileB, PATH_OUTPUT_FILES + FILE_B_OUT);
        PizzaUtils.writeOutputFile(outputFileC, PATH_OUTPUT_FILES + FILE_C_OUT);
        PizzaUtils.writeOutputFile(outputFileD, PATH_OUTPUT_FILES + FILE_D_OUT);
        PizzaUtils.writeOutputFile(outputFileE, PATH_OUTPUT_FILES + FILE_E_OUT);
        
        Integer totalScore = outputFileA.getScore() + outputFileB.getScore() + outputFileC.getScore() + outputFileD.getScore() + outputFileE.getScore();  
        
        System.out.println("Total score all files " + totalScore);
    }
}
