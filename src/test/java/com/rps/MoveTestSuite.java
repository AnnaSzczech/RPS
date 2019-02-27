package com.rps;

import com.rps.movement.Move;
import com.rps.movement.Player;
import org.junit.Assert;
import org.junit.Test;

public class MoveTestSuite {
    @Test
    public void testReturnSelectedMove(){
        //given
        Player rock = Move.returnSelectedMove("1");
        Player paper = Move.returnSelectedMove("2");
        Player scissors = Move.returnSelectedMove("3");
        Player lizard = Move.returnSelectedMove("4");
        Player spock = Move.returnSelectedMove("5");

        //when
        //then
        Assert.assertEquals(Move.ROCK, rock.getMove());
        Assert.assertEquals(Move.PAPER, paper.getMove());
        Assert.assertEquals(Move.SCISSORS, scissors.getMove());
        Assert.assertEquals(Move.LIZARD, lizard.getMove());
        Assert.assertEquals(Move.SPOCK, spock.getMove());
    }
}
