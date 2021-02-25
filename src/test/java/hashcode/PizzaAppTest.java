package hashcode;

import java.io.IOException;

import org.junit.Test;

import hashcode.business.PizzaBusiness;
import hashcode.model.InputFile;
import hashcode.model.OutputFile;
import hashcode.utils.TrafficLightUtils;

/**
 * Unit test for simple App.
 */
public class PizzaAppTest {

	private static final String PATH_INPUT_FILES = "src/test/resources/input/";

	private static final String PATH_OUTPUT_FILES = "src/test/resources/output/";

	private static final String FILE_A_IN = "a.txt";

	private static final String FILE_B_IN = "b.txt";

	private static final String FILE_C_IN = "c.txt";

	private static final String FILE_D_IN = "d.txt";

	private static final String FILE_E_IN = "e.txt";

	private static final String FILE_A_OUT = "a.out";

	private static final String FILE_B_OUT = "b.out";

	private static final String FILE_C_OUT = "c.out";

	private static final String FILE_D_OUT = "d.out";

	private static final String FILE_E_OUT = "e.out";

	@Test
	public void pizzaAppTest() throws NumberFormatException, IOException {

		// Read input file
		final InputFile inputFileA = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_A_IN);
		final InputFile inputFileB = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_B_IN);
		final InputFile inputFileC = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_C_IN);
		final InputFile inputFileD = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_D_IN);
		final InputFile inputFileE = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_E_IN);

		// Business
		final OutputFile outputFileA = PizzaBusiness.deliverPizzas(inputFileA);
		final OutputFile outputFileB = PizzaBusiness.deliverPizzas(inputFileB);
		final OutputFile outputFileC = PizzaBusiness.deliverPizzas(inputFileC);
		final OutputFile outputFileD = PizzaBusiness.deliverPizzas(inputFileD);
		final OutputFile outputFileE = PizzaBusiness.deliverPizzas(inputFileE);


		// Write output file
		TrafficLightUtils.writeOutputFile(outputFileA, PATH_OUTPUT_FILES + FILE_A_OUT);
		TrafficLightUtils.writeOutputFile(outputFileB, PATH_OUTPUT_FILES + FILE_B_OUT);
		TrafficLightUtils.writeOutputFile(outputFileC, PATH_OUTPUT_FILES + FILE_C_OUT);
		TrafficLightUtils.writeOutputFile(outputFileD, PATH_OUTPUT_FILES + FILE_D_OUT);
		TrafficLightUtils.writeOutputFile(outputFileE, PATH_OUTPUT_FILES + FILE_E_OUT);

	}
}
