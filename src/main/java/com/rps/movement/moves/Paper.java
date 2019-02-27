package com.rps.movement.moves;

import com.rps.movement.Move;
import com.rps.movement.Player;

import java.util.ArrayList;
import java.util.List;

public class Paper implements Player {
    public Move getMove() {
        return Move.PAPER;
    }

    public boolean isWin(Move move) {
        boolean result = false;
        if (move.equals(Move.ROCK) || move.equals(Move.SPOCK)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != getClass()) return false;

        Paper paper = (Paper) o;

        return getMove() == paper.getMove();
    }

    @Override
    public int hashCode() {
        return getMove().hashCode();
    }

    @Override
    public ArrayList<Move> whichMoveComputerShouldChooseToWin(){
        List<Move> winningMoves = new ArrayList<>();
        winningMoves.add(Move.LIZARD);
        winningMoves.add(Move.SCISSORS);
        return new ArrayList<>(winningMoves);
    }
}
