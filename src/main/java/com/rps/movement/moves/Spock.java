package com.rps.movement.moves;

import com.rps.movement.Move;
import com.rps.movement.Player;

import java.util.ArrayList;
import java.util.List;

public class Spock implements Player {
    @Override
    public boolean isWin(Move move) {
        boolean result = false;
        if (move.equals(Move.ROCK) || move.equals(Move.SCISSORS)) {
            result = true;
        }
        return result;
    }

    @Override
    public Move getMove() {
        return Move.SPOCK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != getClass()) return false;

        Spock spock = (Spock) o;

        return getMove() == spock.getMove();
    }

    @Override
    public int hashCode() {
        return getMove().hashCode();
    }

    @Override
    public ArrayList<Move> whichMoveComputerShouldChooseToWin(){
        List<Move> winningMoves = new ArrayList<>();
        winningMoves.add(Move.PAPER);
        winningMoves.add(Move.LIZARD);
        return new ArrayList<>(winningMoves);
    }
}
