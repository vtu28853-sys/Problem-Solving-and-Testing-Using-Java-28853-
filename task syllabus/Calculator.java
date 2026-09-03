import java.util.*;

class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double divide(double a, double b) {

        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return a / b;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Calculator calculator = new Calculator();

        double a = sc.nextDouble();
        String operator = sc.next();
        double b = sc.nextDouble();

        try {

            if (operator.equals("+")) {

                double result = calculator.add(a, b);

                if (result == a + b) {
                    System.out.println("Test Passed");
                } else {
                    System.out.println("Test Failed");
                }

            } else if (operator.equals("/")) {

                double result = calculator.divide(a, b);

                if (result == a / b) {
                    System.out.println("Test Passed");
                } else {
                    System.out.println("Test Failed");
                }

            } else {
                System.out.println("Test Failed");
            }

        } catch (ArithmeticException e) {
            System.out.println("Test Failed");
        }
    }
}