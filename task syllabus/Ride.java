import java.util.*;

abstract class Ride {

    protected double distance;

    Ride(double distance) throws Exception {

        if (distance <= 0) {
            throw new Exception("Invalid distance");
        }

        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bike extends Ride {

    Bike(double distance) throws Exception {
        super(distance);
    }

    double calculateFare() {
        return distance * 5;
    }
}

class Auto extends Ride {

    Auto(double distance) throws Exception {
        super(distance);
    }

    double calculateFare() {
        return distance * 12;
    }
}

class Cab extends Ride {

    Cab(double distance) throws Exception {
        super(distance);
    }

    double calculateFare() {
        return distance * 12;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            try {

                Ride ride;

                if (type.equalsIgnoreCase("Bike")) {
                    ride = new Bike(distance);
                } else if (type.equalsIgnoreCase("Auto")) {
                    ride = new Auto(distance);
                } else if (type.equalsIgnoreCase("Cab")) {
                    ride = new Cab(distance);
                } else {
                    throw new Exception("Invalid ride type");
                }

                double fare = ride.calculateFare();

                if (fare == (int) fare) {
                    System.out.println((int) fare);
                } else {
                    System.out.println(fare);
                }

            } catch (Exception e) {
                System.out.println("Invalid Booking");
            }
        }
    }
}