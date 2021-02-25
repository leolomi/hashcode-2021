package hashcode;

import java.io.IOException;

import org.junit.Test;

import hashcode.business.TrafficLightBusiness;
import hashcode.model.InputFile;
import hashcode.model.OutputFile;
import hashcode.utils.TrafficLightUtils;

/**
 * Unit test for simple App.
 */
public class TrafficLightAppTest {

	private static final String PATH_INPUT_FILES = "src/test/resources/input/";

	private static final String PATH_OUTPUT_FILES = "src/test/resources/output/";

	private static final String FILE_A_IN = "a.txt";

	private static final String FILE_B_IN = "b.txt";

	private static final String FILE_C_IN = "c.txt";

	private static final String FILE_D_IN = "d.txt";

	private static final String FILE_E_IN = "e.txt";

	private static final String FILE_F_IN = "f.txt";

	private static final String FILE_A_OUT = "a.out";

	private static final String FILE_B_OUT = "b.out";

	private static final String FILE_C_OUT = "c.out";

	private static final String FILE_D_OUT = "d.out";

	private static final String FILE_E_OUT = "e.out";

	private static final String FILE_F_OUT = "f.out";

	@Test
	public void pizzaAppTest() throws NumberFormatException, IOException {

		final InputFile inputFileA = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_A_IN);
		final OutputFile outputFileA = TrafficLightBusiness.setTrafficLightTime(inputFileA);
		TrafficLightUtils.writeOutputFile(outputFileA, PATH_OUTPUT_FILES + FILE_A_OUT);


		final InputFile inputFileB = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_B_IN);
		final OutputFile outputFileB = TrafficLightBusiness.setTrafficLightTime(inputFileB);
		TrafficLightUtils.writeOutputFile(outputFileB, PATH_OUTPUT_FILES + FILE_B_OUT);


		final InputFile inputFileC = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_C_IN);
		final OutputFile outputFileC = TrafficLightBusiness.setTrafficLightTime(inputFileC);
		TrafficLightUtils.writeOutputFile(outputFileC, PATH_OUTPUT_FILES + FILE_C_OUT);


		final InputFile inputFileD = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_D_IN);
		final OutputFile outputFileD = TrafficLightBusiness.setTrafficLightTime(inputFileD);
		TrafficLightUtils.writeOutputFile(outputFileD, PATH_OUTPUT_FILES + FILE_D_OUT);


		final InputFile inputFileE = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_E_IN);
		final OutputFile outputFileE = TrafficLightBusiness.setTrafficLightTime(inputFileE);
		TrafficLightUtils.writeOutputFile(outputFileE, PATH_OUTPUT_FILES + FILE_E_OUT);


		final InputFile inputFileF = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_F_IN);
		final OutputFile outputFileF = TrafficLightBusiness.setTrafficLightTime(inputFileF);
		TrafficLightUtils.writeOutputFile(outputFileF, PATH_OUTPUT_FILES + FILE_F_OUT);



	}

}
