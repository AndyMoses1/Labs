package polymorphism;

public class Car {
	private String model;
	private double speed;

	public Car(String model, double speed) {
		this.model = model;
		this.speed = speed;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void accelerate(int seconds) {
		this.speed += 5 * seconds;
	}
	
	public void getToSixty() {
		this.setSpeed(60);
	}

}
