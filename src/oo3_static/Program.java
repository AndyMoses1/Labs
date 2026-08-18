package oo3_static;

import java.util.ArrayList;
import java.util.Random;

public class Program {

	public static void main(String[] args) {
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

		// Step 17: every vehicle starts from a standstill, one per lane.
		vehicles.add(new Vehicle(0, 1));
		vehicles.add(new Vehicle(0, 2));
		vehicles.add(new Vehicle(0, 3));

		Random rand = new Random();

		// Step 18: Vehicle tracks the winner itself, so nothing is passed in.
		while (!Vehicle.hasWinner()) {

			for (Vehicle vehicle : vehicles) {
				int n = rand.nextInt(10) + 1;
				vehicle.accelerate(n);

				System.out.println(vehicle.getDetails());
			}

			System.out.println();
		}

		System.out.println("Race over!");
		System.out.println("Winner: " + Vehicle.getWinner().getDetails());
		System.out.println("Vehicles created: " + Vehicle.getCount());
	}

}
