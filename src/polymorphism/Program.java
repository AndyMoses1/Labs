package polymorphism;

public class Program {

	public static void main(String[] args) {
		Car[] cars = {
			new Car("Ford", 0),
			new RacingCar("Ferrari", 0, "Andy", 3),
			new Car("VW", 10),
			new RacingCar("McLaren", 0, "Lewis", 4)
		};

		processCars(cars);
	}

	private static void processCars(Car[] cars) {
		for (Car car : cars) {
			car.getToSixty();

			car.accelerate(2);

			System.out.printf("%-12s speed %.2f", car.getModel(), car.getSpeed());

			if (car instanceof RacingCar) {
				RacingCar racingCar = (RacingCar) car;
				System.out.printf("  driver %s", racingCar.getDriver());
			}

			System.out.println();
		}
	}

}
