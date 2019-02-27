package com.rps.game;

import com.rps.movement.Move;
import com.rps.movement.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ComputerLogic {
    private boolean isEasyLvl;
    private Player userMove;
    private List<Move> winningMove;
    private List<Move> notWinningMove = new ArrayList<>();

    public ComputerLogic(boolean isEasyLvl, Player userMove) {
        this.isEasyLvl = isEasyLvl;
        this.userMove = userMove;
    }

    public Player selectTheMove(){
        Player selectedMove;
        if (isEasyLvl){
            selectedMove = selectTheMoveInEasyMode();
        } else {
            selectedMove = selectTheMoveInDifficultMode();
        }
        return selectedMove;
    }

    private Player selectTheMoveInEasyMode(){
        String selectedMove = String.valueOf((int) (Math.random()*5 + 1));
        Supplier supplier = () -> Move.returnSelectedMove(selectedMove);
        Player computerMove = (Player) supplier.get();
        return computerMove;
    }

    public Player selectTheMoveInDifficultMode(){
        checkWhichMoveIsWinningAndWhichIsNot();
        int randomNumber = (int) (Math.random()*100 + 1);
        return reduceThePlayersChances(randomNumber);
    }

    public Player reduceThePlayersChances(int randomNumber){
        // Zmniejszenie szans gracza --> 50% szansy na wygraną komputera, 25% na remis, 25% na przegraną
        Player computerMove;
        if (randomNumber > 50) {
            computerMove = winningMove.get((int) (Math.random()*2)).getPlayer();
        } else if (randomNumber > 25){
            computerMove = notWinningMove.get((int) (Math.random()*2)).getPlayer();
        } else {
            computerMove = userMove;
        }
        return computerMove;
    }

    public void checkWhichMoveIsWinningAndWhichIsNot(){
        winningMove = userMove.whichMoveComputerShouldChooseToWin();
        createTableWithAllPossibleMoves();
        notWinningMove.remove(winningMove.get(0));
        notWinningMove.remove(winningMove.get(1));
        notWinningMove.remove(userMove.getMove());
    }

    private void createTableWithAllPossibleMoves(){
        notWinningMove.add(Move.LIZARD);
        notWinningMove.add(Move.PAPER);
        notWinningMove.add(Move.ROCK);
        notWinningMove.add(Move.SCISSORS);
        notWinningMove.add(Move.SPOCK);
    }

    public List<Move> getWinningMove() {
        return winningMove;
    }

    public List<Move> getNotWinningMove() {
        return notWinningMove;
    }
}
