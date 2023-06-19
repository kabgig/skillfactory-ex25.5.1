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

            System.out.print("Enter function: ");
            String function = scanner.next();
            if (isQ(function)) break;
            if (!(function.equals("+") ||
                    function.equals("-") ||
                    function.equals("*") ||
                    function.equals("/"))
            ) {
                log.info("user entered wrong function");
                System.out.println("wrong function try again");
                continue;
            }
            log.info("entered function");

            System.out.print("Enter 2nd number: ");
            String secondNumber = scanner.next();
            if (isQ(secondNumber)) break;
            log.info("entered 2nd number: " + secondNumber);

            if (function.equals("/") && secondNumber.equals("0")) {
                log.warn("user tried to /0");
                System.out.println("Can not divide by zero");
                continue;
            }
            double firstN = Double.parseDouble(firstNumber);
            double secondN = Double.parseDouble(secondNumber);

            double result = switch (function) {
                case "+" -> firstN + secondN;
                case "-" -> firstN - secondN;
                case "*" -> firstN * secondN;
                default -> firstN / secondN;
            };
        log.info("Got result: " + result);

        System.out.println("Result: " + result);
        log.info("printed result");
        }

    //------
        System.out.println("Calculator is off");
        log.info("user turned off the calculator");
    }



    private static boolean isQ(String num) {
        return num.equalsIgnoreCase("q");
    }
}