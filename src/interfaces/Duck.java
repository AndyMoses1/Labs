package interfaces;

public class Duck extends Bird implements Flyable, Swimmable {

	public Duck(String name) {
		super(name);
	}

	@Override
	public void move() {
		System.out.println("Moving like a Duck!");
	}

	@Override
	public void fly() {
		System.out.println("Flying like a Duck!");
	}

	@Override
	public void swim() {
		System.out.println("Swimming like a Duck!");
	}

	@Override
	public void makeNest() {
		System.out.println("Duck Nest made");
	}

	@Override
	public String getName() {
		return "This duck is a " + this.name;
	}

}
