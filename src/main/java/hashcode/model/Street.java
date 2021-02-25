package hashcode.model;

public class Street {

	private String name;

	private Integer time;

	private Integer timeOnTrafficLight;

	private Integer startIntersection;

	private Integer endIntersection;

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

}
