package com.rps.movement.moves;

import com.rps.movement.Move;
import com.rps.movement.Player;

import java.util.ArrayList;
import java.util.List;

public class Lizard implements Player {
    @Override
    public boolean isWin(Move move) {
        boolean result = false;
        if (move.equals(Move.SPOCK) || move.equals(Move.PAPER)) {
            result = true;
        }
        return result;
    }

    @Override
    public Move getMove() {
        return Move.LIZARD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != getClass()) return false;

        Lizard lizard = (Lizard) o;

        return getMove() == lizard.getMove();
    }

    @Override
    public int hashCode() {
        return getMove().hashCode();
    }

    @Override
    public ArrayList<Move> whichMoveComputerShouldChooseToWin(){
        List<Move> winningMoves = new ArrayList<>();
        winningMoves.add(Move.ROCK);
        winningMoves.add(Move.SCISSORS);
        return new ArrayList<>(winningMoves);
    }
}
