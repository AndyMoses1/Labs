package interfaces;

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

			animal.move();

			if (animal instanceof Flyable) {
				((Flyable) animal).fly();
			}

			if (animal instanceof Swimmable) {
				((Swimmable) animal).swim();
			}
			
			if (animal instanceof Fetchable) {
				((Fetchable) animal).fetch();
			}

			System.out.println();
		}
	}

}
