package abstract2;

public abstract class Animal {
	AnimalType animalType;
	String name;

	public Animal(String name, AnimalType animalType) {
		this.name = name;
		this.animalType = animalType;
	}
	
	public String getName() {
		return name;
	}

}
