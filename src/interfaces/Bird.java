package interfaces;

public abstract class Bird extends Animal {

	public Bird(String name) {
		super(name, AnimalType.Bird);
	}
	
	public abstract void makeNest();

}
