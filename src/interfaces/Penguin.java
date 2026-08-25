package interfaces;

public class Penguin extends Bird implements Swimmable {

	public Penguin(String name) {
		super(name);
	}
	
	
	@Override
	public void move() {
		System.out.println("Moving like a Penguin!");
	}

	@Override
	public void swim() {
		System.out.println("Swimming like a Penguin!");
	}

	@Override
	public void makeNest() {
		System.out.println("Penguin Nest made");		
	}

	@Override
	public String getName() {
		return "This penguin is a " + this.name;
	}

}
