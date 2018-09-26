package runner;

import car.Car;
import car.CarFactory;

import java.util.Scanner;

/**
 * Application.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        System.out.print("Enter the desired max speed: ");
        Scanner scanner = new Scanner(System.in);
        int desiredMaxSpeed = 0;
        if (scanner.hasNextLine()) {
            desiredMaxSpeed = Integer.parseInt(scanner.nextLine());
        }
        // Assumption: desiredMaxSpeed > 0
        Car car = CarFactory.getCar(desiredMaxSpeed);

        // Normal way: Verify that car in fact is a Car instance instead of a null reference before proceeding
//        if (car != null) {
//            driveCar(desiredMaxSpeed, car);
//        }

        // By using Null Object Pattern, there is no need to verify that car is in fact a Car instance. We can just go
        // ahead and call methods on car.
        driveCar(desiredMaxSpeed, car);

        /*
         * Input: 80
         * Output:
         * Enter the desired max speed: 80
         * Creating a Fast Car
         * Speeding up... Current speed: 10
         * Speeding up... Current speed: 20
         * Speeding up... Current speed: 30
         * Speeding up... Current speed: 40
         * Speeding up... Current speed: 50
         * Speeding up... Current speed: 60
         * Speeding up... Current speed: 70
         * Speeding up... Current speed: 80
         * Speeding up... Current speed: 90
         *
         * Input: 150
         * Output:
         * Null Car encountere
         */
    }

    /**
     * Private static helper method to drive the given car to the given desired
     * max speed.
     * @param desiredMaxSpeed desired max speed
     * @param car car to drive
     */
    private static void driveCar(int desiredMaxSpeed, Car car) {
        while (!car.exceedingSpeed(desiredMaxSpeed)) {
            car.speedUp();
        }
    }

}
