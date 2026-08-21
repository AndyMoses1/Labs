package polymorphism;

public class RacingCar extends Car {
	private String driver;
	private int turboFactor;

	public RacingCar(String model, double speed, String driver, int turboFactor) {
		super(model, speed);
		this.driver = driver;
		this.turboFactor = turboFactor;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public int getTurboFactor() {
		return turboFactor;
	}

	public void setTurboFactor(int turboFactor) {
		this.turboFactor = turboFactor;
	}

	@Override
	public void accelerate(int seconds) {
		super.accelerate(seconds);
		setSpeed(getSpeed() * turboFactor);
	}

}
