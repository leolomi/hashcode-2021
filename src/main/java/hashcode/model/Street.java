package hashcode.model;

import java.util.HashMap;
import java.util.Map;

public class Street {


	public Street(String name, Integer time, Integer startIntersection,
			Integer endIntersection) {
		super();
		this.name = name;
		this.time = time;
		this.timeOnTrafficLight = this.timeOnTrafficLight;
		this.startIntersection = startIntersection;
		this.endIntersection = endIntersection;
	}

	private String name;

	private Integer time;

	private Integer timeOnTrafficLight;

	private Integer startIntersection;

	private Integer endIntersection;

	private final Map<Integer, Car> positionOfCar = new HashMap<>();

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getStartIntersection() {
		return this.startIntersection;
	}

	public void setStartIntersection(Integer startIntersection) {
		this.startIntersection = startIntersection;
	}

	public Integer getEndIntersection() {
		return this.endIntersection;
	}

	public void setEndIntersection(Integer endIntersection) {
		this.endIntersection = endIntersection;
	}

	public Integer getTimeOnTrafficLight() {
		return this.timeOnTrafficLight;
	}

	public void setTimeOnTrafficLight(Integer timeOnTrafficLight) {
		this.timeOnTrafficLight = timeOnTrafficLight;
	}

	public Map<Integer, Car> getPositionOfCar() {
		return this.positionOfCar;
	}

}
