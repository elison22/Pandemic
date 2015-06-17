package test.model.board;

import model.GameLostException;
import model.board.Board;

import static enums.CityName.ALGIERS;
import static enums.CityName.ATLANTA;
import static enums.CityName.BAGHDAD;
import static enums.CityName.BOGOTA;
import static enums.CityName.CAIRO;
import static enums.CityName.CHENNAI;
import static enums.CityName.CHICAGO;
import static enums.CityName.DELHI;
import static enums.CityName.HONG_KONG;
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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
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
        assertEquals(1, testBoard.getDiseaseCount(ATLANTA, BLUE));
        testBoard.infect(ATLANTA, 2);
        assertEquals(3, testBoard.getDiseaseCount(ATLANTA, BLUE));
        testBoard.infect(NEW_YORK, 2);
        assertEquals(2, testBoard.getDiseaseCount(NEW_YORK, BLUE));
        testBoard.infect(CHICAGO, 3);
        assertEquals(3, testBoard.getDiseaseCount(CHICAGO, BLUE));

        assertEquals(0, testBoard.getDiseaseCount(ATLANTA, YELLOW));
        assertEquals(0, testBoard.getDiseaseCount(ATLANTA, RED));
        assertEquals(0, testBoard.getDiseaseCount(ATLANTA, BLACK));

        assertEquals(0, testBoard.getDiseaseCount(NEW_YORK, YELLOW));
        assertEquals(0, testBoard.getDiseaseCount(NEW_YORK, RED));
        assertEquals(0, testBoard.getDiseaseCount(NEW_YORK, BLACK));
    }

    public void testSingleOutbreak() throws Exception {

        testBoard.infect(MADRID, 3);
        assertEquals(0, testBoard.getDiseaseCount(NEW_YORK, BLUE));
        assertEquals(0, testBoard.getDiseaseCount(LONDON, BLUE));
        assertEquals(0, testBoard.getDiseaseCount(PARIS, BLUE));
        assertEquals(0, testBoard.getDiseaseCount(ALGIERS, BLUE));
        assertEquals(0, testBoard.getDiseaseCount(SAO_PAULO, BLUE));

        testBoard.infect(MADRID, 1);
        assertEquals(3, testBoard.getDiseaseCount(MADRID, BLUE));
        assertEquals(1, testBoard.getDiseaseCount(NEW_YORK, BLUE));
        assertEquals(1, testBoard.getDiseaseCount(LONDON, BLUE));
        assertEquals(1, testBoard.getDiseaseCount(PARIS, BLUE));
        assertEquals(1, testBoard.getDiseaseCount(ALGIERS, BLUE));
        assertEquals(1, testBoard.getDiseaseCount(SAO_PAULO, BLUE));
        assertEquals(0, testBoard.getDiseaseCount(ALGIERS, BLACK));
        assertEquals(0, testBoard.getDiseaseCount(SAO_PAULO, YELLOW));

        testBoard.infect(MIAMI, 2);
        assertEquals(0, testBoard.getDiseaseCount(BOGOTA, YELLOW));
        assertEquals(0, testBoard.getDiseaseCount(MEXICO_CITY, YELLOW));
        assertEquals(0, testBoard.getDiseaseCount(ATLANTA, YELLOW));
        assertEquals(0, testBoard.getDiseaseCount(WASHINGTON, YELLOW));

        testBoard.infect(MIAMI, 3);
        assertEquals(3, testBoard.getDiseaseCount(MIAMI, YELLOW));
        assertEquals(1, testBoard.getDiseaseCount(BOGOTA, YELLOW));
        assertEquals(1, testBoard.getDiseaseCount(MEXICO_CITY, YELLOW));
        assertEquals(1, testBoard.getDiseaseCount(ATLANTA, YELLOW));
        assertEquals(1, testBoard.getDiseaseCount(WASHINGTON, YELLOW));
        assertEquals(0, testBoard.getDiseaseCount(ATLANTA, BLUE));
        assertEquals(0, testBoard.getDiseaseCount(WASHINGTON, BLUE));

        testBoard.infect(MIAMI, 1);
        assertEquals(3, testBoard.getDiseaseCount(MIAMI, YELLOW));
        assertEquals(2, testBoard.getDiseaseCount(BOGOTA, YELLOW));
        assertEquals(2, testBoard.getDiseaseCount(MEXICO_CITY, YELLOW));
        assertEquals(2, testBoard.getDiseaseCount(ATLANTA, YELLOW));
        assertEquals(2, testBoard.getDiseaseCount(WASHINGTON, YELLOW));
        assertEquals(0, testBoard.getDiseaseCount(ATLANTA, BLUE));
        assertEquals(0, testBoard.getDiseaseCount(WASHINGTON, BLUE));

    }

    public void testChainOutbreak() throws Exception {

        testBoard.infect(JOHANNESBURG, 3);
        testBoard.infect(KINSHASA, 3);

        testBoard.infect(JOHANNESBURG, 1);

        assertEquals(3, testBoard.getDiseaseCount(JOHANNESBURG, YELLOW));
        assertEquals(3, testBoard.getDiseaseCount(KINSHASA, YELLOW));
        assertEquals(1, testBoard.getDiseaseCount(LAGOS, YELLOW));
        assertEquals(2, testBoard.getDiseaseCount(KHARTOUM, YELLOW));

        testBoard.infect(KHARTOUM, 2);

        assertEquals(3, testBoard.getDiseaseCount(JOHANNESBURG, YELLOW));
        assertEquals(3, testBoard.getDiseaseCount(KINSHASA, YELLOW));
        assertEquals(3, testBoard.getDiseaseCount(LAGOS, YELLOW));
        assertEquals(3, testBoard.getDiseaseCount(KHARTOUM, YELLOW));
        assertEquals(0, testBoard.getDiseaseCount(SAO_PAULO, YELLOW));
        assertEquals(1, testBoard.getDiseaseCount(CAIRO, YELLOW));

    }

    public void testGameLostFromOutbreak() throws Exception {

        // Test going to exactly 8
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

        // Test going over 8
        testBoard = new Board();

        testBoard.infect(JOHANNESBURG, 3);
        testBoard.infect(KINSHASA, 3);
        testBoard.infect(JOHANNESBURG, 1);      // 2 outbreaks
        testBoard.infect(KHARTOUM, 2);          // 3 outbreaks

        try {
            testBoard.infect(KINSHASA, 1);     // 4 outbreaks, which should make 9 and fail
            assertTrue(false);
        } catch (GameLostException e) {}

    }

    public void testGameLostFromOverInfection() throws Exception{

        // Test going 24, then 25
        testBoard.infect(BAGHDAD, 3);
        testBoard.infect(KARACHI, 3);
        testBoard.infect(KARACHI, 1);   // 2 outbreaks
        testBoard.infect(KARACHI, 1);   // 4 outbreaks

        assertEquals(3, testBoard.getDiseaseCount(BAGHDAD, BLACK));
        assertEquals(3, testBoard.getDiseaseCount(KARACHI, BLACK));
        assertEquals(3, testBoard.getDiseaseCount(TEHRAN, BLACK));
        assertEquals(3, testBoard.getDiseaseCount(RIYADH, BLACK));
        assertEquals(3, testBoard.getDiseaseCount(DELHI, BLACK));
        assertEquals(2, testBoard.getDiseaseCount(MUMBAI, BLACK));
        assertEquals(1, testBoard.getDiseaseCount(MOSCOW, BLACK));
        assertEquals(3, testBoard.getDiseaseCount(CAIRO, BLACK));
        assertEquals(2, testBoard.getDiseaseCount(ISTANBUL, BLACK));

        testBoard.infect(KOLKATA, 1);
        assertEquals(1, testBoard.getDiseaseCount(KOLKATA, BLACK));     // 24 black out at this point

        try {
            testBoard.infect(ALGIERS, 1);
            assertTrue(false);
        } catch (GameLostException e) {}

        // Test going over from less than 24 to more than 24
        testBoard = new Board();

        testBoard.infect(BAGHDAD, 3);
        testBoard.infect(KARACHI, 3);
        testBoard.infect(KARACHI, 1);   // 2 outbreaks
        testBoard.infect(KARACHI, 1);   // 4 outbreaks

        assertEquals(3, testBoard.getDiseaseCount(BAGHDAD, BLACK));
        assertEquals(3, testBoard.getDiseaseCount(KARACHI, BLACK));
        assertEquals(3, testBoard.getDiseaseCount(TEHRAN, BLACK));
        assertEquals(3, testBoard.getDiseaseCount(RIYADH, BLACK));
        assertEquals(3, testBoard.getDiseaseCount(DELHI, BLACK));
        assertEquals(2, testBoard.getDiseaseCount(MUMBAI, BLACK));
        assertEquals(1, testBoard.getDiseaseCount(MOSCOW, BLACK));
        assertEquals(3, testBoard.getDiseaseCount(CAIRO, BLACK));
        assertEquals(2, testBoard.getDiseaseCount(ISTANBUL, BLACK));    // 23 out at this point

        try {
            testBoard.infect(CHENNAI, 3);   // will go to 26, which should lose
            assertTrue(false);
        } catch (GameLostException e) {}

    }

    public void testInitialStation() throws Exception{

        assertTrue(testBoard.hasStation(ATLANTA));
        assertFalse(testBoard.hasStation(WASHINGTON));
        assertEquals(1, testBoard.stationsBuilt());

    }

    public void testAddStation() throws Exception{

        int currentAvail = testBoard.stationsAvailable();

        assertEquals(-1, testBoard.addStation(ATLANTA));
        assertEquals(1, testBoard.stationsBuilt());
        assertEquals(currentAvail, testBoard.stationsAvailable());

        assertEquals( --currentAvail, testBoard.addStation(WASHINGTON));
        assertTrue(testBoard.hasStation(WASHINGTON));
        assertEquals(2, testBoard.stationsBuilt());
        assertEquals(currentAvail, testBoard.stationsAvailable());

        assertEquals(--currentAvail, testBoard.addStation(KINSHASA));
        assertEquals(--currentAvail, testBoard.addStation(MOSCOW));
        assertEquals(--currentAvail, testBoard.addStation(HONG_KONG));
        assertEquals(--currentAvail, testBoard.addStation(MADRID));

        assertEquals(-1, testBoard.addStation(WASHINGTON));

    }

    public void testRemoveStation() throws Exception {

        int currentAvail = testBoard.stationsAvailable();

        testBoard.addStation(WASHINGTON);
        testBoard.addStation(KINSHASA);
        testBoard.addStation(MOSCOW);
        testBoard.addStation(HONG_KONG);
        currentAvail -= 4;

        assertEquals(5, testBoard.stationsBuilt());
        assertEquals(currentAvail, testBoard.stationsAvailable());

        assertEquals(++currentAvail, testBoard.removeStation(WASHINGTON));
        assertEquals(-1, testBoard.removeStation(WASHINGTON));
        assertEquals(4, testBoard.stationsBuilt());

    }

}
