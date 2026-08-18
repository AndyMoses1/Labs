package oo3_static;

import java.util.ArrayList;
import java.util.Random;

public class Program {

	public static void main(String[] args) {
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

		vehicles.add(new Vehicle(0, 1));
		vehicles.add(new Vehicle(0, 2));
		vehicles.add(new Vehicle(0, 3));
		
		//quick check of -ve brake
		vehicles.get(0).brake(-100);

		Random rand = new Random();

		while (!hasWinner(vehicles)) {

			for (Vehicle vehicle : vehicles) {
				int n = rand.nextInt(10) + 1;
				vehicle.accelerate(n);

				System.out.println(vehicle.getDetails());
			}

			System.out.println();
		}

		Vehicle winner = getWinner(vehicles);

		System.out.println("Race over!");
		System.out.println("Winner: " + winner.getDetails());
		System.out.println("Vehicles created: " + Vehicle.getCount());
	}

	private static boolean hasWinner(ArrayList<Vehicle> vehicles) {
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getDistanceTravelled() >= 1000) {
				return true;
			}
		}

		return false;
	}

	private static Vehicle getWinner(ArrayList<Vehicle> vehicles) {
		Vehicle winner = vehicles.get(0);

		for (Vehicle vehicle : vehicles) {
			if (vehicle.getDistanceTravelled() > winner.getDistanceTravelled()) {
				winner = vehicle;
			}
		}

		return winner;
	}

}
