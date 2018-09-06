package ui;

import java.util.Scanner;

import model.Choice;
import model.EndingChoice;
import model.Room;

/**
 * MonsterMazeGame class.
 *
 * @author Ziang Lu
 */
public class MonsterMazeGame {

    /**
     * Prompt message for invalid input.
     */
    private static final String INVALID_INPUT = "You have entered an invalid input. Please try again.";

    /**
     * Current room.
     */
    private Room curr;
    /**
     * Scanner used for player input.
     */
    private final Scanner scanner;
    /**
     * Whether the game is over.
     */
    private boolean gameOver;

    /**
     * Constructor with parameter.
     * @param start starting room of the game
     */
    public MonsterMazeGame(Room start) {
        curr = start;
        scanner = new Scanner(System.in);
        gameOver = false;
    }

    /**
     * Plays the game (main control loop).
     */
    public void playGame() {
        printInstructions();
        while (!gameOver) {
            String input = getPlayerInput();
            handleInput(input);
            if (gameOver) {
                break;
            }
            curr.printNextChoices();
        }
        System.out.println("The end.");
        scanner.close();
    }

    /**
     * Private helper method to print the instructions.
     */
    private void printInstructions() {
        System.out.println("Welcome to Monster Maze, a dangerous \"choose your own path\" game!");
        System.out.println("You will travel through the maze by selecting a choice out of every set of options.");
        System.out.println("Once you made a choice, there is no way back!");
        System.out.println("Enter 'Q' to quit the game at any time.");
        System.out.println("Good luck!");

        curr.printNextChoices();
    }

    /**
     * Private helper method to get player input.
     * @return player input
     */
    private String getPlayerInput() {
        String s = "";
        while (s.length() == 0) {
            if (scanner.hasNext()) {
                s += scanner.nextLine();
            }
        }
        return s.trim();
    }

    /**
     * Private helper method to handle the given input.
     * @param input given input
     */
    private void handleInput(String input) {
        if (input.length() > 0) {
            try {
                int num = Integer.parseInt(input);
                if (num > 0) {
                    handleOption(num);
                }
            } catch (NumberFormatException ex) {
                handleStateChange(input);
            }
        }
    }

    /**
     * Helper method to handle the given option in the current room.
     * @param option given option
     */
    private void handleOption(int option) {
        if ((option <= 0) || (option >= curr.getNumOfChoices())) {
            System.out.println(INVALID_INPUT);
            return;
        }
        Choice choice = curr.getChoice(option);
        if (choice instanceof EndingChoice) {
            EndingChoice ending = (EndingChoice) choice;
            ending.printOutcome();
            gameOver = true;
            return;
        }
        curr = (Room) choice;
    }

    /**
     * Helper method to handle state change according to the given input.
     * @param input given input
     */
    private void handleStateChange(String input) {
        if (input.equals("Q")) {
            gameOver = true;
        } else {
            System.out.println(INVALID_INPUT);
        }
    }

}
