package abstract2;

public class Penguin extends Bird {

	public Penguin(String name) {
		super(name);
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
