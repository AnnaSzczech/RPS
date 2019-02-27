package com.rps.game;

import com.rps.movement.Move;
import com.rps.movement.Player;
import com.rps.score.Round;
import com.rps.score.ScoreBoard;

import java.util.Scanner;

public class Game {
    private int counter = 0;
    private boolean isTheEndOfTheGame = false;
    private int numberOfRounds;
    private String name;
    private ScoreBoard scoreBoard = new ScoreBoard();
    private Scanner sc = new Scanner(System.in);
    private boolean isEasyLvl = true;


    public void newRound(){
        counter++;
        System.out.println("\nRunda: " + counter);
    }

    public void printInformation(){
        System.out.println("Jak masz na imię?");
        name = sc.nextLine();
        howManyRounds();
        selectTheLvl();
        System.out.println("\nInformacja dot. klawiszy służących do obsługi gry:\n" +
                "    klawisz 1 - zagranie \"kamień\",\n" +
                "    klawisz 2 - zagranie \"papier\",\n" +
                "    klawisz 3 - zagranie \"nożyce\",\n" +
                "    klawisz 4 - zagranie \"jaszczurka\",\n" +
                "    klawisz 5 - zagranie \"spock\",\n" +
                "    klawisz x - zakończenie gry, poprzedzone pytaniem \"Czy na pewno zakończyć grę?\",\n" +
                "    klawisz n - uruchomienie gry od nowa, poprzedzone pytaniem \"Czy na pewno zakończyć aktualną grę?\",");
    }

    public void selectTheLvl(){
        System.out.println("Czy poziom gry ma być łatwy T/N?");
        String easyOrDifficultLvl = sc.nextLine();
        if (!isYes(easyOrDifficultLvl)) {
            System.out.println("ma byc trudny");
            isEasyLvl = false;
        }
    }

    public void howManyRounds(){
        try {
            System.out.println("Po ilu wygranych rundach następuje zwycięstwo?");
            numberOfRounds = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawna liczba!");
            howManyRounds();
        }
    }

    public void run(){
        printInformation();
        while (!isTheEndOfTheGame){
            scoreBoard.printResults();
            newRound();
            System.out.println(name + " wykonaj ruch.");
            String move = sc.nextLine();
            readTheMove(move);
        }
    }

    public void readTheMove(String move){
        try {
            Runnable run = () -> makeMove(Move.returnSelectedMove(move));
            run.run();
        } catch (Exception e) {
            noMoveSelected(move);
        }
    }

    public void noMoveSelected(String move){
        switch (move) {
            case "x":
                exitTheGame();
                break;
            case "n":
                startNewGame();
                break;
            default:
                System.out.println("Wybrano niewłaściwy klawisz!");
                counter--;
        }
    }

    public void makeMove(Player userMove){
        Player computerMove = drawComputerMove(userMove);
        scoreBoard.addRoundToBoard(new Round(userMove, computerMove), counter);
        checkIfTheGameIsOver();
    }

    public void checkIfTheGameIsOver(){
        if (isUserWin() || isComputerWin()){
            isTheEndOfTheGame = true;
            scoreBoard.printHistoryOfGame();
        }
    }

    public boolean isUserWin(){
        return scoreBoard.getResults().getPlayerPoints() >= numberOfRounds;
    }

    public boolean isComputerWin(){
        return scoreBoard.getResults().getComputerPoints() >= numberOfRounds;
    }

    public void exitTheGame(){
        System.out.println("Napewno chcesz zakończyć grę T/N?");
        String isEndOfTheGame = sc.nextLine();
        if (isYes(isEndOfTheGame)) {
            isTheEndOfTheGame = true;
            scoreBoard.printResults();
        } else {
            counter--;
        }
    }

    public void startNewGame(){
        System.out.println("Napewno chcesz rozpocząć nową grę T/N?");
        String isEndOfTheGame = sc.nextLine();
        if (isYes(isEndOfTheGame)) {
            resetVariables();
            printInformation();
        } else {
            counter--;
        }
    }

    public void resetVariables(){
        counter = 0;
        scoreBoard.startNewGame();
        isEasyLvl = true;
    }

    public boolean isYes(String isEndOfTheGame){
        return isEndOfTheGame.substring(0, 1).equalsIgnoreCase("T");
    }

    public Player drawComputerMove(Player userMove){
        ComputerLogic computerLogic = new ComputerLogic(isEasyLvl, userMove);
        return computerLogic.selectTheMove();
    }
}
