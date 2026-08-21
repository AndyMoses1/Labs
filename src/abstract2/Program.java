package abstract2;

import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		ArrayList<Animal> animals = new ArrayList<Animal>();

		animals.add(new Duck("Mallard"));
		animals.add(new Penguin("Emperor"));
		animals.add(new Fish("Salmon"));
		animals.add(new Dog("Beagle"));

		for (Animal animal : animals) {
			System.out.println(animal.getName() + " - type " + animal.animalType);

			switch (animal) {
				case Bird bird -> bird.makeNest();
				case Dog dog -> dog.noise();
				case Fish fish -> fish.canSwim();
				default -> {}
			}

			System.out.println();
		}
	}

}
