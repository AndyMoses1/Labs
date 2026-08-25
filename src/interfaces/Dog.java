package interfaces;

public class Dog extends Animal implements Fetchable {

	public Dog(String name) {
		super(name, AnimalType.Mammal);
	}
	
	@Override
	public void move() {
		System.out.println("Moving like a Dog!");
	}

	@Override
	public String getName() {
		return "This dog is a " + this.name;
	}

	@Override
	public void fetch() {
		System.out.println("Fectching a ball like a dog!");		
	}
}
