package com.rps;

import com.rps.game.ComputerLogic;
import com.rps.movement.Move;
import com.rps.movement.Player;
import com.rps.movement.moves.Paper;
import org.junit.*;

import java.util.List;

public class ComputerLogicTestSuite {
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

    //Test 1: Sprawdzenie, czy do listy ruchów które przegrają z Papierem zostanie dodany Kamień i Spock
    @Test
    public void testCheckWhichMoveIsWinningAndWhichIsNotNotWinningMove(){
        //given
        ComputerLogic computerLogic = new ComputerLogic(false, new Paper());
        computerLogic.checkWhichMoveIsWinningAndWhichIsNot();
        //when
        List<Move> notWinningMove = computerLogic.getNotWinningMove();
        //then
        Assert.assertEquals(2, notWinningMove.size());
        Assert.assertEquals("rock", notWinningMove.get(0).toString());
        Assert.assertEquals("spock", notWinningMove.get(1).toString());
        System.out.println("notWinningMove - correct");
    }

    //Test 2: Sprawdzenie, czy do listy ruchów które wygrają z Papierem zostanie dodana Jaszczurka i Nożyce
    @Test
    public void testCheckWhichMoveIsWinningAndWhichIsNotWinningMove(){
        //given
        ComputerLogic computerLogic = new ComputerLogic(false, new Paper());
        //when
        computerLogic.checkWhichMoveIsWinningAndWhichIsNot();
        List<Move> winningMove = computerLogic.getWinningMove();
        //then
        Assert.assertEquals(2, winningMove.size());
        Assert.assertEquals("lizard", winningMove.get(0).toString());
        Assert.assertEquals("scissors", winningMove.get(1).toString());
        System.out.println("winningMove - correct");
    }

    //Test 3. Sprawdzenie czy komputer wygra, gdy wylosowana liczba jest większa niż 50
    @Test
    public void testReduceThePlayersChancesWhenRandomNumberIsBiggerThan50(){
        //given
        ComputerLogic computerLogic = new ComputerLogic(false, new Paper());
        computerLogic.checkWhichMoveIsWinningAndWhichIsNot();
        //when
        Player computerMove = computerLogic.reduceThePlayersChances(51);
        //then
        Assert.assertTrue(computerMove.isWin(Move.PAPER));
        System.out.println("Checking if computer wins when random number is bigger than 50");
    }

    //Test 4. Sprawdzenie czy komputer przegra, gdy wylosowana liczba jest większa niż 25 i mniejsza niż 51
    @Test
    public void testReduceThePlayersChancesWhenRandomNumberIsBiggerThan25AndLowerThen51(){
        //given
        ComputerLogic computerLogic = new ComputerLogic(false, new Paper());
        computerLogic.checkWhichMoveIsWinningAndWhichIsNot();
        //when
        Player computerMove = computerLogic.reduceThePlayersChances(35);
        //then
        Assert.assertFalse(computerMove.isWin(Move.PAPER));
        System.out.println("Checking if computer loses when random number is bigger than 25 and lower than 51");
    }

    //Test 5. Sprawdzenie czy komputer zremisuje, gdy wylosowana liczba jest mniejsza niż 26
    @Test
    public void testReduceThePlayersChancesWhenRandomNumberIsLowerThen26(){
        //given
        ComputerLogic computerLogic = new ComputerLogic(false, new Paper());
        computerLogic.checkWhichMoveIsWinningAndWhichIsNot();
        //when
        Player computerMove = computerLogic.reduceThePlayersChances(15);
        //then
        Assert.assertTrue(computerMove.getMove().equals(Move.PAPER));
        System.out.println("Checking if computer will draw with player when random number is lower than 26");
    }
}
