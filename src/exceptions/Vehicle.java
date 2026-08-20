package exceptions;

public class Vehicle {

	private int speed;
	private int lane;
	private int distanceTravelled;
	public RegistrationPlate registrationPlate;

	private static int count = 0;

	private static final int WINNING_DISTANCE = 1000;
	private static Vehicle winner;

	public Vehicle(int speed, int lane) throws OutOfRegistrationPlatesException {
		this.speed = speed;
		this.lane = lane;

		registrationPlate = RegistrationPlateFactory.getNextRegistrationPlate();

		// Deliberately after the plate. A vehicle that failed to be created
		// must not be counted.
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

	public String getDetails() {
		// The constructor throws rather than accepting a null plate, so there
		// is always one here.
		return String.format("Plate %s | speed %d | lane %d | distance travelled %d",
				registrationPlate.getNumber(), speed, lane, distanceTravelled);
	}

}
