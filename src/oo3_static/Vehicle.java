package oo3_static;

public class Vehicle {

	private int speed;
	private int lane;
	private int distanceTravelled;
	public RegistrationPlate registrationPlate;

	private static int count = 0;

	// static: the race belongs to the class, not to any one vehicle, so the
	// class can answer "is there a winner?" without being handed a list.
	private static final int WINNING_DISTANCE = 1000;
	private static Vehicle winner;

	public Vehicle(int speed, int lane) {
		this.speed = speed;
		this.lane = lane;

		registrationPlate = RegistrationPlateFactory.getNextRegistrationPlate();

		count++;
	}

	public void accelerate(int amount) {
		speed += amount;

		if (speed > 200) {
			speed = 200;
		}

		distanceTravelled += amount;

		// First past the post claims it; a later crossing cannot overwrite it.
		if (winner == null && distanceTravelled > WINNING_DISTANCE) {
			winner = this;
		}
	}

	public void brake(int amount) {
		if (amount < 0) {
			System.out.println("Error: brake amount cannot be negative.");
            return;
		}
		
		speed -= amount;

		if (speed < 0) {
			speed = 0;
		}
	}


	public static int getCount() {
		return count;
	}

	// No parameter needed - the class already knows.
	public static boolean hasWinner() {
		return winner != null;
	}

	public static Vehicle getWinner() {
		return winner;
	}

	// Needed by the race loop so it can test the finish condition.
	public int getDistanceTravelled() {
		return distanceTravelled;
	}

	public String getDetails() {
		String plateNumber = registrationPlate == null
				? "unassigned"
				: registrationPlate.getNumber();

		return String.format("Plate %s | speed %d | lane %d | distance travelled %d",
				plateNumber, speed, lane, distanceTravelled);
	}

}
