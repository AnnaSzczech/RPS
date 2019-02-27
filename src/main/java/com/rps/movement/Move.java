package com.rps.movement;

import com.rps.movement.moves.*;

import java.util.Arrays;

public enum Move {
    ROCK("1", new Rock()), PAPER("2", new Paper()), SCISSORS("3", new Scissors()),
    LIZARD("4", new Lizard()), SPOCK("5", new Spock());

    private final String selectedMove;
    private final Player player;


    Move(final String selectedMove, final Player player){
        this.selectedMove = selectedMove;
        this.player = player;
    }

    public static Player returnSelectedMove(String selectedMove) {
        return Arrays.stream(values()).filter(move -> move.selectedMove.equals(selectedMove)).findFirst().get().player;
    }

    public String toString() {
        return super.toString().toLowerCase();
    }

    public Player getPlayer() {
        return player;
    }
}
