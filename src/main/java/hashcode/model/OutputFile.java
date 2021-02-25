package hashcode.model;

import java.util.ArrayList;
import java.util.List;

public class OutputFile {

	private List<Intersection> intersections = new ArrayList<Intersection>();

	public List<Intersection> getIntersections() {
		return this.intersections;
	}

	public void setIntersections(List<Intersection> intersections) {
		this.intersections = intersections;
	}

}
