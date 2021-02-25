package hashcode.model;

import java.util.ArrayList;
import java.util.List;

public class Intersection {

	private List<Street> incommingStreets =  new ArrayList<Street>();

	private List<Street> outcommingStreets =  new ArrayList<Street>();

	private List<TrafficLightForOneRoad> fire = new ArrayList<TrafficLightForOneRoad>();

	public List<Street> getIncommingStreets() {
		return this.incommingStreets;
	}

	public void setIncommingStreets(List<Street> incommingStreets) {
		this.incommingStreets = incommingStreets;
	}

	public List<Street> getOutcommingStreets() {
		return this.outcommingStreets;
	}

	public void setOutcommingStreets(List<Street> outcommingStreets) {
		this.outcommingStreets = outcommingStreets;
	}

	public List<TrafficLightForOneRoad> getFire() {
		return this.fire;
	}

	public void setFire(List<TrafficLightForOneRoad> fire) {
		this.fire = fire;
	}

}
