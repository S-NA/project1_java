/**
 *
 * @author Simone
 */
package project1;

import java.util.Scanner;

public class Project1 {

    static void displayMenu() {
        System.out.println("\nPlease choose one of the following options for your math quiz:");
        System.out.println("1. Addition with numbers 1­10");
        System.out.println("2. Addition with numbers 1­100");
        System.out.println("3. Subtraction with numbers 1­10");
        System.out.println("4. Subtraction with numbers 1­100");
        System.out.println("5. Multiplication with numbers 1­10");
        System.out.println("6. Exit the program\n");
    }

    static int quizEngine(int lowerBound, int upperBound, char operator) {
        int amountCorrect = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int num1 = (int) (lowerBound + Math.random() * (upperBound - lowerBound + 1));
            int num2 = (int) (lowerBound + Math.random() * (upperBound - lowerBound + 1));
            int correctAnswer = 0;
            switch (operator) {
                case '+':
                    correctAnswer = num1 + num2;
                    break;
                case '-':
                    correctAnswer = num1 - num2;
                    break;
                case '*':
                    correctAnswer = num1 * num2;
                    break;
            }
            System.out.printf("\nEnter the answer to the following problem: %d %c %d\n", num1, operator, num2);
            int userAnswer = input.nextInt();
            if (userAnswer == correctAnswer) {
                amountCorrect += 1;
                System.out.println("That is the correct answer!");
            } else {
                System.out.printf("Sorry, that is incorrect. The correct answer is %d\n", correctAnswer);
            }
        }
        return amountCorrect;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the of Math!");
        int amountCorrect = 0, problemsAttempted = 0;
        Boolean quit = false;
        while (!quit) {
            displayMenu();
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    problemsAttempted += 5;
                    amountCorrect += quizEngine(1, 10, '+');
                    break;
                case 2:
                    problemsAttempted += 5;
                    amountCorrect += quizEngine(1, 100, '+');
                    break;
                case 3:
                    problemsAttempted += 5;
                    amountCorrect += quizEngine(1, 10, '-');
                    break;
                case 4:
                    problemsAttempted += 5;
                    amountCorrect += quizEngine(1, 100, '-');
                    break;
                case 5:
                    problemsAttempted += 5;
                    amountCorrect += quizEngine(1, 10, '*');
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Valid choices are 1­6; please re­enter.");
            }
        }
        float percentage = 0;
        if (problemsAttempted != 0) {
            percentage = (amountCorrect / (float) problemsAttempted) * 100;
        }

        System.out.printf("\nYou got %d problems correct out of %d problems attempted. That is %.2f percent correct. Goodbye!\n", amountCorrect, problemsAttempted, percentage);
    }
}
