package com.sda.safta;

import java.util.Random;

public class GuessingGame {

    private final int MAXIMUM_NUMBER_OF_TRIES = 3;
    private int guessCount;
    private int randomNumber;

    public void startGame() {
        randomNumber = new Random().nextInt(100);
        System.out.println("In order to win this game you must guess a random number from 1 to 100 in maximum 10 tries. Please insert a number to guess it");
        playTheGame();
        ScannerUtils.getScanner().close();
    }

    private void playTheGame() {
        int insertedNumber;
        do {
            insertedNumber = ScannerUtils.getIntFromConsole();
            guessCount++;
        } while (!isTheGameFinished(insertedNumber));
    }

    private boolean isTheGameFinished(int number) {
        return hasReachedTheLimitOfTries() || isTheCorrectNumber(number);
    }

    private boolean hasReachedTheLimitOfTries() {
        boolean reachedLimit = guessCount >= MAXIMUM_NUMBER_OF_TRIES;
        if (reachedLimit)
            System.out.println("You loose because you reached the maximum number of guess");
        return reachedLimit;
    }

    private boolean isTheCorrectNumber(int number) {
        boolean isCorrect = false;
        if (number > randomNumber) {
            System.out.println("Your number is grater than the correct number. Try again");
        } else if (number < randomNumber) {
            System.out.println("Your number is smaller than the correct number. Try again");
        } else {
            System.out.println("Congrats, you win! The guessed number was " + number);
            isCorrect = true;
        }
        return isCorrect;
    }
}
