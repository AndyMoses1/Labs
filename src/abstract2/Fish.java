package abstract2;

public class Fish extends Animal {

	public Fish(String name) {
		super(name, AnimalType.Fish);
	}

	@Override
	public String getName() {
		return "This fish is a " + this.name;
	}
	
	public void canSwim() {
		System.out.println("Fish can swim");
	}
}
