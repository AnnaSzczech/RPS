package com.rps.score;

public class Points {
    private int computerPoints = 0;
    private int userPoints = 0;

    public void addPointsToComputer(){
        computerPoints++;
    }

    public void addPointsToPlayer(){
        userPoints++;
    }

    public void resetPoints(){
        computerPoints = 0;
        userPoints = 0;
    }

    public int getComputerPoints() {
        return computerPoints;
    }

    public int getPlayerPoints() {
        return userPoints;
    }

    @Override
    public String toString() {
        return "Punkty gracza : Punkty komputera\n" +
                "        " + userPoints + "     :      " + computerPoints;
    }
}
