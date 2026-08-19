package collections_generics;

import java.util.HashMap;

public class Zoo {
	HashMap<String,Integer> animalMap = null;

	String[] originalAnimals = { "Zebra", "Lion", "Buffalo" };

	String[] newAnimals = { "Zebra", "Gazelle", "Buffalo", "Zebra" };

	Zoo() {
		animalMap = new HashMap<String, Integer>();

		// 7. Both arrays go through the same method.
		addAnimals(originalAnimals);
		addAnimals(newAnimals);

		displayAnimalData();
	}

	void addAnimals(String[] animals) {
		for (String animal : animals) {			
			//tried to write as ternary, didn't seem to work. Asked ChatGPT, discovered this useful line:
			//animalMap.merge(animal, 1, Integer::sum);

			if (animalMap.containsKey(animal)) {
				animalMap.put(animal, animalMap.get(animal) + 1);
			} else {
				animalMap.put(animal, 1);
			}
		}
	}

	void displayAnimalData() {
		for (String animal : animalMap.keySet()) {
			System.out.printf("%-10s %d%n", animal, animalMap.get(animal));
		}
	}

}
