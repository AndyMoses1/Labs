package abstract2;

public class Duck extends Bird {

	public Duck(String name) {
		super(name);
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
