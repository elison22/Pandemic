package model;


import org.junit.*;
import static org.junit.Assert.*;

import static enums.CityName.*;
import static enums.DiseaseType.*;
import model.board.Board;

/**
 * Created by brandt on 5/30/15.
 */
public class BoardTest {

    private Board testBoard;

    @Before
    public void setup() {
        testBoard = new Board();
    }

    @Test
    public void testSingleInfect() {

        try {
            testBoard.infect(ATLANTA, 1);
            assertTrue(testBoard.getDiseaseCount(ATLANTA, BLUE) == 1);
            testBoard.infect(ATLANTA, 2);
            assertTrue(testBoard.getDiseaseCount(ATLANTA, BLUE) == 3);
            testBoard.infect(NEW_YORK, 2);
            assertTrue(testBoard.getDiseaseCount(NEW_YORK, BLUE) == 2);

            assertTrue(testBoard.getDiseaseCount(ATLANTA, YELLOW) == 0);
            assertTrue(testBoard.getDiseaseCount(ATLANTA, RED) == 0);
            assertTrue(testBoard.getDiseaseCount(ATLANTA, BLACK) == 0);

            assertTrue(testBoard.getDiseaseCount(NEW_YORK, YELLOW) == 0);
            assertTrue(testBoard.getDiseaseCount(NEW_YORK, RED) == 0);
            assertTrue(testBoard.getDiseaseCount(NEW_YORK, BLACK) == 0);

        } catch (GameLostException e) {
            e.printStackTrace();
            assertTrue(false);
        }

    }


}
