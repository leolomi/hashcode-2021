package hashcode.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hashcode.model.Car;
import hashcode.model.InputFile;
import hashcode.model.Intersection;
import hashcode.model.OutputFile;
import hashcode.model.Street;

public class TrafficLightUtils {

	private static final String SPACE = " ";

	private static final String LN = "\n";

	public static InputFile readInputFile(String path) throws NumberFormatException, IOException {

		InputFile inputFile = null;

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			// setting des paramètres initiaux contenu dans la première ligne
			final String parameters[] = br.readLine().split(SPACE);
			final Integer simultationSecs = Integer.valueOf(parameters[0]);
			Integer.valueOf(parameters[1]);
			final Integer nbOfStreets = Integer.valueOf(parameters[2]);
			final Integer nbOfCars = Integer.valueOf(parameters[3]);
			final Integer scoreByCars = Integer.valueOf(parameters[4]);

			final Map<Integer, Intersection> intersectionMap = new HashMap<>();
			final Map<String, Street> streetMap = new HashMap<>();

			for(int i = 0; i < nbOfStreets; i++) {
				final String streetParameters[] = br.readLine().split(SPACE);
				final Street street = new Street(String.valueOf(streetParameters[2]), Integer.valueOf(streetParameters[3]),
						Integer.valueOf(streetParameters[0]), Integer.valueOf(streetParameters[1]));
				streetMap.put(String.valueOf(streetParameters[2]), street);

				if(intersectionMap.containsKey(street.getStartIntersection())) {
					intersectionMap.get(street.getStartIntersection()).getOutcommingStreets().add(street);
				} else {
					final Intersection intersection = new Intersection();
					intersection.getOutcommingStreets().add(street);
					intersectionMap.put(street.getStartIntersection(), intersection);
				}

				if(intersectionMap.containsKey(street.getEndIntersection())) {
					intersectionMap.get(street.getEndIntersection()).getIncommingStreets().add(street);
				} else {
					final Intersection intersection = new Intersection();
					intersection.getIncommingStreets().add(street);
					intersectionMap.put(street.getEndIntersection(), intersection);
				}

			}

			final List<Car> carList = new ArrayList<>();

			for(int i = 0; i < nbOfCars; i++) {
				final String carParameters[] = br.readLine().split(SPACE);
				final Car car = new Car();
				final Integer nbStreetForCar = Integer.valueOf(carParameters[0]);
				for(int j = 1; j <= nbStreetForCar; j++) {
					car.getStreets().add(streetMap.get(carParameters[j]));
					streetMap.get(carParameters[j]).addCar();
				}
				carList.add(car);
			}

			inputFile = new InputFile(streetMap, carList, simultationSecs, scoreByCars, intersectionMap);
		}
		return inputFile;
	}

	public static void writeOutputFile(OutputFile outputFile, String path) {
		final StringBuilder outputFileString = new StringBuilder();
		outputFileString.append(outputFile.getIntersectionMap().size()).append(LN);
		for (final Map.Entry<Integer, Intersection> entry : outputFile.getIntersectionMap().entrySet()) {
			outputFileString.append(entry.getKey()).append(SPACE).append(LN);
			outputFileString.append(entry.getValue().getIncommingStreets().size()).append(SPACE).append(LN);
			for (final Street inconmingStreet : entry.getValue().getIncommingStreets()) {
				outputFileString.append(inconmingStreet.getName()).append(SPACE)
				.append(inconmingStreet.getTimeOnTrafficLight()).append(LN);
			}
		}
		writeUsingOutputStream(outputFileString.toString(), path);
	}

	public static void writeUsingOutputStream(final String data, final String out) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(new File(out));
			os.write(data.getBytes(), 0, data.length());
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
	}

}
