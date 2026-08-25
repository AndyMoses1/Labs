package interfaces;

public class Fish extends Animal implements Swimmable {

	public Fish(String name) {
		super(name, AnimalType.Fish);
	}

	@Override
	public void move() {
		System.out.println("Moving like a Fish!");
	}

	@Override
	public void swim() {
		System.out.println("Swimming like a Fish!");
	}

	@Override
	public String getName() {
		return "This fish is a " + this.name;
	}
}
