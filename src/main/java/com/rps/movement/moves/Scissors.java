package com.rps.movement.moves;

import com.rps.movement.Move;
import com.rps.movement.Player;

import java.util.ArrayList;
import java.util.List;

public class Scissors implements Player {
    public Move getMove() {
        return Move.SCISSORS;
    }

    public boolean isWin(Move move){
        boolean result = false;
        if (move.equals(Move.PAPER) || move.equals(Move.LIZARD)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != getClass()) return false;

        Scissors scissors = (Scissors) o;

        return getMove() == scissors.getMove();
    }

    @Override
    public int hashCode() {
        return getMove().hashCode();
    }

    @Override
    public ArrayList<Move> whichMoveComputerShouldChooseToWin(){
        List<Move> winningMoves = new ArrayList<>();
        winningMoves.add(Move.ROCK);
        winningMoves.add(Move.SPOCK);
        return new ArrayList<>(winningMoves);
    }
}
