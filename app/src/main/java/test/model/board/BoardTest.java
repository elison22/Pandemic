package test.model.board;

import model.GameLostException;
import model.board.Board;

import static enums.CityName.ALGIERS;
import static enums.CityName.ATLANTA;
import static enums.CityName.BOGOTA;
import static enums.CityName.CHICAGO;
import static enums.CityName.LONDON;
import static enums.CityName.MADRID;
import static enums.CityName.MEXICO_CITY;
import static enums.CityName.MIAMI;
import static enums.CityName.NEW_YORK;
import static enums.CityName.PARIS;
import static enums.CityName.SAO_PAULO;
import static enums.CityName.WASHINGTON;
import static enums.DiseaseType.BLACK;
import static enums.DiseaseType.BLUE;
import static enums.DiseaseType.RED;
import static enums.DiseaseType.YELLOW;
import static org.junit.Assert.assertTrue;

/**
 * Created by brandt on 5/30/15.
 */
public class BoardTest {

    private Board testBoard;

    public BoardTest() {
        testBoard = new Board();
    }

    public void testSingleInfect() throws Exception {

        testBoard.infect(ATLANTA, 1);
        assertTrue(testBoard.getDiseaseCount(ATLANTA, BLUE) == 1);
        testBoard.infect(ATLANTA, 2);
        assertTrue(testBoard.getDiseaseCount(ATLANTA, BLUE) == 3);
        testBoard.infect(NEW_YORK, 2);
        assertTrue(testBoard.getDiseaseCount(NEW_YORK, BLUE) == 2);
        testBoard.infect(CHICAGO, 3);
        assertTrue(testBoard.getDiseaseCount(CHICAGO, BLUE) == 3);

        assertTrue(testBoard.getDiseaseCount(ATLANTA, YELLOW) == 0);
        assertTrue(testBoard.getDiseaseCount(ATLANTA, RED) == 0);
        assertTrue(testBoard.getDiseaseCount(ATLANTA, BLACK) == 0);

        assertTrue(testBoard.getDiseaseCount(NEW_YORK, YELLOW) == 0);
        assertTrue(testBoard.getDiseaseCount(NEW_YORK, RED) == 0);
        assertTrue(testBoard.getDiseaseCount(NEW_YORK, BLACK) == 0);
    }

    public void testSingleOutbreak() throws Exception {

        testBoard.infect(MADRID, 3);
        assertTrue(testBoard.getDiseaseCount(NEW_YORK, BLUE) == 0);
        assertTrue(testBoard.getDiseaseCount(LONDON, BLUE) == 0);
        assertTrue(testBoard.getDiseaseCount(PARIS, BLUE) == 0);
        assertTrue(testBoard.getDiseaseCount(ALGIERS, BLUE) == 0);
        assertTrue(testBoard.getDiseaseCount(SAO_PAULO, BLUE) == 0);

        testBoard.infect(MADRID, 1);
        assertTrue(testBoard.getDiseaseCount(MADRID, BLUE) == 3);
        assertTrue(testBoard.getDiseaseCount(NEW_YORK, BLUE) == 1);
        assertTrue(testBoard.getDiseaseCount(LONDON, BLUE) == 1);
        assertTrue(testBoard.getDiseaseCount(PARIS, BLUE) == 1);
        assertTrue(testBoard.getDiseaseCount(ALGIERS, BLUE) == 1);
        assertTrue(testBoard.getDiseaseCount(SAO_PAULO, BLUE) == 1);
        assertTrue(testBoard.getDiseaseCount(ALGIERS, BLACK) == 0);
        assertTrue(testBoard.getDiseaseCount(SAO_PAULO, YELLOW) == 0);

        testBoard.infect(MIAMI, 2);
        assertTrue(testBoard.getDiseaseCount(BOGOTA, YELLOW) == 0);
        assertTrue(testBoard.getDiseaseCount(MEXICO_CITY, YELLOW) == 0);
        assertTrue(testBoard.getDiseaseCount(ATLANTA, YELLOW) == 0);
        assertTrue(testBoard.getDiseaseCount(WASHINGTON, YELLOW) == 0);

        testBoard.infect(MIAMI, 3);
        assertTrue(testBoard.getDiseaseCount(MIAMI, YELLOW) == 3);
        assertTrue(testBoard.getDiseaseCount(BOGOTA, YELLOW) == 1);
        assertTrue(testBoard.getDiseaseCount(MEXICO_CITY, YELLOW) == 1);
        assertTrue(testBoard.getDiseaseCount(ATLANTA, YELLOW) == 1);
        assertTrue(testBoard.getDiseaseCount(WASHINGTON, YELLOW) == 1);
        assertTrue(testBoard.getDiseaseCount(ATLANTA, BLUE) == 0);
        assertTrue(testBoard.getDiseaseCount(WASHINGTON, BLUE) == 0);

        testBoard.infect(MIAMI, 1);
        assertTrue(testBoard.getDiseaseCount(MIAMI, YELLOW) == 3);
        assertTrue(testBoard.getDiseaseCount(BOGOTA, YELLOW) == 2);
        assertTrue(testBoard.getDiseaseCount(MEXICO_CITY, YELLOW) == 2);
        assertTrue(testBoard.getDiseaseCount(ATLANTA, YELLOW) == 2);
        assertTrue(testBoard.getDiseaseCount(WASHINGTON, YELLOW) == 2);
        assertTrue(testBoard.getDiseaseCount(ATLANTA, BLUE) == 0);
        assertTrue(testBoard.getDiseaseCount(WASHINGTON, BLUE) == 0);

    }

    private void addSomeInfection() {



    }

}
