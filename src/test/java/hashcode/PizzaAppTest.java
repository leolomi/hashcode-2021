package hashcode;

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

	private static final String FILE_A_IN = "a.txt";

	private static final String FILE_A_OUT = "a_example.out";

	@Test
	public void pizzaAppTest() throws NumberFormatException, IOException {

		// Read input file
		final InputFile inputFileA = PizzaUtils.readInputFile(PATH_INPUT_FILES + FILE_A_IN);

		// Business
		final OutputFile outputFileA = PizzaBusiness.deliverPizzas(inputFileA);


		// Write output file
		PizzaUtils.writeOutputFile(outputFileA, PATH_OUTPUT_FILES + FILE_A_OUT);

	}
}
