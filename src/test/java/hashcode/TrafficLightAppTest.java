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
	
	private static final String FILE_A_OUT = "a.out";
	
	private static final String FILE_B_OUT = "b.out";
	
	private static final String FILE_C_OUT = "c.out";
	
	private static final String FILE_D_OUT = "d.out";
	
	private static final String FILE_E_OUT = "e.out";
    
    @Test
    public void trafficLightTest() throws NumberFormatException, IOException {

    	// Read input file
        InputFile inputFileA = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_A_IN);
        InputFile inputFileB = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_B_IN);
        InputFile inputFileC = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_C_IN);
        InputFile inputFileD = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_D_IN);
        InputFile inputFileE = TrafficLightUtils.readInputFile(PATH_INPUT_FILES + FILE_E_IN);
        
        // Business
        OutputFile outputFileA = TrafficLightBusiness.setTrafficLightTime(inputFileA);
        OutputFile outputFileB = TrafficLightBusiness.setTrafficLightTime(inputFileB);
        OutputFile outputFileC = TrafficLightBusiness.setTrafficLightTime(inputFileC);
        OutputFile outputFileD = TrafficLightBusiness.setTrafficLightTime(inputFileD);
        OutputFile outputFileE = TrafficLightBusiness.setTrafficLightTime(inputFileE);
        
        // Write output file
        TrafficLightUtils.writeOutputFile(outputFileA, PATH_OUTPUT_FILES + FILE_A_OUT);
        TrafficLightUtils.writeOutputFile(outputFileB, PATH_OUTPUT_FILES + FILE_B_OUT);
        TrafficLightUtils.writeOutputFile(outputFileC, PATH_OUTPUT_FILES + FILE_C_OUT);
        TrafficLightUtils.writeOutputFile(outputFileD, PATH_OUTPUT_FILES + FILE_D_OUT);
        TrafficLightUtils.writeOutputFile(outputFileE, PATH_OUTPUT_FILES + FILE_E_OUT);
        
        //Integer totalScore = outputFileA.getScore() + outputFileB.getScore() + outputFileC.getScore() + outputFileD.getScore() + outputFileE.getScore();  
        
        //System.out.println("Total score all files " + totalScore);
    }
}
