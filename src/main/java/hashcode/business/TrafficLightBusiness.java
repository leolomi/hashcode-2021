package hashcode.business;

import java.util.ArrayList;
import java.util.HashMap;
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
						if(street.getPositionOfCar().containsKey(street.getTime())) {
							eligibleStreet.add(street);
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


						bestStreet.getPositionOfCar().remove(bestStreet.getTime());
					}

					// change position of all cars
					for(final Street street : entry.getValue().getIncommingStreets()) {
						final Map<Integer, Car> map = new HashMap<>();
						for (final Map.Entry<Integer, Car> entryCar : street.getPositionOfCar().entrySet()) {
							if(entryCar.getKey() < street.getTime()) {
								map.put(entryCar.getKey()+1, entryCar.getValue());
							} else {
								// TODO find new road
								for(int ity = 0; ity<entryCar.getValue().getStreets().size(); ity++) {
									if(entryCar.getValue().getStreets().get(ity).getName().equals(street.getName())
											&& ity+1 < entryCar.getValue().getStreets().size()) {

										int taa = 1;
										while(entryCar.getValue().getStreets().get(ity+1).getPositionOfCar().containsKey(taa)) {
											taa--;
										}
										entryCar.getValue().getStreets().get(ity+1).getPositionOfCar().put(taa, entryCar.getValue());
									}
								}
							}
						}
						street.setPositionOfCar(map);
					}
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
