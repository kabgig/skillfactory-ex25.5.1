package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger log = LogManager.getLogger(Main.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter 'q' to quit the program");

        //-----
        while (true) {
            System.out.print("Enter 1st number: ");
            String firstNumber = scanner.next();
            if (isQ(firstNumber)) break;
            log.info("entered 1st number: " + firstNumber);

            System.out.print("Enter math operator: ");
            String mathOperator = scanner.next();
            if (isQ(mathOperator)) break;
            if (!(mathOperator.equals("+") ||
                    mathOperator.equals("-") ||
                    mathOperator.equals("*") ||
                    mathOperator.equals("/"))
            ) {
                log.info("user entered wrong mathOperator");
                System.out.println("wrong mathOperator try again");
                continue;
            }
            log.info("entered mathOperator");

            System.out.print("Enter 2nd number: ");
            String secondNumber = scanner.next();
            if (isQ(secondNumber)) break;
            log.info("entered 2nd number: " + secondNumber);

            if (mathOperator.equals("/") && secondNumber.equals("0")) {
                log.warn("user tried to /0");
                System.out.println("Can not divide by zero");
                continue;
            }
            double firstN = Double.parseDouble(firstNumber);
            double secondN = Double.parseDouble(secondNumber);

            double result = switch (mathOperator) {
                case "+" -> sumResult(firstN, secondN);
                case "-" -> subtractResult(firstN, secondN);
                case "*" -> multiResult(firstN, secondN);
                default -> divideResult(firstN, secondN);
            };
        log.info("Got result: " + result);

        System.out.println("Result: " + result);
        log.info("printed result");
        }

    //------
        System.out.println("Calculator is off");
        log.info("user turned off the calculator");
    }

    public static double divideResult(double firstN, double secondN) {
        if (secondN == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return firstN / secondN;
    }

    public static double multiResult(double firstN, double secondN) {
        return firstN * secondN;
    }

    public static double subtractResult(double firstN, double secondN) {
        return firstN - secondN;
    }

    public static double sumResult(double firstN, double secondN) {
        return firstN + secondN;
    }


    public static boolean isQ(String num) {
        return num.equalsIgnoreCase("q");
    }
}