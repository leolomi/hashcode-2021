package hashcode.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import hashcode.model.Car;
import hashcode.model.InputFile;
import hashcode.model.Intersection;
import hashcode.model.OutputFile;
import hashcode.model.Street;
import hashcode.model.TrafficLightForOneRoad;

public class TrafficLightBusiness {

	public static OutputFile setTrafficLightTime(InputFile inputFile) {

		final OutputFile out = new OutputFile();

		for(int i = 0 ; i<inputFile.getTotalTime(); i++) {
			for (final Map.Entry<Integer, Intersection> entry : inputFile.getIntersectionMap().entrySet()) {
				if(!entry.getValue().getIncommingStreets().isEmpty()) {
					final List<Street> eligibleStreet = new ArrayList<>();

					// determiner les routes éligibles
					for(final Street street : entry.getValue().getIncommingStreets()) {
						for (final Map.Entry<Integer, Car> carEntry : street.getPositionOfCar().entrySet()) {
							if(carEntry.getKey().equals(street.getTime())) {
								eligibleStreet.add(street);
							}
						}
					}

					if(eligibleStreet.isEmpty()) {
						// incrémenter le dernier feu de la rue ou en créer une
						if(entry.getValue().getFire().isEmpty()) {
							final TrafficLightForOneRoad trafic = new TrafficLightForOneRoad();
							trafic.setStreetName(entry.getValue().getIncommingStreets().get(0).getName());
							trafic.setTimeOfFire(1);
							entry.getValue().getFire().add(trafic);
						} else {
							entry.getValue().getFire().get(entry.getValue().getFire().size() - 1).incrTimeOfFire();
						}
					} else {
						// mettre le feu au vert pour la route éligible ayant le plus de voiture
						int maxNbOfCar = 0;
						Street bestStreet = null;
						for(final Street street : eligibleStreet) {
							if(street.getPositionOfCar().size() > maxNbOfCar) {
								maxNbOfCar = street.getPositionOfCar().size();
								bestStreet = street;
							}
						}
						if(entry.getValue().getFire().isEmpty()) {
							changeFireToStreet(entry, bestStreet);
						} else {

							if(entry.getValue().getFire().get(entry.getValue().getFire().size() - 1).getStreetName().equals(bestStreet.getName())) {
								entry.getValue().getFire().get(entry.getValue().getFire().size() - 1).incrTimeOfFire();
							} else {
								changeFireToStreet(entry, bestStreet);
							}
						}

						final Iterator<Integer> iter = bestStreet.getPositionOfCar().iterator();
						while (iter.hasNext()) {
							final Integer next = iter.next();
							if(next.equals(bestStreet.getTime())) {
								// TODO remove last car
							}
						}
					}

					// change position of all cars
				}
			}
		}

		out.setIntersectionMap(inputFile.getIntersectionMap());

		return out;
	}

	private static void changeFireToStreet(final Map.Entry<Integer, Intersection> entry, Street bestStreet) {
		final TrafficLightForOneRoad trafic = new TrafficLightForOneRoad();
		trafic.setStreetName(bestStreet.getName());
		trafic.setTimeOfFire(1);
		entry.getValue().getFire().add(trafic);
	}

}
