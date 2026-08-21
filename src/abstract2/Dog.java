package abstract2;

public class Dog extends Animal {

	public Dog(String name) {
		super(name, AnimalType.Mammal);
	}
	
	@Override
	public String getName() {
		return "This dog is a " + this.name;
	}
	
	public void noise() {
		System.out.println("Woof!");
	}
}
