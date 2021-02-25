package hashcode.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

	private List<Street> streets = new ArrayList<Street>();

	public List<Street> getStreets() {
		return this.streets;
	}

	public void setStreets(List<Street> streets) {
		this.streets = streets;
	}

}
