package com.rps.score;

import com.rps.movement.Move;
import com.rps.movement.Player;

import java.util.HashMap;
import java.util.Map;

public class ScoreBoard {
    private final Map<Integer, Round> listOfRounds = new HashMap<>();
    Points results = new Points();

    public void addRoundToBoard(Round roundResult, int counter){
        listOfRounds.put(counter, roundResult);
        Move playerMove = roundResult.getPlayerMove().getMove();
        Move computerMove = roundResult.getComputerMove().getMove();
        System.out.println("player - " + playerMove + " : computer - " + computerMove +"\n");
        if (!playerMove.equals(computerMove)) {
            setThePoint(roundResult.getPlayerMove(), roundResult.getComputerMove());
        }
    }

    public void setThePoint(Player playerMove, Player computerMove){
        if (playerMove.isWin(computerMove.getMove())){
            results.addPointsToPlayer();
        } else {
            results.addPointsToComputer();
        }
    }

    public void startNewGame(){
        results.resetPoints();
        listOfRounds.clear();
    }

    public void printResults(){
        if (!(results.getComputerPoints() == 0 && results.getPlayerPoints() == 0)) {
            System.out.println(results);
        }
    }

    public void printHistoryOfGame(){
        System.out.println("\n<> History of Game <>");
        for (Map.Entry<Integer, Round> round : listOfRounds.entrySet()) {
            System.out.println(round.getKey() + ". " + round.getValue());
        }
        System.out.println("\n<> FINALE SCORE <>");
        printResults();
    }

    public Points getResults() {
        return results;
    }
}
