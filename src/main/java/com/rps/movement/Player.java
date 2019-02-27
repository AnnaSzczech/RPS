package com.rps.movement;

import java.util.ArrayList;

public interface Player {
    boolean isWin(Move move);
    Move getMove();
    ArrayList<Move> whichMoveComputerShouldChooseToWin();
}
