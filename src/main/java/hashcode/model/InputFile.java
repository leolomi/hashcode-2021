package hashcode.model;

import java.util.List;
import java.util.Map;

public class InputFile {


	public InputFile(Map<String, Street> streetMap, List<Car> carList, Integer totalTime, Integer scoreByCar, Map<Integer, Intersection>  intersectionMap) {
		super();
		this.streetMap = streetMap;
		this.carList = carList;
		this.totalTime = totalTime;
		this.scoreByCar = scoreByCar;
		this.intersectionMap = intersectionMap;
	}

	private final Map<Integer, Intersection> intersectionMap;

	private final Map<String, Street> streetMap;

	private final List<Car> carList;

	private final Integer totalTime;

	private final Integer scoreByCar;

	public Map<String, Street> getStreetMap() {
		return this.streetMap;
	}

	public List<Car> getCarList() {
		return this.carList;
	}

	public Integer getTotalTime() {
		return this.totalTime;
	}

	public Integer getScoreByCar() {
		return this.scoreByCar;
	}

	public Map<Integer, Intersection> getIntersectionMap() {
		return this.intersectionMap;
	}



}
