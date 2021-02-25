package hashcode.business;

import java.util.Map;

import hashcode.model.InputFile;
import hashcode.model.Intersection;
import hashcode.model.OutputFile;
import hashcode.model.Street;

public class PizzaBusiness {

	public static OutputFile deliverPizzas(InputFile inputFile) {

		final OutputFile out = new OutputFile();

		for (final Map.Entry<Integer, Intersection> entry : inputFile.getIntersectionMap().entrySet()) {
			for(final Street street : entry.getValue().getIncommingStreets()) {
				street.setTimeOnTrafficLight(1);
			}
			out.getIntersections().add(entry.getValue());
		}

		return out;
	}

}
