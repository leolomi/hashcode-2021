package hashcode.model;

import java.util.HashMap;
import java.util.Map;

public class OutputFile {

	private Map<Integer, Intersection> intersectionMap = new HashMap<>();

	public void setIntersectionMap(Map<Integer, Intersection> intersectionMap) {
		this.intersectionMap = intersectionMap;
	}

	public Map<Integer, Intersection> getIntersectionMap() {
		return this.intersectionMap;
	}



}
