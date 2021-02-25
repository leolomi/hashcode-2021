package hashcode.business;

import java.util.ArrayList;
import java.util.List;

import hashcode.model.InputFile;
import hashcode.model.OutputFile;
import hashcode.model.Team;

public class PizzaBusiness {

	public static OutputFile deliverPizzas(InputFile inputFile) {

		final List<Team> teams = new ArrayList<Team>();

		return new OutputFile(null, teams);
	}

}
