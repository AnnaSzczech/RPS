package com.rps;

import com.rps.movement.moves.Paper;
import com.rps.movement.moves.Rock;
import com.rps.score.Round;
import com.rps.score.ScoreBoard;
import org.junit.*;

public class ScoreBoardTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("\nAll tests are finished.");
    }

    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("\nPreparing to execute test #" + testCounter);
    }

    @Test
    public void testAddRoundToBoardWhenPlayerWins(){
        //given
        System.out.println("Testing method - addRoundToBoard(new Paper(), new Rock(), 1)");
        ScoreBoard scoreBoard = new ScoreBoard();
        //when
        scoreBoard.addRoundToBoard(new Round(new Paper(), new Rock()), 1);
        //when
        Assert.assertEquals(1, scoreBoard.getResults().getPlayerPoints());
        Assert.assertEquals(0, scoreBoard.getResults().getComputerPoints());
    }

    @Test
    public void testAddRoundToBoardWhenComputerWins(){
        //given
        System.out.println("Testing method - addRoundToBoard(new Rock(), new Paper(), 1)");
        ScoreBoard scoreBoard = new ScoreBoard();
        //when
        scoreBoard.addRoundToBoard(new Round(new Rock(), new Paper()), 1);
        //when
        Assert.assertEquals(0, scoreBoard.getResults().getPlayerPoints());
        Assert.assertEquals(1, scoreBoard.getResults().getComputerPoints());
    }

    @Test
    public void testAddRoundToBoardWhenIsDraw(){
        //given
        System.out.println("Testing method - addRoundToBoard(new Paper(), new Paper(), 1)");
        ScoreBoard scoreBoard = new ScoreBoard();
        //when
        scoreBoard.addRoundToBoard(new Round(new Paper(), new Paper()), 1);
        //when
        Assert.assertEquals(0, scoreBoard.getResults().getPlayerPoints());
        Assert.assertEquals(0, scoreBoard.getResults().getComputerPoints());
    }
}
