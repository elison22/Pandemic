package test.model.board;

import model.GameLostException;
import model.board.Board;

import static enums.CityName.ALGIERS;
import static enums.CityName.ATLANTA;
import static enums.CityName.BAGHDAD;
import static enums.CityName.BOGOTA;
import static enums.CityName.CAIRO;
import static enums.CityName.CHICAGO;
import static enums.CityName.DELHI;
import static enums.CityName.ISTANBUL;
import static enums.CityName.JOHANNESBURG;
import static enums.CityName.KARACHI;
import static enums.CityName.KHARTOUM;
import static enums.CityName.KINSHASA;
import static enums.CityName.KOLKATA;
import static enums.CityName.LAGOS;
import static enums.CityName.LONDON;
import static enums.CityName.MADRID;
import static enums.CityName.MEXICO_CITY;
import static enums.CityName.MIAMI;
import static enums.CityName.MOSCOW;
import static enums.CityName.MUMBAI;
import static enums.CityName.NEW_YORK;
import static enums.CityName.PARIS;
import static enums.CityName.RIYADH;
import static enums.CityName.SAO_PAULO;
import static enums.CityName.ST_PETERSBURG;
import static enums.CityName.SYDNEY;
import static enums.CityName.TEHRAN;
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

    public void testChainOutbreak() throws Exception {

        testBoard.infect(JOHANNESBURG, 3);
        testBoard.infect(KINSHASA, 3);

        testBoard.infect(JOHANNESBURG, 1);

        assertTrue(testBoard.getDiseaseCount(JOHANNESBURG, YELLOW) == 3);
        assertTrue(testBoard.getDiseaseCount(KINSHASA, YELLOW) == 3);
        assertTrue(testBoard.getDiseaseCount(LAGOS, YELLOW) == 1);
        assertTrue(testBoard.getDiseaseCount(KHARTOUM, YELLOW) == 2);

        testBoard.infect(KHARTOUM, 2);

        assertTrue(testBoard.getDiseaseCount(JOHANNESBURG, YELLOW) == 3);
        assertTrue(testBoard.getDiseaseCount(KINSHASA, YELLOW) == 3);
        assertTrue(testBoard.getDiseaseCount(LAGOS, YELLOW) == 3);
        assertTrue(testBoard.getDiseaseCount(KHARTOUM, YELLOW) == 3);
        assertTrue(testBoard.getDiseaseCount(SAO_PAULO, YELLOW) == 0);
        assertTrue(testBoard.getDiseaseCount(CAIRO, YELLOW) == 1);

    }

    public void testGameLostFromOutbeak() throws Exception {

        testBoard.infect(JOHANNESBURG, 3);
        testBoard.infect(KINSHASA, 3);
        testBoard.infect(JOHANNESBURG, 1);      // 2 outbreaks
        testBoard.infect(KHARTOUM, 2);          // 3 outbreaks
        testBoard.infect(ST_PETERSBURG, 3);
        testBoard.infect(ST_PETERSBURG, 1);     // 1 outbreak
        testBoard.infect(MOSCOW, 3);
        testBoard.infect(MOSCOW, 1);            // 1 outbreak
        testBoard.infect(SYDNEY, 3);

        try {
            testBoard.infect(SYDNEY, 1);     // 1 outbreaks, which should make 8 and fail
            assertTrue(false);
        } catch (GameLostException e) {}
    }

    public void testGameLostFromOverInfection() throws Exception{

        testBoard.infect(BAGHDAD, 3);
        testBoard.infect(KARACHI, 3);
        testBoard.infect(KARACHI, 1);   // 2 outbreaks
        testBoard.infect(KARACHI, 1);   // 4 outbreaks

        assertTrue(testBoard.getDiseaseCount(BAGHDAD, BLACK) == 3);
        assertTrue(testBoard.getDiseaseCount(KARACHI, BLACK) == 3);
        assertTrue(testBoard.getDiseaseCount(TEHRAN, BLACK) == 3);
        assertTrue(testBoard.getDiseaseCount(RIYADH, BLACK) == 3);
        assertTrue(testBoard.getDiseaseCount(DELHI, BLACK) == 3);
        assertTrue(testBoard.getDiseaseCount(MUMBAI, BLACK) == 2);
        assertTrue(testBoard.getDiseaseCount(MOSCOW, BLACK) == 1);
        assertTrue(testBoard.getDiseaseCount(CAIRO, BLACK) == 3);
        assertTrue(testBoard.getDiseaseCount(ISTANBUL, BLACK) == 2);

        testBoard.infect(KOLKATA, 1);
        assertTrue(testBoard.getDiseaseCount(KOLKATA, BLACK) == 1);

        try {
            testBoard.infect(ALGIERS, 1);
            assertTrue(false);
        } catch (GameLostException e) {}
    }

    private void addSomeInfection() {



    }

}
