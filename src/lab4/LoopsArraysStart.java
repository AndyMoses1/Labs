package lab4;

public class LoopsArraysStart {

    public static void main(String[] args) {
        int[] numbers = {1, 3, -5, 7, 0, 4, 6, 8};

        double sum = calculateSum(numbers);
        double average = calculateAverage(numbers);
        int min = findMinimum(numbers);
        int max = findMaximum(numbers);
        int zeroIndex = findIndexOfZero(numbers);

        System.out.printf("Sum:        %.0f%n", sum);
        System.out.printf("Average:    %.2f%n", average);
        System.out.printf("Minimum:    %d%n", min);
        System.out.printf("Maximum:    %d%n", max);
        System.out.printf("Index of 0: %s%n",
                zeroIndex < 0 ? "Index not found" : zeroIndex);
    }

    private static double calculateSum(int[] numbers) {
        double sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static double calculateAverage(int[] numbers) {
        return calculateSum(numbers) / numbers.length;
    }

    private static int findMinimum(int[] numbers) {
        int min = numbers[0];

        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }

        return min;
    }

    private static int findMaximum(int[] numbers) {
        int max = numbers[0];

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }

    private static int findIndexOfZero(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}


// First pass of code, all in main method
//public class Program {
//
//	public static void main(String[] args) {
//		int[] numbers = {1, 3, -5, 7, 0, 4, 6, 8};
//
//		double sum = 0;
//
//		// Tasks 1, 3 & 4 can be combined in the loop: start with the first element
//		int min = numbers[0];
//		int max = numbers[0];
//		
//		for (int number : numbers) {
//			//Task 1 
//			sum += number;
//			
//			//Task 3
//			if (number < min) {
//				min = number;
//			}
//			//Task 4
//			if (number > max) {
//				max = number;
//			}
//		}
//		
//		double average = sum / numbers.length;
//		
//
//		// Task 5: -1 means "not found", so it stays -1 if there is no zero
//		int zeroIndex = -1;
//		
//		for (int i = 0; i < numbers.length; i++) {
//			if (numbers[i] == 0) {
//		        zeroIndex = i;
//		        break;
//		    }
//		}
//
//
//		System.out.printf("Sum:        %.0f%n", sum);
//		
//		System.out.printf("Average:    %.2f%n", average);
//
//		System.out.printf("Minimum:    %d%n", min);		
//
//		System.out.printf("Maximum:    %d%n", max);
//		
//		System.out.printf("Index of 0: %s%n", zeroIndex < 0 ? "Index not found" : zeroIndex);
//	}
//
//}
